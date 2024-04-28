package software.darkmatter.munes.domain.user.business

import arrow.core.Either
import kotlinx.coroutines.flow.Flow
import org.springframework.data.domain.Pageable
import software.darkmatter.platform.error.BusinessError
import software.darkmatter.platform.service.CrudService
import software.darkmatter.munes.domain.user.data.User
import java.util.UUID

interface UserService : CrudService<User, Long, UserCreate, UserUpdate> {

    suspend fun getByUsername(username: String): Either<BusinessError, User>

    suspend fun getByUuid(uuid: UUID): Either<BusinessError, User>

    suspend fun getFlowWithRoleIn(
        roles: List<String>,
        pageable: Pageable = Pageable.unpaged()
    ): Either<BusinessError, Flow<User>>

    suspend fun countWithRoleIn(roles: List<String>): Either<BusinessError, Long>
}
