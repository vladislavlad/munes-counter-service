package software.darkmatter.munes.domain.userInfo.business

import software.darkmatter.munes.domain.userInfo.data.UserInfo
import software.darkmatter.munes.user.api.UserInfoApi
import software.darkmatter.munes.user.model.RateType
import software.darkmatter.platform.api.http.ServiceCrudApi
import java.math.BigDecimal
import java.util.UUID

typealias UserInfoCrudApi = ServiceCrudApi<Long,
    UserInfoApi.Response, UserInfoApi.CreateRequest,
    UserInfoApi.UpdateRequest, UserInfo,
    UserInfoCreate, UserInfoUpdate>

data class UserInfoCreate(
    val userUuid: UUID,
    val rateType: RateType?,
    val rate: BigDecimal?,
)

data class UserInfoUpdate(
    val userInfo: UserInfo,
    val rateType: RateType?,
    val rate: BigDecimal?,
    val active: Boolean?,
)
