package software.darkmatter.munes.domain.currentUser.business

import arrow.core.flatMap
import org.springframework.stereotype.Service
import software.darkmatter.munes.domain.userInfo.business.UserInfoService
import software.darkmatter.platform.security.context.jwtAuthenticationFromSecurityContext

@Service
class Service(
    private val userInfoService: UserInfoService,
) : CurrentUserInfoService {

    override suspend fun perform(request: Unit) =
        jwtAuthenticationFromSecurityContext()
            .flatMap { userInfoService.getByUserUuid(it.jwt.subject) }
}
