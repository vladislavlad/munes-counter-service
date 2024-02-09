package software.darkmatter.munes.domain.userInfo.data

import org.springframework.data.r2dbc.core.R2dbcEntityOperations
import org.springframework.stereotype.Repository
import software.darkmatter.platform.data.PagingRepository

@Repository
class UserInfoPagingRepository(
    override val r2dbcOperations: R2dbcEntityOperations
) : PagingRepository<UserInfo, Long> {

    override val klass = UserInfo::class
}
