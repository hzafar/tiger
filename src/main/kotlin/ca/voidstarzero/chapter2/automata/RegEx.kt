package ca.voidstarzero.chapter2.automata

sealed class RegEx

class Symbol(val symbol: Char) : RegEx()
class Alternation(val left: RegEx, val right: RegEx) : RegEx()
class Concatenation(val left: RegEx, val right: RegEx) : RegEx()
class Repetition(val expr: RegEx) : RegEx()
object Epsilon : RegEx()
