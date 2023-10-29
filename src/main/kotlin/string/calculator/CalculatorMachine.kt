package string.calculator

import string.calculator.part.Calculator
import string.calculator.part.Splitter
import string.calculator.part.UserInterface

class CalculatorMachine(
    private val calculator: Calculator,
    private val splitter: Splitter,
    private val userInterface: UserInterface
) {
    fun start() {
        try {
            run()
        } catch (e: IllegalArgumentException) {
            userInterface.occurError(e.message.orEmpty())
            start()
        }
    }

    private fun run() {
        var isRunning = true
        while (isRunning) {
            val input = userInterface.introduce()
            val splitInput = splitter.split(input)
            val result = calculator.calculate(splitInput.numbers, splitInput.operators)
            userInterface.showResult(result)
            isRunning = userInterface.isContinue()
        }
    }
}

fun main() {
    val calculatorMachine = CalculatorMachine(Calculator, Splitter(), UserInterface)
    calculatorMachine.start()
}