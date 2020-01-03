package ca.voidstarzero.chapter1.program

import ca.voidstarzero.chapter1.ast.DivExp
import ca.voidstarzero.chapter1.ast.ExprSeqExp
import ca.voidstarzero.chapter1.ast.Expression
import ca.voidstarzero.chapter1.ast.IdExp
import ca.voidstarzero.chapter1.ast.MinusExp
import ca.voidstarzero.chapter1.ast.NumExp
import ca.voidstarzero.chapter1.ast.PlusExp
import ca.voidstarzero.chapter1.ast.TimesExp
import kotlin.math.max

fun Expression.maxargs(): Int {
    return when (this) {
        is ExprSeqExp -> max(statement.maxargs(), expr.maxargs())
        else -> 0
    }
}

fun Expression.interpret(table: Table?): IntAndTable {
    return when (this) {
        is IdExp -> IntAndTable(table?.lookup(id)!!, table)
        is NumExp -> IntAndTable(num, table)
        is PlusExp -> {
            val (leftValue, newTable) = left.interpret(table)
            val (rightValue, resultTable) = right.interpret(newTable)
            IntAndTable(leftValue + rightValue, resultTable)
        }
        is MinusExp -> {
            val (leftValue, newTable) = left.interpret(table)
            val (rightValue, resultTable) = right.interpret(newTable)
            IntAndTable(leftValue - rightValue, resultTable)
        }
        is TimesExp -> {
            val (leftValue, newTable) = left.interpret(table)
            val (rightValue, resultTable) = right.interpret(newTable)
            IntAndTable(leftValue * rightValue, resultTable)
        }
        is DivExp -> {
            val (leftValue, newTable) = left.interpret(table)
            val (rightValue, resultTable) = right.interpret(newTable)
            IntAndTable(leftValue / rightValue, resultTable)
        }
        is ExprSeqExp -> {
            val newTable = statement.interpret(table)
            val (resultValue, resultTable) = expr.interpret(newTable)
            IntAndTable(resultValue, resultTable)
        }
    }
}