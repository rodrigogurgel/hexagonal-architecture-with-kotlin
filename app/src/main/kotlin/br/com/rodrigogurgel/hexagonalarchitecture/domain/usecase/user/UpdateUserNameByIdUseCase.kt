package br.com.rodrigogurgel.hexagonalarchitecture.domain.usecase.user

import br.com.rodrigogurgel.hexagonalarchitecture.domain.vo.Id
import br.com.rodrigogurgel.hexagonalarchitecture.domain.vo.Name
import com.github.michaelbull.result.Result

interface UpdateUserNameByIdUseCase {
    suspend fun execute(id: Id, name: Name): Result<Unit, Throwable>
}
