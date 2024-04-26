package software.darkmatter.munes.user.api

import software.darkmatter.munes.user.model.Currency
import software.darkmatter.munes.user.model.RateType
import java.math.BigDecimal
import java.util.UUID

object UserInfoApi {

    data class Response(
        val userUuid: UUID,
        var rate: BigDecimal?,
        var active: Boolean,
    )

    data class CreateRequest(
        var rateType: RateType,
        var rate: BigDecimal,
        var currency: Currency,
    )

    data class UpdateRequest(
        var userInfoId: Long,
        var body: Body,
    ) {

        data class Body(
            var rateType: RateType,
            var rate: BigDecimal,
        )
    }
}
