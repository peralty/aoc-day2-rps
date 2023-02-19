data class GameRound (
    val round: Pair<GameMove, GameMove>
) {
    fun getRoundPoints(): Int {
        val roundOutcome = when {
            this.round.second.beats(this.round.first) -> RoundOutcome.WIN
            this.round.second == this.round.first -> RoundOutcome.DRAW
            else -> RoundOutcome.LOSE
        }
        val roundMovePoints = mapGameMoveToPoints(this.round.second)
        val roundOutcomePoints = mapRoundOutcomeToPoints(roundOutcome)
        return roundMovePoints + roundOutcomePoints
    }
}