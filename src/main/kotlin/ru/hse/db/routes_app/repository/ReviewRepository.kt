package ru.hse.db.routes_app.repository

import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.hse.db.routes_app.model.Review
import java.util.*

@Repository
interface ReviewRepository : CrudRepository<Review, String> {

    @Query(
        """
            select * 
            from review 
            where route_id = :routeId
        """
    )
    fun findAllByRouteId(routeId: UUID): List<Review>
}
