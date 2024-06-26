package software.darkmatter.munes.domain.user.data

import org.springframework.data.r2dbc.core.R2dbcEntityOperations
import org.springframework.stereotype.Repository
import software.darkmatter.platform.data.PagingUndeletableRepository

@Repository
class UserPagingRepository(
    override val r2dbcOperations: R2dbcEntityOperations
) : PagingUndeletableRepository<User, Long> {

    override val klass = User::class
}
