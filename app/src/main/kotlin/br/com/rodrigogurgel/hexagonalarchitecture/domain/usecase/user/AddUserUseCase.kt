package br.com.rodrigogurgel.hexagonalarchitecture.domain.usecase.user

import br.com.rodrigogurgel.hexagonalarchitecture.domain.entity.User
import com.github.michaelbull.result.Result

interface AddUserUseCase {
    suspend fun execute(user: User): Result<Unit, Throwable>
}
