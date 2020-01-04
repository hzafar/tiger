package ca.voidstarzero.chapter2.automata

// FIXME
data class Match(val result: State,
                 val matched: String,
                 val inputPos: Int)