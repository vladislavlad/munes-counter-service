package software.darkmatter.munes.domain.currentUser.business

import software.darkmatter.munes.domain.userInfo.data.UserInfo
import software.darkmatter.platform.handler.ActionHandler
import software.darkmatter.platform.service.Service
import java.util.UUID

typealias GetCurrentUserInfoHandler = ActionHandler<Unit>
typealias GetCurrentUserInfoService = Service<Unit, UserInfo>

data class GetCurrentUserRequest(
    val userUuid: UUID
)
