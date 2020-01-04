package ca.voidstarzero.chapter1.ast

sealed class ExpressionList

class PairExpList(val head: Expression, val tail: ExpressionList) : ExpressionList()
class LastExpList(val head: Expression) : ExpressionList()