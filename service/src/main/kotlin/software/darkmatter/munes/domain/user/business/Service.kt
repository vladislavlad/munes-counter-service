package software.darkmatter.munes.domain.user.business

import org.springframework.stereotype.Service
import software.darkmatter.munes.domain.user.data.User
import software.darkmatter.munes.domain.user.data.UserRepository
import software.darkmatter.platform.business.BusinessCheck
import software.darkmatter.platform.business.businessChecks
import software.darkmatter.platform.business.onRight
import software.darkmatter.platform.data.PagingUndeletableRepository
import software.darkmatter.platform.error.uniqueConstraintConflict
import software.darkmatter.platform.security.service.AuthUndeletableCrudService
import software.darkmatter.platform.syntax.leftIfNull
import java.time.OffsetDateTime
import java.util.UUID

@Service
class Service(
    private val repository: UserRepository,
    pagingRepository: PagingUndeletableRepository<User, Long>,
) : AuthUndeletableCrudService<User, Long, UserCreate, UserUpdate>(repository, pagingRepository),
    UserService {

    override suspend fun getByUsername(username: String) =
        repository.findByUsernameAndDeletedAtIsNull(username).leftIfNull { notFound }

    override suspend fun getByUuid(uuid: UUID) =
        repository.findByUuidAndDeletedAtIsNull(uuid).leftIfNull { notFound }

    override suspend fun createEntity(businessCreate: UserCreate): User {
        val now = OffsetDateTime.now()
        return User(
            uuid = businessCreate.uuid,
            username = businessCreate.username,
            active = true,
            createdAt = now,
            updatedAt = now,
        )
    }

    override suspend fun updateEntity(businessUpdate: UserUpdate): User =
        with(businessUpdate.user) {
            this
        }

    override val checksOnCreate = businessChecks(
        onRight(
            check = ::getByUsername,
            accessor = UserCreate::username,
            error = { uniqueConstraintConflict("Username is already used") }
        )
    )

    override val checksOnUpdate = emptyList<BusinessCheck<UserUpdate>>()

    override fun entityClass() = User::class
}
