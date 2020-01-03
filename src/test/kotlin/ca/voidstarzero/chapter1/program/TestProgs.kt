package ca.voidstarzero.chapter1.program

import ca.voidstarzero.chapter1.ast.AssignmentStm
import ca.voidstarzero.chapter1.ast.CompoundStm
import ca.voidstarzero.chapter1.ast.ExprSeqExp
import ca.voidstarzero.chapter1.ast.Expression
import ca.voidstarzero.chapter1.ast.IdExp
import ca.voidstarzero.chapter1.ast.LastExpList
import ca.voidstarzero.chapter1.ast.MinusExp
import ca.voidstarzero.chapter1.ast.NumExp
import ca.voidstarzero.chapter1.ast.PairExpList
import ca.voidstarzero.chapter1.ast.PlusExp
import ca.voidstarzero.chapter1.ast.PrintStm
import ca.voidstarzero.chapter1.ast.Statement
import ca.voidstarzero.chapter1.ast.TimesExp

val prog1: Statement = AssignmentStm("x", NumExp(42))
val prog2: Statement = AssignmentStm("x", ExprSeqExp(PrintStm(LastExpList(NumExp(42))), NumExp(42)))
val prog3: Statement = CompoundStm(
    AssignmentStm("a", PlusExp(NumExp(5), NumExp(3))),
    CompoundStm(
        AssignmentStm(
            "b",
            ExprSeqExp(
                PrintStm(
                    PairExpList(
                        IdExp("a"),
                        LastExpList(MinusExp(IdExp("a"), NumExp(1)))
                    )
                ),
                TimesExp(NumExp(10), IdExp("a"))
            )
        ),
        PrintStm(LastExpList(IdExp("b")))
    )
)
val prog4: Expression = ExprSeqExp(
    AssignmentStm("a", NumExp(5)),
    ExprSeqExp(
        AssignmentStm("b", NumExp(10)),
        ExprSeqExp(
            PrintStm(
                PairExpList(
                    IdExp("a"),
                    PairExpList(
                        IdExp("b"),
                        PairExpList(
                            PlusExp(IdExp("a"), IdExp("b")),
                            LastExpList(NumExp(42))
                        )
                    )
                )
            ),
            MinusExp(IdExp("a"), NumExp(3))
        )
    )
)
val prog5: Expression = MinusExp(
    NumExp(10),
    TimesExp(
        NumExp(4),
        PlusExp(
            NumExp(5),
            PlusExp(
                NumExp(2),
                TimesExp(
                    NumExp(3),
                    NumExp(12)
                )
            )
        )
    )
)