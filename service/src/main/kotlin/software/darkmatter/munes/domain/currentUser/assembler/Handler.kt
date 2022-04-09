package software.darkmatter.munes.domain.currentUser.assembler

import org.springframework.stereotype.Component
import software.darkmatter.munes.domain.currentUser.business.CurrentUserInfoHandler
import software.darkmatter.munes.domain.userInfo.data.UserInfo
import software.darkmatter.munes.user.api.UserInfoApi
import software.darkmatter.platform.assembler.RequestAssembler
import software.darkmatter.platform.assembler.ResponseAssembler
import software.darkmatter.platform.handler.ServiceActionHandler
import software.darkmatter.platform.service.Service

@Component
class Handler(
    override val requestAssembler: RequestAssembler<Unit, Unit>,
    override val service: Service<Unit, UserInfo>,
    override val responseAssembler: ResponseAssembler<UserInfo, UserInfoApi.Response>,
) : ServiceActionHandler<Unit, UserInfoApi.Response, Unit, UserInfo>(),
    CurrentUserInfoHandler
