package software.darkmatter.munes.user.api

import java.math.BigDecimal
import java.util.UUID

object UserInfoApi {

    data class Response(
        val userUuid: UUID,
        var rate: BigDecimal?,
        var active: Boolean,
    )

    data class CreateRequest(
        var rate: BigDecimal?,
    )

    data class UpdateRequest(
        var userInfoId: Long,
        var body: Body,
    ) {

        data class Body(
            var rate: BigDecimal?,
        )
    }
}
