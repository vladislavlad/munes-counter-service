package software.darkmatter.munes.domain.userRate.business

import arrow.core.Either
import software.darkmatter.munes.domain.user.data.User
import software.darkmatter.munes.domain.userRate.data.UserRate
import software.darkmatter.platform.error.BusinessError
import software.darkmatter.platform.service.CrudService

interface UserRateService : CrudService<UserRate, Long, UserRateCreate, UserRateUpdate> {

    suspend fun getByUser(user: User): Either<BusinessError, UserRate>
}
