package sebag.florent.data.repositories

import sebag.florent.domain.model.Badge
import sebag.florent.domain.repositories.BadgeRepository

class BadgeRepositoryImpl : BadgeRepository {

    private var userPostNumber = 0

    override suspend fun incrementUserPostNumber() {
        userPostNumber++
    }

    override suspend fun getUserBadges(): List<Badge> {
        return computeBadgesFromUser(userPostNumber) + addMockBadges()
    }

    private fun computeBadgesFromUser(userPostNumber: Int): List<Badge> = when {
        userPostNumber >= 10 -> listOf(Badge("Super Poster", "You have posted over 10 times!"))
        userPostNumber >= 5 -> listOf(Badge("Frequent Poster", "You have posted over 5 times!"))
        userPostNumber >= 3 -> listOf(Badge("Contributor", "You have posted over 3 times!"))
        userPostNumber >= 1 -> listOf(Badge("First Contribution", "You made your first post!"))
        else -> listOf()
    }

    private fun addMockBadges() = listOf(
        Badge("Contract Signed", "You signed a contract!"),
        Badge("Investor Found", "You found an investor!"),
        Badge("1M Raised", "You raised 1 million in funds!"),
        Badge("Product Launched", "You launched a product!"),
        Badge("Team Built", "You built your team!"),
        Badge("Pitch Delivered", "You delivered your pitch!"),
    )
}