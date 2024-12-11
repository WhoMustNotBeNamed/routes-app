package ru.hse.db.routes_app.repository

import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.hse.db.routes_app.model.RouteCoordinate
import java.util.*

@Repository
interface RouteCoordinateRepository : CrudRepository<RouteCoordinate, String> {

    @Query(
        """
            select * 
            from route_coordinate 
            where route_id = :routeId
        """
    )
    fun findAllByRouteId(routeId: UUID): List<RouteCoordinate>
}
