package software.darkmatter.munes.domain.userInfo.assembler

import arrow.core.right
import org.springframework.stereotype.Component
import software.darkmatter.munes.domain.userInfo.data.UserInfo
import software.darkmatter.munes.user.api.UserInfoApi
import software.darkmatter.platform.assembler.ResponseAssembler

@Component
class ResponseAssembler : ResponseAssembler<UserInfo, UserInfoApi.Response> {

    override suspend fun assemble(business: UserInfo) =
        with(business) {
            UserInfoApi.Response(userUuid, rate, active)
        }.right()
}
