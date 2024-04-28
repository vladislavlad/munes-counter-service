package software.darkmatter.munes.domain.user.business

import arrow.core.right
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import software.darkmatter.munes.domain.user.data.User
import software.darkmatter.munes.domain.user.data.UserRepository
import software.darkmatter.platform.business.BusinessCheck
import software.darkmatter.platform.business.businessChecks
import software.darkmatter.platform.business.onRight
import software.darkmatter.platform.data.PagingRepository
import software.darkmatter.platform.error.uniqueConstraintConflict
import software.darkmatter.platform.security.service.AuthCrudService
import software.darkmatter.platform.syntax.leftIfNull
import java.time.OffsetDateTime
import java.util.UUID

@Service
class Service(
    private val repository: UserRepository,
    pagingRepository: PagingRepository<User, Long>,
) : AuthCrudService<User, Long, UserCreate, UserUpdate>(repository, pagingRepository),
    UserService {

    override suspend fun getByUsername(username: String) = repository.findByUsername(username).leftIfNull { notFound }

    override suspend fun getByUuid(uuid: UUID) = repository.findByUuid(uuid).leftIfNull { notFound }

    override suspend fun getFlowWithRoleIn(roles: List<String>, pageable: Pageable) =
        repository.findAllWithRoleIn(roles, pageable).right()

    override suspend fun countWithRoleIn(roles: List<String>) =
        repository.countWithRoleIn(roles).right()

    override suspend fun createEntity(businessCreate: UserCreate): User {
        val now = OffsetDateTime.now()
        return User(
            uuid = businessCreate.uuid,
            username = businessCreate.username,
            firstName = businessCreate.firstName,
            lastName = businessCreate.lastName,
            middleName = businessCreate.middleName,
            active = true,
            createdAt = now,
            updatedAt = now,
        )
    }

    override suspend fun updateEntity(businessUpdate: UserUpdate): User =
        with(businessUpdate.user) {
            firstName = businessUpdate.firstName
            lastName = businessUpdate.lastName
            middleName = businessUpdate.middleName
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
