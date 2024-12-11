package ru.hse.db.routes_app.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import ru.hse.db.routes_app.model.Category.Companion.TABLE_NAME


@Table(TABLE_NAME)
data class Category(
    @Id
    @Column(CATEGORY_NAME_COLUMN_NAME)
    val categoryName: String
) {
    companion object {
        const val TABLE_NAME = "category"

        const val CATEGORY_NAME_COLUMN_NAME = "category_name"
    }
}
