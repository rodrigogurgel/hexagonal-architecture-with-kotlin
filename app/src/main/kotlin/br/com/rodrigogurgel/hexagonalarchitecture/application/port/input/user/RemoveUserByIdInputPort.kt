package br.com.rodrigogurgel.hexagonalarchitecture.application.port.input.user

import br.com.rodrigogurgel.hexagonalarchitecture.application.port.output.user.UserOutputPort
import br.com.rodrigogurgel.hexagonalarchitecture.domain.usecase.user.RemoveUserByIdUseCase
import br.com.rodrigogurgel.hexagonalarchitecture.domain.vo.Id
import com.github.michaelbull.result.Result

class RemoveUserByIdInputPort(private val userOutputPort: UserOutputPort) : RemoveUserByIdUseCase {
    override suspend fun execute(id: Id): Result<Unit, Throwable> = userOutputPort.removeUserById(id)
}