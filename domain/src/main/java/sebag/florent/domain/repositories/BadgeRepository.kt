package sebag.florent.domain.repositories

import sebag.florent.domain.model.Badge

interface BadgeRepository {
    suspend fun getUserBadges(): List<Badge>

    suspend fun incrementUserPostNumber()
}