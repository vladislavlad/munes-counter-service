package software.darkmatter.munes.domain.user.handler

import arrow.core.flatMap
import org.springframework.stereotype.Component
import software.darkmatter.event.cud.user.v1.UserData
import software.darkmatter.munes.domain.user.business.UserService

@Component
class UserDeleteHandler(
    private val userService: UserService,
) {

    suspend fun handle(data: UserData) =
        userService.getByUsername(data.username)
            .flatMap { userService.delete(it) }
}
