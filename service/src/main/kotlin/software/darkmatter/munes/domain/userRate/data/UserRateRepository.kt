package software.darkmatter.munes.domain.userRate.data

import software.darkmatter.platform.data.CoroutineUndeletableCrudSortingRepository

interface UserRateRepository : CoroutineUndeletableCrudSortingRepository<UserRate, Long> {

    suspend fun findByUserIdAndDeletedAtIsNull(userId: Long): UserRate?
}
