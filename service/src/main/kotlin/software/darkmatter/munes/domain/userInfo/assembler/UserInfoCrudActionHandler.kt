package software.darkmatter.munes.domain.userInfo.assembler

import org.springframework.stereotype.Component
import software.darkmatter.munes.domain.userInfo.business.UserInfoCreate
import software.darkmatter.munes.domain.userInfo.business.UserInfoCrudHandler
import software.darkmatter.munes.domain.userInfo.business.UserInfoService
import software.darkmatter.munes.domain.userInfo.business.UserInfoUpdate
import software.darkmatter.munes.domain.userInfo.data.UserInfo
import software.darkmatter.munes.user.api.UserInfoApi
import software.darkmatter.platform.assembler.RequestAssembler
import software.darkmatter.platform.assembler.ResponseAssembler

@Component
class UserInfoCrudActionHandler(
    override val service: UserInfoService,
    override val responseAssembler: ResponseAssembler<UserInfo, UserInfoApi.Response>,
    override val createRequestAssembler: RequestAssembler<UserInfoApi.CreateRequest, UserInfoCreate>,
    override val updateRequestAssembler: RequestAssembler<UserInfoApi.UpdateRequest, UserInfoUpdate>,
) : UserInfoCrudHandler() {

    override suspend fun delete(id: Long) = TODO("AA-13")
}
