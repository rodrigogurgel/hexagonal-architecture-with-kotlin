package br.com.rodrigogurgel.hexagonalarchitecture.domain.vo

import java.util.UUID

@JvmInline
value class Id(val value: UUID) {
    constructor() : this(
        UUID.randomUUID(),
    )

    override fun toString(): String {
        return value.toString()
    }
}
