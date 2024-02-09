package software.darkmatter.munes.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import software.darkmatter.munes.domain.currentUser.business.CurrentUserInfoApi
import software.darkmatter.munes.domain.userInfo.business.UserInfoCrudApi
import software.darkmatter.munes.user.api.UserInfoApi
import software.darkmatter.platform.api.handle

@RestController
@RequestMapping("/current-user")
class CurrentUserController(
    private val currentUserInfoApi: CurrentUserInfoApi,
    private val userInfoCrudApi: UserInfoCrudApi,
) {

    @GetMapping
    suspend fun getInfo() = currentUserInfoApi.handle()

    @PostMapping
    suspend fun register() = userInfoCrudApi.create(
        UserInfoApi.CreateRequest(null)
    )
}
