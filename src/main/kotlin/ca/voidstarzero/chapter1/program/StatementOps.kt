package ca.voidstarzero.chapter1.program

import ca.voidstarzero.chapter1.ast.AssignmentStm
import ca.voidstarzero.chapter1.ast.CompoundStm
import ca.voidstarzero.chapter1.ast.PrintStm
import ca.voidstarzero.chapter1.ast.Statement
import kotlin.math.max

// Returns the max number of args of any print statement within `s`.
fun Statement.maxargs(): Int {
    return when (this) {
        is CompoundStm -> max(stm1.maxargs(), stm2.maxargs())
        is AssignmentStm -> expr.maxargs()
        is PrintStm -> max(exprs.length(), exprs.maxargs())
    }
}

// Interprets (i.e., runs) a statement.
fun Statement.interpret(table: Table?): Table? {
    return when (this) {
        is CompoundStm -> {
            val newTable = stm1.interpret(table)
            stm2.interpret(newTable)
        }
        is AssignmentStm -> {
            val (value, newTable) = expr.interpret(table)
            Table(id, value, newTable)
        }
        is PrintStm -> {
            val results = exprs.interpret(table)
            results.forEach{ println(it.int) }

            results.last().table
        }
    }
}