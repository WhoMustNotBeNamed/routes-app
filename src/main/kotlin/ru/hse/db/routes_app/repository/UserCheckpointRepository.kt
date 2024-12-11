package ru.hse.db.routes_app.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.hse.db.routes_app.model.UserCheckpoint

@Repository
interface UserCheckpointRepository : CrudRepository<UserCheckpoint, String> {

    fun findAllByRouteSessionId(routeSessionId: String): List<UserCheckpoint>
}
