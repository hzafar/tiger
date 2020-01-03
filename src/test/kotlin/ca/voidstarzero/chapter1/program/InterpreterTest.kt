package ca.voidstarzero.chapter1.program

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Test

class InterpreterTest {

    @Test
    fun compoundStatement() {
        val table = prog3.interpret(null)

        assertNotNull(table)
        assertThat(table!!.lookup("a"), equalTo(8))
        assertThat(table.lookup("b"), equalTo(80))
    }

    @Test
    fun sequencedExprs() {
        val (result, table) = prog4.interpret(null)

        assertNotNull(table)
        assertThat(table!!.lookup("a"), equalTo(5))
        assertThat(table.lookup("b"), equalTo(10))
        assertThat(result, equalTo(2))
    }

    @Test
    fun noAssignments() {
        val (result, table) = prog5.interpret(null)

        assertNull(table)
        assertThat(result, equalTo(-162))
    }
}