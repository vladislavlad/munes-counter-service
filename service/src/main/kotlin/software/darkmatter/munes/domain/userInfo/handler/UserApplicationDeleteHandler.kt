package software.darkmatter.munes.domain.userInfo.handler

import org.springframework.stereotype.Component
import software.darkmatter.event.cud.userApplication.v1.UserApplicationData
import software.darkmatter.munes.domain.userInfo.business.UserInfoService
import software.darkmatter.munes.domain.userInfo.business.UserInfoUpdate

@Component
class UserApplicationDeleteHandler(
    private val userInfoService: UserInfoService,
) {

    suspend fun handle(data: UserApplicationData) =
        userInfoService.getByUserUuid(data.userUuid)
            .map {
                userInfoService.update(
                    UserInfoUpdate(
                        userInfo = it,
                        rateType = null,
                        rate = null,
                        active = false,
                    )
                )
            }
            .map { }
}
