package ca.voidstarzero.chapter1.ast

sealed class Statement()

class CompoundStm(val stm1: Statement, val stm2: Statement) : Statement()
class AssignmentStm(val id: String, val expr: Expression) : Statement()
class PrintStm(val exprs: ExpressionList) : Statement()