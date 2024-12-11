package ru.hse.db.routes_app.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.hse.db.routes_app.model.User

@Repository
interface UserRepository : CrudRepository<User, String>