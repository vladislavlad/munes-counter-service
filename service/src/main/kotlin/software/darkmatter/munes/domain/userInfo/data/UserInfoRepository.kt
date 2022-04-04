package software.darkmatter.munes.domain.userInfo.data

import org.springframework.data.repository.kotlin.CoroutineSortingRepository
import java.util.UUID

interface UserInfoRepository : CoroutineSortingRepository<UserInfo, Long> {

    suspend fun findByUserUuid(userUuid: UUID): UserInfo?
}
