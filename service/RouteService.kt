package ru.hse.db.routes_app.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.hse.db.routes_app.model.NewRoute
import ru.hse.db.routes_app.model.RoutePage
import ru.hse.db.routes_app.repository.RouteCategoryRepository
import ru.hse.db.routes_app.repository.RouteCoordinateRepository
import ru.hse.db.routes_app.repository.RouteRepository
import java.util.*

@Service
class RouteService (
    private val routeRepository: RouteRepository,
    private val routeCoordinateRepository: RouteCoordinateRepository,
    private val routeCategoryRepository: RouteCategoryRepository,
    private val reviewRepository: ru.hse.db.routes_app.repository.ReviewRepository
) {

    @Transactional
    fun getRoutePage(routeId: UUID): RoutePage {
        val route = routeRepository.findById(routeId)
        val coordinates = routeCoordinateRepository.findAllByRouteId(routeId)
        val categories = routeCategoryRepository.findAllByRouteId(routeId)
        val reviews = reviewRepository.findAllByRouteId(routeId)

        return RoutePage(route, coordinates, categories, reviews)
    }

    @Transactional
    fun addRoute(newRoute: NewRoute) {
        val route = routeRepository.save(newRoute.route)
        val coordinates = newRoute.coordinates.map { it.copy(routeId = route.id) }
        val categories = newRoute.categories.map { it.copy(routeId = route.id) }

        routeCoordinateRepository.saveAll(coordinates)
        routeCategoryRepository.saveAll(categories)
    }
}