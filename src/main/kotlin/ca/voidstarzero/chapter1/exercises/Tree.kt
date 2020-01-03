package ca.voidstarzero.chapter1.exercises

data class Tree<T>(
    val left: Tree<T>? = null,
    val key: String,
    val binding: T,
    val right: Tree<T>? = null
)