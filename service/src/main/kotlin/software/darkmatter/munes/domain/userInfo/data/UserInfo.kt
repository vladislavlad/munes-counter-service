package software.darkmatter.munes.domain.userInfo.data

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import software.darkmatter.munes.user.model.Currency
import software.darkmatter.munes.user.model.RateType
import software.darkmatter.platform.data.Model
import java.math.BigDecimal
import java.util.UUID

@Table("user_info")
data class UserInfo(
    @Id
    override var id: Long? = null,
    val userUuid: UUID,
    var rateType: RateType?,
    var rate: BigDecimal?,
    var currency: Currency?,
    var active: Boolean,
) : Model<Long>
