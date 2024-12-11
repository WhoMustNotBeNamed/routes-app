package ru.hse.db.routes_app.repository

import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.hse.db.routes_app.model.RouteSession

@Repository
interface RouteSessionRepository : CrudRepository<RouteSession, String> {

    @Query("""
        select * 
        from route_session
        where is_finished = false
    """)
    fun findAllByIsFinishedFalse(): List<RouteSession>

    @Query(
        """
        select * 
        from route_session
        where is_finished = true
    """
    )
    fun findAllByIsFinishedTrue(): List<RouteSession>

    @Query(
        """
        select * 
        from route_session
        where user_id = :userId
    """
    )
    fun findAllByUserId(userId: String): List<RouteSession>
}
