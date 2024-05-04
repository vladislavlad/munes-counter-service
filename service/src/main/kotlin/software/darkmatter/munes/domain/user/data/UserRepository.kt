package software.darkmatter.munes.domain.user.data

import software.darkmatter.platform.data.CoroutineUndeletableCrudSortingRepository
import java.util.UUID

interface UserRepository : CoroutineUndeletableCrudSortingRepository<User, Long> {

    suspend fun findByUsernameAndDeletedAtIsNull(username: String): User?

    suspend fun findByUuidAndDeletedAtIsNull(uuid: UUID): User?
}
