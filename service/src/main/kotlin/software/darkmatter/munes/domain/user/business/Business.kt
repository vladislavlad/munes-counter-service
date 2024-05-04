package software.darkmatter.munes.domain.user.business

import software.darkmatter.munes.domain.user.data.User
import software.darkmatter.munes.user.api.UserApi
import software.darkmatter.platform.api.http.ServiceCrudApi
import java.util.UUID

typealias UserInfoCrudApi = ServiceCrudApi<Long,
    UserApi.Response, UserApi.CreateRequest, UserApi.UpdateRequest,
    User, UserCreate, UserUpdate>

data class UserCreate(
    val uuid: UUID,
    val username: String,
)

data class UserUpdate(
    val user: User,
)
