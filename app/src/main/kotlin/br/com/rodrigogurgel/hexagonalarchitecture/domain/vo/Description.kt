package br.com.rodrigogurgel.hexagonalarchitecture.domain.vo

import br.com.rodrigogurgel.hexagonalarchitecture.domain.exception.DescriptionLengthException

@JvmInline
value class Description(val value: String) {
    companion object {
        const val MIN_LENGTH = 1
        const val MAX_LENGTH = 1000
    }

    init {
        if (value.length !in MIN_LENGTH..MAX_LENGTH) throw DescriptionLengthException(value)
    }

    override fun toString(): String {
        return value
    }
}
