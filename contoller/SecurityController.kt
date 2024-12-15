package ru.hse.db.routes_app.contoller

import org.springframework.web.bind.annotation.*
import ru.hse.db.routes_app.model.User
import ru.hse.db.routes_app.repository.UserRepository

@RestController
@RequestMapping("/api/routes-provider/security/users")
class SecurityController (
    private val userRepository: UserRepository
) {

    @GetMapping("/all")
    fun getAllUsers() = userRepository.findAll()

    @GetMapping("/user/{id}")
    fun getUserById(@PathVariable id: String) = userRepository.findById(id)

    @PostMapping("/add")
    fun addUser(@RequestBody user: User) = userRepository.save(user)
}
