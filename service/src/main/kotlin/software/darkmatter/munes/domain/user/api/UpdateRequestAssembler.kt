package software.darkmatter.munes.domain.user.api

import org.springframework.stereotype.Component
import software.darkmatter.munes.domain.user.business.UserService
import software.darkmatter.munes.domain.user.business.UserUpdate
import software.darkmatter.munes.user.api.UserApi
import software.darkmatter.platform.assembler.RequestAssembler

@Component
class UpdateRequestAssembler(
    private val userService: UserService,
) : RequestAssembler<UserApi.UpdateRequest, UserUpdate> {

    override suspend fun assemble(request: UserApi.UpdateRequest) =
        userService.get(request.userInfoId)
            .map {
                UserUpdate(
                    user = it,
                    firstName = request.body.firstName,
                    lastName = request.body.lastName,
                    middleName = request.body.middleName,
                )
            }
}
