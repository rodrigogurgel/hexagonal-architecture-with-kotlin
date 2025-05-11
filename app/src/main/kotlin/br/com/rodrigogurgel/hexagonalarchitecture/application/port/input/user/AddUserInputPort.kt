package br.com.rodrigogurgel.hexagonalarchitecture.application.port.input.user

import br.com.rodrigogurgel.hexagonalarchitecture.application.exception.UserAlreadyExistsException
import br.com.rodrigogurgel.hexagonalarchitecture.application.port.output.user.UserOutputPort
import br.com.rodrigogurgel.hexagonalarchitecture.domain.entity.User
import br.com.rodrigogurgel.hexagonalarchitecture.domain.usecase.user.AddUserUseCase
import com.github.michaelbull.result.Result
import com.github.michaelbull.result.andThen
import com.github.michaelbull.result.toErrorIf

class AddUserInputPort(private val userOutputPort: UserOutputPort) : AddUserUseCase {
    override suspend fun execute(user: User): Result<Unit, Throwable> = userOutputPort.existsUserByEmail(email = user.email)
        .toErrorIf({ exists -> exists }) { throw UserAlreadyExistsException(user.id) }
        .andThen { userOutputPort.addUser(user) }
}