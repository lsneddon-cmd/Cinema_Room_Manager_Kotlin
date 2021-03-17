package cinema

import java.lang.Math.floor
import kotlin.math.roundToInt

fun main() {
    printPotentialIncome(calculatePotentialIncome(collectRows(), collectCols()))

//    printCinemaVisualization(8, 7)
}

fun printPotentialIncome(value: Int): Unit {
    println("Total income:")
    println("\$${value}")
}

fun calculatePotentialIncome(rows: Int, cols: Int): Int {
    if (rows * cols <= 60) {
        return calculateSmallRoomIncome(rows, cols)
    } else {
        return calculateLargeRoomIncome(rows, cols)
    }
}

fun calculateLargeRoomIncome(rows: Int, cols: Int): Int {
    if (rows % 2 == 0) {
        return calculateEvenNumberedLargeRoom(rows, cols)
    } else {
        return calculateOddNumberedLargeRoom(rows, cols)
    }
}

fun calculateOddNumberedLargeRoom(rows: Int, cols: Int): Int {
    val frontHalf: Int = kotlin.math.floor(rows.toDouble() / 2).roundToInt() * cols * 10
    val backHalf: Int = kotlin.math.floor(rows.toDouble() / 2 + 1).roundToInt() * cols * 8
    return frontHalf + backHalf
}

fun calculateEvenNumberedLargeRoom(rows: Int, cols: Int): Int {
    val frontHalf: Int = rows / 2 * cols * 10
    val backHalf: Int = rows / 2 * cols * 8
    return frontHalf + backHalf
}

private fun calculateSmallRoomIncome(rows: Int, cols: Int) = rows * cols * 10

fun collectRows(): Int {
    println("Enter the number of rows:")
    return readLine()!!.toInt()
}

fun collectCols(): Int {
    println("Enter the number of seats in each row")
    return readLine()!!.toInt()
}

fun printCinemaVisualization(cols: Int, rows: Int): Unit {
    println("Cinema:")
    print(" ")
    printColHeader(cols)
    printRows(rows, cols)
}


// Stage 1 methods
fun printColHeader(cols: Int): Unit {
    for(col in 1..cols) {
        print(" $col")
    }
    println()
}

fun printRows(rows: Int, cols: Int): Unit {
    for(row in 1..rows) {
        println("$row " + "S ".repeat(cols - 1) + "S")
    }
}