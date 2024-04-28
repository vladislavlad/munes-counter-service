package software.darkmatter.munes.domain.currentUser.api

import org.springframework.stereotype.Component
import software.darkmatter.munes.domain.currentUser.business.CurrentUserInfo
import software.darkmatter.munes.domain.currentUser.business.CurrentUserInfoApi
import software.darkmatter.munes.user.api.CurrentUserApi
import software.darkmatter.platform.api.http.ServiceApi
import software.darkmatter.platform.assembler.RequestAssembler
import software.darkmatter.platform.assembler.ResponseAssembler
import software.darkmatter.platform.service.Service

@Component
class Api(
    override val requestAssembler: RequestAssembler<Unit, Unit>,
    override val service: Service<Unit, CurrentUserInfo>,
    override val responseAssembler: ResponseAssembler<CurrentUserInfo, CurrentUserApi.Response>,
) : ServiceApi<Unit, CurrentUserApi.Response, Unit, CurrentUserInfo>(),
    CurrentUserInfoApi
