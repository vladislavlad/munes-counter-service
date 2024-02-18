package software.darkmatter.munes.domain.currentUser.api

import org.springframework.stereotype.Component
import software.darkmatter.munes.domain.currentUser.business.CurrentUserInfoApi
import software.darkmatter.munes.domain.userInfo.data.UserInfo
import software.darkmatter.munes.user.api.UserInfoApi
import software.darkmatter.platform.api.http.ServiceApi
import software.darkmatter.platform.assembler.RequestAssembler
import software.darkmatter.platform.assembler.ResponseAssembler
import software.darkmatter.platform.service.Service

@Component
class Api(
    override val requestAssembler: RequestAssembler<Unit, Unit>,
    override val service: Service<Unit, UserInfo>,
    override val responseAssembler: ResponseAssembler<UserInfo, UserInfoApi.Response>,
) : ServiceApi<Unit, UserInfoApi.Response, Unit, UserInfo>(),
    CurrentUserInfoApi
