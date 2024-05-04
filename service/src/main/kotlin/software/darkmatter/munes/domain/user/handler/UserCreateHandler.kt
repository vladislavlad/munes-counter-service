package software.darkmatter.munes.domain.user.handler

import org.springframework.stereotype.Component
import software.darkmatter.event.cud.user.v1.UserData
import software.darkmatter.munes.domain.user.business.UserCreate
import software.darkmatter.munes.domain.user.business.UserService

@Component
class UserCreateHandler(
    private val userService: UserService,
) {

    suspend fun handle(data: UserData) =
        userService.create(
            UserCreate(
                uuid = data.uuid,
                username = data.username,
            )
        ).map { }
}
