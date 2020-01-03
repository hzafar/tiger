package ca.voidstarzero.chapter1.exercises

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class TreeTest {

    /*
    @Test
    fun insert() {
        val result = tree1.insert("b").insert("w")

        assertThat(result.key, equalTo("h"))
        assertThat(result.left?.right?.key, equalTo("b"))
        assertThat(result.right?.left?.key, equalTo("w"))
    }
     */

    @Test
    fun member() {
        assertTrue(tree1.member("h"))
        assertFalse(tree1.member("c"))
        assertTrue(tree2.member("w"))
        assertFalse(tree2.member("a"))
    }

    @Test
    fun insert() {
        val result = tree1.insert("b", "hello!").insert("w", "goodbye!")

        assertThat(result.left?.right?.key, equalTo("b"))
        assertThat(result.right?.left?.key, equalTo("w"))
    }

    @Test
    fun lookup() {
        val result = tree1.insert("b", "hello!").insert("w", "goodbye!")

        assertThat(result.lookup("b").toString(), equalTo("hello!"))
        assertThat(result.lookup("w").toString(), equalTo("goodbye!"))
    }
}
