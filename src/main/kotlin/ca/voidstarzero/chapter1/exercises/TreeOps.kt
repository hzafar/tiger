package ca.voidstarzero.chapter1.exercises

/*
fun Tree.insert(newKey: String): Tree {
    return when {
        newKey < key -> Tree(left?.insert(newKey) ?: Tree(null, newKey, null), key, right)
        newKey > key -> Tree(left, key, right?.insert(newKey) ?: Tree(null, newKey, null))
        else -> Tree(left, newKey, right)
    }
}
 */

fun <T> Tree<T>.member(keyToFind: String): Boolean {
    return when {
        keyToFind == key -> true
        keyToFind < key -> left?.member(keyToFind) ?: false
        else -> right?.member(keyToFind) ?: false
    }
}

fun <T> Tree<T>.insert(newKey: String, value: T): Tree<T> {
    return when {
        newKey < key -> Tree(
            left?.insert(newKey, value) ?: Tree(null, newKey, value, null),
            key, binding, right
        )
        newKey > key -> Tree(
            left, key, binding,
            right?.insert(newKey, value) ?: Tree(null, newKey, value, null)
        )
        else -> Tree(left, newKey, value, right)
    }
}

fun <T> Tree<T>.lookup(keyToFind: String): T? {
    return when {
        keyToFind == key -> binding
        keyToFind < key -> left?.lookup(keyToFind)
        else -> right?.lookup(keyToFind)
    }
}