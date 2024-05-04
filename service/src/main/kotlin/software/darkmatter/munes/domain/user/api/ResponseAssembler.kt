package software.darkmatter.munes.domain.user.api

import arrow.core.Either
import arrow.core.right
import org.springframework.stereotype.Component
import software.darkmatter.munes.domain.user.data.User
import software.darkmatter.munes.user.api.UserApi
import software.darkmatter.platform.assembler.ResponseAssembler
import software.darkmatter.platform.error.BusinessError

@Component
class ResponseAssembler : ResponseAssembler<User, UserApi.Response> {

    override suspend fun assemble(business: User): Either<BusinessError, UserApi.Response> =
        UserApi.Response(
            userUuid = business.uuid,
            username = business.username,
            active = business.active
        ).right()
}
