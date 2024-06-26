package software.darkmatter.munes.domain.userRate.data

import org.springframework.data.r2dbc.core.R2dbcEntityOperations
import org.springframework.stereotype.Repository
import software.darkmatter.platform.data.PagingUndeletableRepository

@Repository
class UserRatePagingRepository(
    override val r2dbcOperations: R2dbcEntityOperations
) : PagingUndeletableRepository<UserRate, Long> {

    override val klass = UserRate::class
}
