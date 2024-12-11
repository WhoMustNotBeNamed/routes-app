package ru.hse.db.routes_app.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.hse.db.routes_app.model.Category
import java.util.*

@Repository
interface CategoryRepository : CrudRepository<Category, String>