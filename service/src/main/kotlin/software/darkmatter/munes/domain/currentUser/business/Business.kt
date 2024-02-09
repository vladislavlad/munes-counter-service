package software.darkmatter.munes.domain.currentUser.business

import software.darkmatter.munes.domain.userInfo.data.UserInfo
import software.darkmatter.platform.api.http.HttpApi
import software.darkmatter.platform.service.Service

interface CurrentUserInfoApi : HttpApi<Unit>
interface CurrentUserInfoService : Service<Unit, UserInfo>
