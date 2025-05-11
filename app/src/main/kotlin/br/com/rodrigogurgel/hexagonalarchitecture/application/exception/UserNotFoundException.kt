package br.com.rodrigogurgel.hexagonalarchitecture.application.exception

import br.com.rodrigogurgel.hexagonalarchitecture.domain.vo.Id

data class UserNotFoundException(val id: Id) : RuntimeException("User with id $id not found")