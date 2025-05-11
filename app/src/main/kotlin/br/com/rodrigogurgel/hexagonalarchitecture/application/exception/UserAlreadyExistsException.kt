package br.com.rodrigogurgel.hexagonalarchitecture.application.exception

import br.com.rodrigogurgel.hexagonalarchitecture.domain.vo.Email

data class UserAlreadyExistsException(val email: Email) : RuntimeException(
    "User with email ${email.value} already exists"
)
