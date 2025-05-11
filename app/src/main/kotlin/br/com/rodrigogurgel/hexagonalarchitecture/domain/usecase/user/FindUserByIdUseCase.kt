package br.com.rodrigogurgel.hexagonalarchitecture.domain.usecase.user

import br.com.rodrigogurgel.hexagonalarchitecture.domain.entity.User
import br.com.rodrigogurgel.hexagonalarchitecture.domain.vo.Id
import com.github.michaelbull.result.Result

interface FindUserByIdUseCase {
    suspend fun execute(id: Id): Result<User, Throwable>
}
