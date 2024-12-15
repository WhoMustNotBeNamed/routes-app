package ru.hse.db.routes_app.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.hse.db.routes_app.model.NewRouteSession
import ru.hse.db.routes_app.model.UserPage
import ru.hse.db.routes_app.repository.FavoriteRepository
import ru.hse.db.routes_app.repository.RouteSessionRepository
import ru.hse.db.routes_app.repository.UserCheckpointRepository
import ru.hse.db.routes_app.repository.UserRepository

@Service
class UserService (
    private val userRepository: UserRepository,
    private val favoriteRepository: FavoriteRepository,
    private val routeSessionRepository: RouteSessionRepository,
    private val userCheckpointRepository: UserCheckpointRepository,
) {

    @Transactional
    fun getUserPage(userId: String): UserPage {
        val user = userRepository.findById(userId).orElseThrow()
        val favorites = favoriteRepository.findAllByUserId(userId)
        val routeSessions = routeSessionRepository.findAllByUserId(userId)

        return UserPage(user, favorites, routeSessions)
    }

    @Transactional
    fun addNewSession(newRouteSession: NewRouteSession) {
        val routeSession = routeSessionRepository.save(newRouteSession.routeSession)
        val userCheckpoints = newRouteSession.checkpoints.map { it.copy(routeSessionId = routeSession.id) }

        userCheckpointRepository.saveAll(userCheckpoints)
    }
}