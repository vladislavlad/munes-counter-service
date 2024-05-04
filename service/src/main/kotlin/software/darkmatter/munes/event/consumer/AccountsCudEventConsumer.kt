package software.darkmatter.munes.event.consumer

import arrow.core.Either
import com.fasterxml.jackson.databind.ObjectMapper
import io.github.oshai.kotlinlogging.KotlinLogging
import io.micrometer.observation.ObservationRegistry
import org.springframework.context.annotation.Bean
import org.springframework.messaging.Message
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import software.darkmatter.event.cud.CudEventSchemaRegistry
import software.darkmatter.event.cud.CudEventType
import software.darkmatter.event.cud.user.v1.UserData
import software.darkmatter.munes.domain.user.handler.UserCreateHandler
import software.darkmatter.munes.domain.user.handler.UserDeleteHandler
import software.darkmatter.munes.domain.user.handler.UserUpdateHandler
import software.darkmatter.platform.error.BusinessError
import software.darkmatter.platform.event.Event
import software.darkmatter.platform.event.KeyAware
import software.darkmatter.platform.event.config.ConsumerProperties
import software.darkmatter.platform.event.consumer.CudEventConsumer
import software.darkmatter.platform.event.cud.CudEvent
import software.darkmatter.platform.event.cud.Operation
import java.util.function.Function

@Component
class AccountsCudEventConsumer(
    private val userCreateHandler: UserCreateHandler,
    private val userUpdateHandler: UserUpdateHandler,
    private val userDeleteHandler: UserDeleteHandler,
//    private val userApplicationCreateHandler: UserApplicationCreateHandler,
//    private val userApplicationDeleteHandler: UserApplicationDeleteHandler,
    override val observationRegistry: ObservationRegistry,
    override val consumerProperties: ConsumerProperties,
    override val objectMapper: ObjectMapper,
) : CudEventConsumer<CudEventType>() {

    override val consumerName: String = "accounts-cud-consumer"

    override val logger = KotlinLogging.logger { }

    override val schemaRegistry = CudEventSchemaRegistry

    @Bean
    fun accountsStream(): Function<Flux<Message<ByteArray>>, Mono<Void>> = consumerFunction(::handlingStrategy)

    @Suppress("UNCHECKED_CAST")
    suspend fun <D : KeyAware> handlingStrategy(event: CudEvent<CudEventType, D>): Either<BusinessError, Unit> =
        when (event.type) {
            Event.Type(CudEventType.User, 1) -> handleUser(event as CudEvent<CudEventType, UserData>)
//            Event.Type(CudEventType.UserApplication, 1) -> handleUserApplication(event as CudEvent<CudEventType, UserApplicationData>)
            else -> Either.Right(Unit)
        }

    private suspend fun handleUser(event: CudEvent<CudEventType, UserData>) =
        when (event.operation) {
            Operation.Create -> userCreateHandler.handle(event.data)
            Operation.Update -> userUpdateHandler.handle(event.data)
            Operation.Delete -> userDeleteHandler.handle(event.data)
        }

//    private suspend fun handleUserApplication(event: CudEvent<CudEventType, UserApplicationData>) =
//        when (event.operation) {
//            Operation.Create -> userApplicationCreateHandler.handle(event.data)
//            Operation.Update -> TODO()
//            Operation.Delete -> userApplicationDeleteHandler.handle(event.data)
//        }
}
