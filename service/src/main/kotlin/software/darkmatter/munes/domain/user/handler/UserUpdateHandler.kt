package software.darkmatter.munes.domain.user.handler

import arrow.core.flatMap
import org.springframework.stereotype.Component
import software.darkmatter.event.cud.user.v1.UserData
import software.darkmatter.munes.domain.user.business.UserService
import software.darkmatter.munes.domain.user.business.UserUpdate

@Component
class UserUpdateHandler(
    private val userService: UserService,
) {

    suspend fun handle(data: UserData) =
        userService.getByUsername(data.username)
            .flatMap {
                userService.update(
                    UserUpdate(
                        user = it,
                    )
                )
            }.map { }
}
