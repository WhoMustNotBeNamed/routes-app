package ru.hse.db.routes_app.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import ru.hse.db.routes_app.model.RouteSession.Companion.TABLE_NAME
import java.time.LocalDateTime

@Table(TABLE_NAME)
data class RouteSession(
    @Id
    @Column(ID_COLUMN_NAME)
    val id: String,

    @Column(USER_ID_COLUMN_NAME)
    val userId: String,

    @Column(ROUTE_ID_COLUMN_NAME)
    val routeId: String,

    @Column(IS_FINISHED_COLUMN_NAME)
    val isFinished: Boolean?,

    @Column(STARTED_AT_COLUMN_NAME)
    val startedAt: LocalDateTime?,

    @Column(ENDED_AT_COLUMN_NAME)
    val endedAt: LocalDateTime?
) {
    companion object {
        const val TABLE_NAME = "route_session"

        const val ID_COLUMN_NAME = "id"
        const val USER_ID_COLUMN_NAME = "user_id"
        const val ROUTE_ID_COLUMN_NAME = "route_id"
        const val IS_FINISHED_COLUMN_NAME = "is_finished"
        const val STARTED_AT_COLUMN_NAME = "started_at"
        const val ENDED_AT_COLUMN_NAME = "ended_at"
    }
}
