package ca.voidstarzero.chapter2.automata

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class RegExTest {

    @Test
    fun symNFA() {
        val nfa = Symbol('a').toNFA()!!

        assertTrue(nfa.run("a"))
        assertFalse(nfa.run("ab"))
    }

    @Test
    fun alterNFA() {
        val nfa = Alternation(Symbol('a'), Symbol('b')).toNFA()!!

        assertTrue(nfa.run("a"))
        assertTrue((nfa.run("b")))
        assertFalse(nfa.run("ab"))
    }

    @Test
    fun concatNFA() {
        val nfa = Concatenation(
            Symbol('a'),
            Concatenation(
                Symbol('b'),
                Alternation(Symbol('c'), Symbol('d'))
            )
        ).toNFA()!!

        assertTrue(nfa.run("abc"))
        assertTrue(nfa.run("abd"))
        assertFalse(nfa.run("ab"))
        assertFalse(nfa.run("abz"))
    }

    @Test
    fun repeatNFA() {
        val nfa = Repetition(Symbol('a')).toNFA()!!

        assertTrue(nfa.run("aaaaaaa"))
        assertTrue(nfa.run(""))
        assertFalse(nfa.run("ab"))
    }
}