package ru.hse.db.routes_app.repository

import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.hse.db.routes_app.model.Favorite

@Repository
interface FavoriteRepository : CrudRepository<Favorite, String> {

    @Query(
        """
        select * 
        from favorite 
        where user_id = :userId
        """
    )
    fun findAllByUserId(userId: String): List<Favorite>
}