package br.com.rodrigogurgel.hexagonalarchitecture.domain.usecase.user

import br.com.rodrigogurgel.hexagonalarchitecture.domain.vo.Id
import com.github.michaelbull.result.Result

interface RemoveUserByIdUseCase {
    suspend fun execute(id: Id): Result<Unit, Throwable>
}
