package ru.hse.db.routes_app.contoller

import org.springframework.web.bind.annotation.*
import ru.hse.db.routes_app.model.NewRouteSession
import ru.hse.db.routes_app.repository.UserCheckpointRepository
import java.util.*

@RestController
@RequestMapping("/api/routes-provider/users")
class UserController (
    private val routeSessionRepository: ru.hse.db.routes_app.repository.RouteSessionRepository,
    private val userCheckpointRepository: UserCheckpointRepository,
    private val UserService: ru.hse.db.routes_app.service.UserService
) {

    @GetMapping("/route-sessions/all")
    fun getAllRouteSessions() = routeSessionRepository.findAll()

    @GetMapping("/route-sessions/{id}")
    fun getRouteSessionById(@PathVariable id: String) = routeSessionRepository.findById(id)

    @GetMapping("/user/page/{userId}")
    fun getUserPage(@PathVariable userId: String) = UserService.getUserPage(userId)

    @GetMapping("/route-sessions/checkpoints/{id}")
    fun getCheckpointsByRouteSessionId(@PathVariable id: UUID) = userCheckpointRepository.findAllByRouteSessionId(id)

    @PostMapping("/route-sessions/add")
    fun addRouteSession(@RequestBody newRouteSession: NewRouteSession) = UserService.addNewSession(newRouteSession)
}
