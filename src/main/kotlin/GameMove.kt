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

fun mapNeededOutcomeInputToGameMove(input: Char, opponentMove: GameMove): GameMove {
    return when (input) {
        'X' -> getLosingMove(opponentMove)
        'Y' -> getDrawMove(opponentMove)
        'Z' -> getWinningMove(opponentMove)
        else -> throw IllegalArgumentException("Ungültige Eingabe: $input")
    }
}

fun mapGameMoveToPoints(input: GameMove): Int {
    return when (input) {
        GameMove.ROCK -> 1
        GameMove.PAPER -> 2
        GameMove.SCISSORS -> 3
        else -> throw IllegalArgumentException("Ungültige Eingabe: $input")
    }
}

fun getLosingMove(opponentGameMove: GameMove): GameMove {
    return when (opponentGameMove) {
        GameMove.ROCK -> GameMove.SCISSORS
        GameMove.PAPER -> GameMove.ROCK
        GameMove.SCISSORS -> GameMove.PAPER
    }
}

fun getWinningMove(opponentGameMove: GameMove): GameMove {
    return when (opponentGameMove) {
        GameMove.ROCK -> GameMove.PAPER
        GameMove.PAPER -> GameMove.SCISSORS
        GameMove.SCISSORS -> GameMove.ROCK
    }
}

fun getDrawMove(opponentGameMove: GameMove): GameMove {
    return when (opponentGameMove) {
        GameMove.ROCK -> GameMove.ROCK
        GameMove.PAPER -> GameMove.PAPER
        GameMove.SCISSORS -> GameMove.SCISSORS
    }
}