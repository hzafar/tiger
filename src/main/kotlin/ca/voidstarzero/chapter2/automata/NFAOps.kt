package ca.voidstarzero.chapter2.automata

fun NFA.run(input: String): Boolean {
    val results = input.fold(listOf(start), { acc, sym ->
        val states = acc.plus(acc.flatMap { epsilonClosure(it) })
        states.flatMap { state ->
                delta[state]?.get(sym)
                    ?: emptyList()
            }
    })

    return when {
        results.intersect(finalStates).isNotEmpty() -> true
        else -> false
    }
}

fun NFA.epsilonClosure(state: State): List<State> {
    val result = mutableListOf<State>()

    var reachable = delta[state]?.get('ε') ?: emptyList()
    while (reachable.isNotEmpty()) {
        result.addAll(reachable)
        reachable = reachable.flatMap { st ->
            delta[st]?.get('ε') ?: emptyList()
        }
    }

    return result
}

fun NFA.subsetConstruction(): DFA {
    TODO()
}

