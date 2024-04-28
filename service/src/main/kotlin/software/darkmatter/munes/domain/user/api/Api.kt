package software.darkmatter.munes.domain.user.api

import org.springframework.stereotype.Component
import software.darkmatter.munes.domain.user.business.UserCreate
import software.darkmatter.munes.domain.user.business.UserInfoCrudApi
import software.darkmatter.munes.domain.user.business.UserService
import software.darkmatter.munes.domain.user.business.UserUpdate
import software.darkmatter.munes.domain.user.data.User
import software.darkmatter.munes.user.api.UserApi
import software.darkmatter.platform.assembler.RequestAssembler
import software.darkmatter.platform.assembler.ResponseAssembler

@Component
class Api(
    override val service: UserService,
    override val responseAssembler: ResponseAssembler<User, UserApi.Response>,
    override val createRequestAssembler: RequestAssembler<UserApi.CreateRequest, UserCreate>,
    override val updateRequestAssembler: RequestAssembler<UserApi.UpdateRequest, UserUpdate>,
) : UserInfoCrudApi() {

    override suspend fun delete(id: Long) = TODO("AA-13")
}
