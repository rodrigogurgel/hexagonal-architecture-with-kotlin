package br.com.rodrigogurgel.hexagonalarchitecture.application.port.input.user

import br.com.rodrigogurgel.hexagonalarchitecture.application.port.output.user.UserOutputPort
import br.com.rodrigogurgel.hexagonalarchitecture.domain.entity.User
import br.com.rodrigogurgel.hexagonalarchitecture.domain.usecase.user.FindUserByIdUseCase
import br.com.rodrigogurgel.hexagonalarchitecture.domain.vo.Id
import com.github.michaelbull.result.Result
import com.github.michaelbull.result.andThen
import com.github.michaelbull.result.toErrorIf

class FindByUserIdInputPort(private val userOutputPort: UserOutputPort) : FindUserByIdUseCase {
    override suspend fun execute(id: Id): Result<User, Throwable> = userOutputPort.existsUserById(id)
        .toErrorIf({ exists -> !exists }) { throw RuntimeException() }
        .andThen { userOutputPort.findUserById(id) }
}