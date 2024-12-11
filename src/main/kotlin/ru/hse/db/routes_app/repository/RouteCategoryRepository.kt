package ru.hse.db.routes_app.repository

import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.hse.db.routes_app.model.RouteCategory
import java.util.UUID

@Repository
interface RouteCategoryRepository : CrudRepository<RouteCategory, String> {

    @Query(
        """
            select * 
            from route_category 
            where route_id = :routeId
        """
    )
    fun findAllByRouteId(routeId: UUID): List<RouteCategory>
}
