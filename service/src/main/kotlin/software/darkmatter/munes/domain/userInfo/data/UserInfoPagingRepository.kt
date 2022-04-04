package software.darkmatter.munes.domain.userInfo.data

import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.stereotype.Repository
import software.darkmatter.platform.data.PagingRepository

@Repository
class UserInfoPagingRepository(
    override val r2dbcTemplate: R2dbcEntityTemplate
) : PagingRepository<UserInfo, Long> {

    override val klass = UserInfo::class
}
