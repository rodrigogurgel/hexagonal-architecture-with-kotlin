package br.com.rodrigogurgel.hexagonalarchitecture.application.port.input.user

import br.com.rodrigogurgel.hexagonalarchitecture.application.exception.UserNotFoundException
import br.com.rodrigogurgel.hexagonalarchitecture.application.port.output.user.UserOutputPort
import br.com.rodrigogurgel.hexagonalarchitecture.domain.usecase.user.UpdateUserNameByIdUseCase
import br.com.rodrigogurgel.hexagonalarchitecture.domain.vo.Id
import br.com.rodrigogurgel.hexagonalarchitecture.domain.vo.Name
import com.github.michaelbull.result.Result
import com.github.michaelbull.result.andThen
import com.github.michaelbull.result.toErrorIf

class UpdateUserNameByInputPort(
    private val userOutputPort: UserOutputPort
) : UpdateUserNameByIdUseCase {
    override suspend fun execute(
        id: Id,
        name: Name
    ): Result<Unit, Throwable> = userOutputPort.existsUserById(id = id)
        .toErrorIf({ exists -> !exists }) { throw UserNotFoundException(id) }
        .andThen { userOutputPort.findUserById(id = id) }
        .andThen { user -> userOutputPort.updateUser(user.copy(name = name)) }
}