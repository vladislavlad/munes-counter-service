package software.darkmatter.munes.api.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import software.darkmatter.munes.domain.currentUser.business.CurrentUserInfoApi
import software.darkmatter.munes.domain.userInfo.business.UserInfoCrudApi
import software.darkmatter.platform.api.handle

@RestController
@RequestMapping("/current-user")
class CurrentUserController(
    private val currentUserInfoApi: CurrentUserInfoApi,
    private val userInfoCrudApi: UserInfoCrudApi,
) {

    @GetMapping
    suspend fun getInfo() = currentUserInfoApi.handle()
}
