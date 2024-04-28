package software.darkmatter.munes.domain.currentUser.business

import arrow.core.left
import arrow.core.raise.either
import arrow.core.right
import org.springframework.stereotype.Service
import software.darkmatter.munes.domain.user.business.UserService
import software.darkmatter.munes.domain.userRate.business.UserRateService
import software.darkmatter.munes.domain.userRate.data.UserRate
import software.darkmatter.platform.error.BusinessError
import software.darkmatter.platform.security.context.jwtAuthenticationFromSecurityContext

@Service
class Service(
    private val userService: UserService,
    private val userRateService: UserRateService,
) : CurrentUserInfoService {

    override suspend fun perform(request: Unit) = either {
        val auth = jwtAuthenticationFromSecurityContext().bind()
        val user = userService.getByUuid(auth.jwt.subject).bind()
        val userRate = userRateService.getByUser(user)
            .fold(
                { rightNullIfNotFound(it) },
                { it.right() }
            ).bind()

        CurrentUserInfo(user, userRate)
    }

    private fun rightNullIfNotFound(it: BusinessError) =
        if (it is BusinessError.EntityNotFound<*>) (null as UserRate?).right()
        else it.left()
}
