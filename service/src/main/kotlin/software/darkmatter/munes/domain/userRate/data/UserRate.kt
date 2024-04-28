package software.darkmatter.munes.domain.userRate.data

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import software.darkmatter.munes.user.model.Currency
import software.darkmatter.munes.user.model.RateType
import software.darkmatter.platform.data.Model
import software.darkmatter.platform.data.Undeletable
import java.math.BigDecimal
import java.time.OffsetDateTime
import java.util.UUID

@Table("user_rates")
data class UserRate(
    @Id
    override var id: Long? = null,
    val userId: Long,
    var rateType: RateType,
    var rate: BigDecimal,
    var currency: Currency,
    val createdAt: OffsetDateTime,
    var updatedAt: OffsetDateTime,
    override var deletedAt: OffsetDateTime? = null,
    override var deletedBy: UUID? = null,
) : Model<Long>, Undeletable
