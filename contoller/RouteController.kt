package ru.hse.db.routes_app.contoller

import org.springframework.web.bind.annotation.*
import ru.hse.db.routes_app.repository.RouteRepository
import java.util.*

@RestController
@RequestMapping("/api/routes-provider/routes")
class RouteController(
    private val routeRepository: RouteRepository,
    private val routeService: ru.hse.db.routes_app.service.RouteService
) {

    @GetMapping("/all")
    fun getAllRoutes() = routeRepository.findAll()

    @GetMapping("/category/{categoryName}")
    fun getRoutesByCategory(@PathVariable categoryName: String) = routeRepository.findAllByCategory(categoryName)

    @GetMapping("/route/page/{routeId}")
    fun getRoutePage(@PathVariable routeId: String) = routeService.getRoutePage(UUID.fromString(routeId))

    @PostMapping("/add")
    fun addRoute(@RequestBody newRoute: ru.hse.db.routes_app.model.NewRoute) = routeService.addRoute(newRoute)
}
