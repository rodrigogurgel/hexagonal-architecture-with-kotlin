package br.com.rodrigogurgel.hexagonalarchitecture.framework.adapter.output.datastore.mongo.repository

import br.com.rodrigogurgel.hexagonalarchitecture.framework.adapter.output.datastore.mongo.model.UserModel
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Mono
import java.util.UUID

@Suppress("FunctionNaming")
interface UserRepository : ReactiveMongoRepository<UserModel, UUID> {
    fun existsByEmail(email: String): Mono<Boolean>
}
