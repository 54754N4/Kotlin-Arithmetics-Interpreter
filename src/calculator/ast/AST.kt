package calculator.ast

import calculator.grammar.Token

sealed class CalcAST: Visitable {
    override fun accept(visitor: Visitor): Double = visitor.visit(this)
}

class Number(val token: Token): CalcAST()
class BinaryOperator(val left: CalcAST, val token: Token, val right: CalcAST): CalcAST()
class UnaryOperator(val token: Token, val expr: CalcAST): CalcAST()
class Composition(val token: Token, val expr: CalcAST): CalcAST()