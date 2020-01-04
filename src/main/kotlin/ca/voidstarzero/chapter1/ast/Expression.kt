package ca.voidstarzero.chapter1.ast

sealed class Expression

class IdExp(val id: String) : Expression()
class NumExp(val num: Int) : Expression()
class PlusExp(val left: Expression, val right: Expression) : Expression()
class MinusExp(val left: Expression, val right: Expression) : Expression()
class TimesExp(val left: Expression, val right: Expression) : Expression()
class DivExp(val left: Expression, val right: Expression) : Expression()
class ExprSeqExp(val statement: Statement, val expr: Expression) : Expression()