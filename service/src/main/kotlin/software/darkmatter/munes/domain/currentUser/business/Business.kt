package software.darkmatter.munes.domain.currentUser.business

import software.darkmatter.munes.domain.user.data.User
import software.darkmatter.munes.domain.userRate.data.UserRate
import software.darkmatter.platform.api.http.HttpApi
import software.darkmatter.platform.service.Service

interface CurrentUserInfoApi : HttpApi<Unit>
interface CurrentUserInfoService : Service<Unit, CurrentUserInfo>

data class CurrentUserInfo(
    val user: User,
    val userRate: UserRate?,
)
