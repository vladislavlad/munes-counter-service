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
    val firstName: String? = null,
    val lastName: String? = null,
    val middleName: String? = null,
)

data class UserUpdate(
    val user: User,
    val firstName: String?,
    val lastName: String?,
    val middleName: String?,
)
