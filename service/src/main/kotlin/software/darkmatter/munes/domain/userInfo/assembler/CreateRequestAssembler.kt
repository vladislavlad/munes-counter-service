package software.darkmatter.munes.domain.userInfo.assembler

import org.springframework.stereotype.Component
import software.darkmatter.munes.domain.userInfo.business.UserInfoCreate
import software.darkmatter.munes.user.api.UserInfoApi
import software.darkmatter.platform.assembler.RequestAssembler
import software.darkmatter.platform.security.context.jwtAuthenticationFromSecurityContext

@Component
class CreateRequestAssembler : RequestAssembler<UserInfoApi.CreateRequest, UserInfoCreate> {

    override suspend fun assemble(request: UserInfoApi.CreateRequest) =
        jwtAuthenticationFromSecurityContext()
            .map {
                with(request) {
                    UserInfoCreate(
                        userUuid = it.jwt.subject,
                        rate = rate
                    )
                }
            }
}
