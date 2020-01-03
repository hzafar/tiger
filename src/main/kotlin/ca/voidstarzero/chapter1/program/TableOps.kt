package ca.voidstarzero.chapter1.program

fun Table.lookup(identifier: String): Int? {
    return when (id) {
        identifier -> value
        else -> tail?.lookup(identifier)
    }
}