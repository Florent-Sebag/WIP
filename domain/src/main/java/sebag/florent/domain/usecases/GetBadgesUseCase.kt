package sebag.florent.domain.usecases

import sebag.florent.domain.model.Badge
import sebag.florent.domain.repositories.BadgeRepository

class GetBadgesUseCase(private val badgeRepository: BadgeRepository) {

    suspend operator fun invoke(): List<Badge> = badgeRepository.getUserBadges()
}