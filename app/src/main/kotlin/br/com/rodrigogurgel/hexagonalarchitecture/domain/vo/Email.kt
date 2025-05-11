package br.com.rodrigogurgel.hexagonalarchitecture.domain.vo

import br.com.rodrigogurgel.hexagonalarchitecture.domain.exception.InvalidEmailFormatException

@JvmInline
value class Email(val value: String) {
    init {
        val emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$".toRegex()
        if (!emailRegex.matches(input = value)) throw InvalidEmailFormatException()
    }
}
