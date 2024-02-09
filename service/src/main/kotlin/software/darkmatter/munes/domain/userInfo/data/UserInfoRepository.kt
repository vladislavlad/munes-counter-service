package software.darkmatter.munes.domain.userInfo.data

import software.darkmatter.platform.data.CoroutineCrudSortingRepository
import java.util.UUID

interface UserInfoRepository : CoroutineCrudSortingRepository<UserInfo, Long> {

    suspend fun findByUserUuid(userUuid: UUID): UserInfo?
}
