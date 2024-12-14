package ru.hse.db.routes_app.repository

import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.hse.db.routes_app.model.UserCheckpoint
import java.util.*

@Repository
interface UserCheckpointRepository : CrudRepository<UserCheckpoint, String> {

    @Query(
        """
        select * 
        from user_checkpoint 
        where route_session_id = :routeSessionId
        """
    )
    fun findAllByRouteSessionId(routeSessionId: UUID): List<UserCheckpoint>
}
