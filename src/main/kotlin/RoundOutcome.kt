enum class RoundOutcome {
    WIN,
    DRAW,
    LOSE
}

fun mapRoundOutcomeToPoints(input: RoundOutcome): Int {
    return when (input) {
        RoundOutcome.WIN -> 6
        RoundOutcome.DRAW -> 3
        RoundOutcome.LOSE -> 0
        else -> throw IllegalArgumentException("Ungültige Eingabe: $input")
    }
}