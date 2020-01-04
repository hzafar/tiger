package ca.voidstarzero.chapter2.automata

data class NFA(
    val start: State,
    val states: List<State>,
    val delta: MutableMap<State, MutableMap<Char, List<State>>>,
    val finalStates: List<State>
)