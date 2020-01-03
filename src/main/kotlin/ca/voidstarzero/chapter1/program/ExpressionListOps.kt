package ca.voidstarzero.chapter1.program

import ca.voidstarzero.chapter1.ast.ExpressionList
import ca.voidstarzero.chapter1.ast.LastExpList
import ca.voidstarzero.chapter1.ast.PairExpList
import kotlin.math.max

fun ExpressionList.length(): Int {
    return when (this) {
        is PairExpList -> 1 + tail.length()
        is LastExpList -> 1
    }
}

fun ExpressionList.maxargs(): Int {
    return when (this) {
        is PairExpList -> max(head.maxargs(), tail.maxargs())
        is LastExpList -> head.maxargs()
    }
}

fun ExpressionList.interpret(table: Table?): List<IntAndTable> {
    return when (this) {
        is PairExpList -> {
            val (headResult, newTable) = head.interpret(table)
            val result = mutableListOf(IntAndTable(headResult, newTable))
            result.addAll(tail.interpret(newTable))

            result
        }
        is LastExpList -> {
            listOf(head.interpret(table))
        }
    }
}
