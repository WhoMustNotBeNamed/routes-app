package ru.hse.db.routes_app.model

import com.vividsolutions.jts.geom.Geometry
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import ru.hse.db.routes_app.model.RouteCoordinate.Companion.TABLE_NAME

@Table(TABLE_NAME)
data class RouteCoordinate(
    @Id
    @Column(ID_COLUMN_NAME)
    val id: String,

    @Column(ROUTE_ID_COLUMN_NAME)
    val routeId: String,

    @Column(POINT_COLUMN_NAME)
    val point: Geometry?,

    @Column(ORDER_NUMBER_COLUMN_NAME)
    val orderNumber: Int?
) {
    companion object {
        const val TABLE_NAME = "route_coordinate"

        const val ID_COLUMN_NAME = "id"
        const val ROUTE_ID_COLUMN_NAME = "route_id"
        const val POINT_COLUMN_NAME = "point"
        const val ORDER_NUMBER_COLUMN_NAME = "order_number"
    }
}
