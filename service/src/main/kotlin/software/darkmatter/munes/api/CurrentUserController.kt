package software.darkmatter.munes.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import software.darkmatter.munes.domain.currentUser.business.GetCurrentUserInfoHandler
import software.darkmatter.munes.domain.userInfo.business.UserInfoCrudHandler
import software.darkmatter.munes.user.api.UserInfoApi

@RestController
@RequestMapping("/current-user")
class CurrentUserController(
    private val handler: GetCurrentUserInfoHandler,
    private val userInfoCrudHandler: UserInfoCrudHandler,
) {

    @GetMapping
    suspend fun getInfo() = handler.handle(Unit)

    @PostMapping
    suspend fun register() = userInfoCrudHandler.create(
        UserInfoApi.CreateRequest(null)
    )
}
