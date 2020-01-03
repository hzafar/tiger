package ca.voidstarzero.chapter1.program

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test


class MaxargsTest {

    @Test
    fun assignmentNoPrints() {
        assertThat(prog1.maxargs(), equalTo(0))
    }

    @Test
    fun assignmentEmbeddedPrint() {
        assertThat(prog2.maxargs(), equalTo(1))
    }

    @Test
    fun compoundStatement() {
        assertThat(prog3.maxargs(), equalTo(2))
    }

    @Test
    fun sequencedExprs() {
        assertThat(prog4.maxargs(), equalTo(4))
    }
}