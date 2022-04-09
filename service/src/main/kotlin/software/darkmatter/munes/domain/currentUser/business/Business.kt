package software.darkmatter.munes.domain.currentUser.business

import software.darkmatter.munes.domain.userInfo.data.UserInfo
import software.darkmatter.platform.handler.ActionHandler
import software.darkmatter.platform.service.Service

interface CurrentUserInfoHandler : ActionHandler<Unit>
interface CurrentUserInfoService : Service<Unit, UserInfo>
