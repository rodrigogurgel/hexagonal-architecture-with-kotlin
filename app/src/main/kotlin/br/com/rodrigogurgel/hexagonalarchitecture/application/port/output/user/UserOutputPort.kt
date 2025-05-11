package br.com.rodrigogurgel.hexagonalarchitecture.application.port.output.user

import br.com.rodrigogurgel.hexagonalarchitecture.domain.entity.User
import br.com.rodrigogurgel.hexagonalarchitecture.domain.vo.Email
import br.com.rodrigogurgel.hexagonalarchitecture.domain.vo.Id
import com.github.michaelbull.result.Result

interface UserOutputPort {
    suspend fun addUser(user: User): Result<Unit, Throwable>
    suspend fun existsUserByEmail(email: Email): Result<Boolean, Throwable>
    suspend fun findUserById(id: Id): Result<User, Throwable>
    suspend fun removeUserById(id: Id): Result<Unit, Throwable>
    suspend fun updateUser(user: User): Result<Unit, Throwable>
}