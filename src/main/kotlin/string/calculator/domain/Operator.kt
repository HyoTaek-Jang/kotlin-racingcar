package string.calculator.domain

enum class Operator(val symbol: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    fun operate(left: Long, right: Long): Long = when (this) {
        PLUS -> left + right
        MINUS -> left - right
        MULTIPLY -> left * right
        DIVIDE -> left / right
    }

    companion object {
        private const val NOT_SUPPORTED_OPERATOR = "지원하지 않는 연산자입니다."

        fun of(operator: String): Operator = values().firstOrNull { it.symbol == operator }
            ?: throw IllegalArgumentException(NOT_SUPPORTED_OPERATOR)
    }
}