package br.com.rodrigogurgel.hexagonalarchitecture.framework.adapter.output.datastore

import br.com.rodrigogurgel.hexagonalarchitecture.application.port.output.user.datastore.UserDatastoreOutputPort
import br.com.rodrigogurgel.hexagonalarchitecture.domain.entity.User
import br.com.rodrigogurgel.hexagonalarchitecture.domain.vo.Email
import br.com.rodrigogurgel.hexagonalarchitecture.domain.vo.Id
import br.com.rodrigogurgel.hexagonalarchitecture.framework.adapter.output.datastore.mongo.mapper.UserMapper.asModel
import br.com.rodrigogurgel.hexagonalarchitecture.framework.adapter.output.datastore.mongo.repository.UserRepository
import com.github.michaelbull.result.Result
import com.github.michaelbull.result.runCatching
import kotlinx.coroutines.reactive.awaitSingle
import org.springframework.stereotype.Component

@Component
class UserDatastoreOutputPortAdapter(
    private val userRepository: UserRepository
) : UserDatastoreOutputPort {
    override suspend fun addUser(user: User): Result<Unit, Throwable> = runCatching {
        userRepository.save(user.asModel()).awaitSingle()
    }

    override suspend fun existsUserById(id: Id): Result<Boolean, Throwable> {
        TODO("Not yet implemented")
    }

    override suspend fun existsUserByEmail(email: Email): Result<Boolean, Throwable> = runCatching {
        userRepository.existsByEmail(email.value).awaitSingle()
    }

    override suspend fun findUserById(id: Id): Result<User, Throwable> {
        TODO("Not yet implemented")
    }

    override suspend fun removeUserById(id: Id): Result<Unit, Throwable> {
        TODO("Not yet implemented")
    }

    override suspend fun updateUser(user: User): Result<Unit, Throwable> {
        TODO("Not yet implemented")
    }
}
