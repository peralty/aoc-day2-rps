import java.io.File

fun main() {
    val gameRounds = parseInput()
    var totalGamePoints = 0
    gameRounds.forEach { round ->
        totalGamePoints = totalGamePoints.plus(round.getRoundPoints())
    }
    println("Mit dieser Strategie wirst du insgesamt $totalGamePoints Punkte machen.")
}

private fun parseInput(): List<GameRound> {
    val file = File("src/main/resources/strategy.txt")
    val allGameRounds = mutableListOf<GameRound>()

    file.forEachLine { line ->
        val splitLine = line.split(" ")
        if (splitLine.size != 2) {
            throw IllegalArgumentException("Ungültige Zeile in Input-File: $line")
        }
        val opponentMove = mapInputToGameMove(splitLine[0].first())
        val playerMove = mapInputToGameMove(splitLine[1].first())

        allGameRounds.add(GameRound(Pair(opponentMove, playerMove)))
    }

    return allGameRounds
}

