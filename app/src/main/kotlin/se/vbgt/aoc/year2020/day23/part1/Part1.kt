package se.vbgt.aoc.year2020.day23.part1

import se.vbgt.aoc.year2020.day23.common.createState
import se.vbgt.aoc.year2020.day23.common.moveCupsManyTimes

fun part1(cupLabels: List<Int>, numberOfCrabMoves: Int): String {
    println("===== Part1 ====")

    val state = createState(cupLabels)
    println("cupLabels ${cupLabels} gives state: ${state}")

    val finalstate = moveCupsManyTimes(state, numberOfCrabMoves)
   
    val resultCupLabels = getCupsAfterCup1ButNot1(finalstate.cupCircle)

    println("state after ${numberOfCrabMoves} moves: ${finalstate}")

    return resultCupLabels.joinToString(separator = "")
}

/**
 * After the crab is done, what order will the cups be in? Starting after the cup labeled 1,
 * collect the other cups' labels clockwise into a single string with no extra characters;
 * each number except 1 should appear exactly once.
 */
private fun getCupsAfterCup1ButNot1(cupCircle: Map<Int, Int>): List<Int> {
    val result = mutableListOf<Int>()

    // get whatever the key 1 is pointing to
    var currentCup = cupCircle[1]!!

    while (currentCup != 1) { // when currentCup is 1, we looped around the circle.
        result.add(currentCup)
        currentCup = cupCircle[currentCup]!!
    }

    return result
}

