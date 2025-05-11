package br.com.rodrigogurgel.hexagonalarchitecture.application.port.input.user

import br.com.rodrigogurgel.hexagonalarchitecture.application.exception.UserNotFoundException
import br.com.rodrigogurgel.hexagonalarchitecture.application.port.output.user.datastore.UserDatastoreOutputPort
import br.com.rodrigogurgel.hexagonalarchitecture.domain.entity.User
import br.com.rodrigogurgel.hexagonalarchitecture.domain.usecase.user.FindUserByIdUseCase
import br.com.rodrigogurgel.hexagonalarchitecture.domain.vo.Id
import com.github.michaelbull.result.Result
import com.github.michaelbull.result.andThen
import com.github.michaelbull.result.toErrorIf

class FindByUserIdInputPort(private val userDatastoreOutputPort: UserDatastoreOutputPort) : FindUserByIdUseCase {
    override suspend fun execute(id: Id): Result<User, Throwable> = userDatastoreOutputPort.existsUserById(id)
        .toErrorIf({ exists -> !exists }) { UserNotFoundException(id) }
        .andThen { userDatastoreOutputPort.findUserById(id) }
}
