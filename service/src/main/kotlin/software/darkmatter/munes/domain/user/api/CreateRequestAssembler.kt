package software.darkmatter.munes.domain.user.api

import org.springframework.stereotype.Component
import software.darkmatter.munes.domain.user.business.UserCreate
import software.darkmatter.munes.user.api.UserApi
import software.darkmatter.platform.assembler.RequestAssembler
import software.darkmatter.platform.security.context.jwtAuthenticationFromSecurityContext

@Component
class CreateRequestAssembler : RequestAssembler<UserApi.CreateRequest, UserCreate> {

    override suspend fun assemble(request: UserApi.CreateRequest) =
        jwtAuthenticationFromSecurityContext()
            .map {
                UserCreate(
                    uuid = it.jwt.subject,
                    username = request.username,
                )
            }
}
