enum class GameMove {
    ROCK,
    PAPER,
    SCISSORS;

    fun beats(other: GameMove): Boolean {
        return (this == ROCK && other == SCISSORS) ||
                (this == SCISSORS && other == PAPER) ||
                (this == PAPER && other == ROCK)
    }
}

fun mapInputToGameMove(input: Char): GameMove {
    return when (input) {
        'A', 'X' -> GameMove.ROCK
        'B', 'Y' -> GameMove.PAPER
        'C', 'Z' -> GameMove.SCISSORS
        else -> throw IllegalArgumentException("Ungültige Eingabe: $input")
    }
}

fun mapGameMoveToPints(input: GameMove): Int {
    return when (input) {
        GameMove.ROCK -> 1
        GameMove.PAPER -> 2
        GameMove.SCISSORS -> 3
        else -> throw IllegalArgumentException("Ungültige Eingabe: $input")
    }
}