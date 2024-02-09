package software.darkmatter.munes.domain.userInfo.business

import org.springframework.stereotype.Service
import software.darkmatter.munes.domain.userInfo.data.UserInfo
import software.darkmatter.munes.domain.userInfo.data.UserInfoPagingRepository
import software.darkmatter.munes.domain.userInfo.data.UserInfoRepository
import software.darkmatter.platform.business.BusinessChecks
import software.darkmatter.platform.business.businessChecks
import software.darkmatter.platform.business.onRight
import software.darkmatter.platform.error.uniqueConstraintConflict
import software.darkmatter.platform.security.service.AuthCrudService
import software.darkmatter.platform.syntax.leftIfNull
import java.util.UUID

@Service
class Service(
    private val repository: UserInfoRepository,
    pagingRepository: UserInfoPagingRepository,
) : AuthCrudService<UserInfo, Long, UserInfoCreate, UserInfoUpdate>(repository, pagingRepository),
    UserInfoService {

    override suspend fun getByUserUuid(userUuid: UUID) =
        repository.findByUserUuid(userUuid)
            .leftIfNull { notFound }

    override suspend fun createEntity(businessCreate: UserInfoCreate) =
        UserInfo(
            userUuid = businessCreate.userUuid,
            rate = businessCreate.rate,
            active = true,
        )

    override suspend fun updateEntity(businessUpdate: UserInfoUpdate) =
        with(businessUpdate.userInfo) {
            rate = businessUpdate.rate
            this
        }

    override val checksOnCreate = businessChecks(
        onRight(
            check = ::getByUserUuid,
            accessor = UserInfoCreate::userUuid,
            error = { uniqueConstraintConflict("UserInfo already created") }
        )
    )

    override val checksOnUpdate: BusinessChecks<UserInfoUpdate> = businessChecks()

    override fun entityClass() = UserInfo::class
}
