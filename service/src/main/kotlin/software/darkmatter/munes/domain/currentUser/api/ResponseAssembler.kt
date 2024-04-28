package software.darkmatter.munes.domain.currentUser.api

import arrow.core.Either
import arrow.core.right
import org.springframework.stereotype.Component
import software.darkmatter.munes.domain.currentUser.business.CurrentUserInfo
import software.darkmatter.munes.user.api.CurrentUserApi
import software.darkmatter.platform.assembler.ResponseAssembler
import software.darkmatter.platform.error.BusinessError

@Component
class ResponseAssembler : ResponseAssembler<CurrentUserInfo, CurrentUserApi.Response> {

    override suspend fun assemble(business: CurrentUserInfo): Either<BusinessError, CurrentUserApi.Response> =
        CurrentUserApi.Response(
            userUuid = business.user.uuid,
            username = business.user.username,
            firstName = business.user.firstName,
            rateType = business.userRate?.rateType,
            rate = business.userRate?.rate,
            currency = business.userRate?.currency,
            active = business.user.active,
        ).right()
}
