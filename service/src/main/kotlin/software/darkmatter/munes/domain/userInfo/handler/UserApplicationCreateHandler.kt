package software.darkmatter.munes.domain.userInfo.handler

import org.springframework.stereotype.Component
import software.darkmatter.event.cud.userApplication.v1.UserApplicationData
import software.darkmatter.munes.domain.userInfo.business.UserInfoCreate
import software.darkmatter.munes.domain.userInfo.business.UserInfoService

@Component
class UserApplicationCreateHandler(
    private val userInfoService: UserInfoService,
) {

    suspend fun handle(data: UserApplicationData) =
        userInfoService.create(
            UserInfoCreate(
                userUuid = data.userUuid,
                rateType = null,
                rate = null,
            )
        ).map { }
}
