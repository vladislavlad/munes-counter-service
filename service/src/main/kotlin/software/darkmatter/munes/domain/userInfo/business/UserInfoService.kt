package software.darkmatter.munes.domain.userInfo.business

import arrow.core.Either
import software.darkmatter.munes.domain.userInfo.data.UserInfo
import software.darkmatter.platform.error.BusinessError
import software.darkmatter.platform.service.CrudService
import java.util.UUID

interface UserInfoService : CrudService<UserInfo, Long, UserInfoCreate, UserInfoUpdate> {

    suspend fun getByUserUuid(userUuid: UUID): Either<BusinessError, UserInfo>
}
