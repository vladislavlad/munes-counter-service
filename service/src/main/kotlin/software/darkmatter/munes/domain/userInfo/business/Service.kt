package software.darkmatter.munes.domain.userInfo.business

import arrow.core.left
import org.springframework.stereotype.Service
import software.darkmatter.munes.domain.userInfo.data.UserInfo
import software.darkmatter.munes.domain.userInfo.data.UserInfoPagingRepository
import software.darkmatter.munes.domain.userInfo.data.UserInfoRepository
import software.darkmatter.platform.error.BusinessError
import software.darkmatter.platform.error.ErrorType
import software.darkmatter.platform.service.AbstractCrudService
import software.darkmatter.platform.syntax.UnitRight
import software.darkmatter.platform.syntax.leftIfNull
import java.util.UUID

@Service
class Service(
    private val repository: UserInfoRepository,
    pagingRepository: UserInfoPagingRepository,
) : AbstractCrudService<UserInfo, Long, UserInfoCreate, UserInfoUpdate>(repository, pagingRepository),
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

    override suspend fun checkUniqueOnCreate(businessCreate: UserInfoCreate) =
        getByUserUuid(businessCreate.userUuid)
            .fold(
                { UnitRight },
                { BusinessError.FlowConflict("UserInfo already created", ErrorType.UniqueConstraintConflict).left() }
            )

    override suspend fun checkUniqueOnUpdate(businessUpdate: UserInfoUpdate) = UnitRight

    override fun entityClass() = UserInfo::class
}
