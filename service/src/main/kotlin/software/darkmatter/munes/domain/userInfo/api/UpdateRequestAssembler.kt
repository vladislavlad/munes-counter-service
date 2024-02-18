package software.darkmatter.munes.domain.userInfo.api

import org.springframework.stereotype.Component
import software.darkmatter.munes.domain.userInfo.business.UserInfoService
import software.darkmatter.munes.domain.userInfo.business.UserInfoUpdate
import software.darkmatter.munes.user.api.UserInfoApi
import software.darkmatter.platform.assembler.RequestAssembler

@Component
class UpdateRequestAssembler(
    private val userInfoService: UserInfoService,
) : RequestAssembler<UserInfoApi.UpdateRequest, UserInfoUpdate> {

    override suspend fun assemble(request: UserInfoApi.UpdateRequest) =
        userInfoService.get(request.userInfoId)
            .map {
                UserInfoUpdate(
                    userInfo = it,
                    rateType = request.body.rateType,
                    rate = request.body.rate,
                    active = null,
                )
            }
}
