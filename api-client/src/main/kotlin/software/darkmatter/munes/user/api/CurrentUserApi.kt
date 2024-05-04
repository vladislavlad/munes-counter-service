package software.darkmatter.munes.user.api

import software.darkmatter.munes.user.model.Currency
import software.darkmatter.munes.user.model.RateType
import java.math.BigDecimal
import java.util.UUID

object CurrentUserApi {

    data class Response(
        val userUuid: UUID,
        val username: String,
        val rateType: RateType?,
        val rate: BigDecimal?,
        val currency: Currency?,
        val active: Boolean,
    )
}
