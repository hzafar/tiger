package ca.voidstarzero.chapter2.automata

data class DFA(
    val start: State,
    val states: List<State>,
    val delta: (State, Char) -> State,
    val finalStates: List<State>
)