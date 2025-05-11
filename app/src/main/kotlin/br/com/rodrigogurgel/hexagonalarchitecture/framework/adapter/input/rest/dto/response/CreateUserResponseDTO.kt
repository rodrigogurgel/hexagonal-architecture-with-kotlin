package br.com.rodrigogurgel.hexagonalarchitecture.framework.adapter.input.rest.dto.response

import java.util.UUID

data class CreateUserResponseDTO(
    val id: UUID,
    val name: String,
    val email: String,
)
