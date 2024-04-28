package software.darkmatter.munes.user.api

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size
import software.darkmatter.munes.user.model.RateType
import java.math.BigDecimal
import java.util.UUID

object UserApi {

    data class Response(
        val userUuid: UUID,
        var username: String,
        val firstName: String?,
        val lastName: String?,
        val middleName: String?,
        var active: Boolean,
    )

    data class CreateRequest(
        @param:Size(min = 3, max = 32)
        var username: String,
    )

    data class UpdateRequest(
        var userInfoId: Long,
        var body: Body,
    ) {

        data class Body(
            @param:NotEmpty
            val firstName: String?,
            @param:NotEmpty
            val lastName: String?,
            val middleName: String?,
            var rateType: RateType,
            var rate: BigDecimal,
        )
    }
}
