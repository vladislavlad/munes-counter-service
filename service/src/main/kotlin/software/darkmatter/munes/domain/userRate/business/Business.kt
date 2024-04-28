package software.darkmatter.munes.domain.userRate.business

import software.darkmatter.munes.domain.user.data.User
import software.darkmatter.munes.domain.userRate.data.UserRate
import software.darkmatter.munes.user.model.Currency
import software.darkmatter.munes.user.model.RateType
import java.math.BigDecimal

data class UserRateCreate(
    val user: User,
    val rateType: RateType,
    val rate: BigDecimal,
    val currency: Currency,
)

data class UserRateUpdate(
    val userRate: UserRate,
    val rateType: RateType,
    val rate: BigDecimal,
    val currency: Currency,
)
