package ca.voidstarzero.chapter2.automata

fun RegEx.toNFA(): NFA? {
    return when (this) {
        is Symbol -> {
            val startState = State()
            val symState = State()
            NFA(
                start = startState,
                states = listOf(startState, symState),
                delta = mutableMapOf(
                    Pair(
                        startState,
                        mutableMapOf(
                            Pair(
                                symbol, listOf(symState)
                            )
                        )
                    )
                ),
                finalStates = listOf(symState)
            )
        }
        is Alternation -> {
            val nfa1 = left.toNFA()
            val nfa2 = right.toNFA()

            if (nfa1 == null && nfa2 == null) return null
            if (nfa1 == null) return nfa2
            if (nfa2 == null) return nfa1

            val start = State()
            NFA(
                start = start,
                states = listOf(start)
                    .plus(nfa1.states)
                    .plus(nfa2.states),
                delta = mutableMapOf(
                    Pair(
                        start,
                        mutableMapOf(Pair('ε', listOfNotNull(nfa1.start, nfa2.start)))
                    )
                )
                    .plus(nfa1.delta)
                    .plus(nfa2.delta)
                    .toMutableMap(),
                finalStates = nfa1.finalStates
                    .plus(nfa2.finalStates)
            )
        }
        is Concatenation -> {
            val nfa1 = left.toNFA()
            val nfa2 = right.toNFA()

            if (nfa1 == null && nfa2 == null) return null
            if (nfa1 == null) return nfa2
            if (nfa2 == null) return nfa1

            NFA(
                start = nfa1.start,
                states = nfa1.states.plus(nfa2.states),
                delta = nfa1.delta.plus(nfa2.delta)
                    .plus(nfa1.finalStates.map { it to mutableMapOf(Pair('ε', listOf(nfa2.start))) }.toMap())
                    .toMutableMap(),
                finalStates = nfa2.finalStates
            )
        }
        is Repetition -> {
            val nfa = expr.toNFA()

            nfa?.let { m ->
                NFA(
                    start = m.start,
                    states = m.states,
                    delta = m.delta
                        .plus(m.finalStates.map { it to mutableMapOf(Pair('ε', listOf(m.start))) }.toMap())
                        .toMutableMap(),
                    finalStates = m.finalStates.plus(m.start)
                )
            }
        }
        Epsilon -> null
    }
}