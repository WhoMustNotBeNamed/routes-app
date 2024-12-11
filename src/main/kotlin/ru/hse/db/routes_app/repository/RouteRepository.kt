package ru.hse.db.routes_app.repository

import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.hse.db.routes_app.model.Route
import java.util.*

@Repository
interface RouteRepository : CrudRepository<Route, String> {

    @Query(
        """
            select * 
            from route 
            where id = :id
        """
    )
    fun findById(id: UUID): Route

    @Query(
        """
            select * 
            from route 
            where id in (
                select route_id 
                from route_category 
                where category_name = :category
            )
        """
    )
    fun findAllByCategory(category: String): List<Route>
}
