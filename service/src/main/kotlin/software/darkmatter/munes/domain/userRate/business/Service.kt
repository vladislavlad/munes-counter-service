package software.darkmatter.munes.domain.userRate.business

import arrow.core.Either
import org.springframework.stereotype.Service
import software.darkmatter.munes.domain.user.data.User
import software.darkmatter.munes.domain.userRate.data.UserRate
import software.darkmatter.munes.domain.userRate.data.UserRateRepository
import software.darkmatter.platform.business.BusinessCheck
import software.darkmatter.platform.data.PagingRepository
import software.darkmatter.platform.error.BusinessError
import software.darkmatter.platform.security.service.AuthCrudService
import software.darkmatter.platform.syntax.leftIfNull
import java.time.OffsetDateTime

@Service
class Service(
    private val repository: UserRateRepository,
    pagingRepository: PagingRepository<UserRate, Long>,
) : AuthCrudService<UserRate, Long, UserRateCreate, UserRateUpdate>(repository, pagingRepository),
    UserRateService {

    override suspend fun getByUser(user: User): Either<BusinessError, UserRate> =
        repository.findByUserId(user.id!!)
            .leftIfNull { notFound }

    override suspend fun createEntity(businessCreate: UserRateCreate): UserRate {
        val now = OffsetDateTime.now()
        return UserRate(
            userId = businessCreate.user.id!!,
            rateType = businessCreate.rateType,
            rate = businessCreate.rate,
            currency = businessCreate.currency,
            createdAt = now,
            updatedAt = now,
        )
    }

    override val checksOnCreate = emptyList<BusinessCheck<UserRateCreate>>()

    override suspend fun updateEntity(businessUpdate: UserRateUpdate): UserRate =
        with(businessUpdate.userRate) {
            rateType = businessUpdate.rateType
            rate = businessUpdate.rate
            currency = businessUpdate.currency
            this
        }

    override val checksOnUpdate = emptyList<BusinessCheck<UserRateUpdate>>()

    override fun entityClass() = UserRate::class
}
