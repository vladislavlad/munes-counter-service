package software.darkmatter.munes.domain.user.business

import arrow.core.Either
import software.darkmatter.munes.domain.user.data.User
import software.darkmatter.platform.error.BusinessError
import software.darkmatter.platform.service.CrudService
import java.util.UUID

interface UserService : CrudService<User, Long, UserCreate, UserUpdate> {

    suspend fun getByUsername(username: String): Either<BusinessError, User>

    suspend fun getByUuid(uuid: UUID): Either<BusinessError, User>
}
