package br.com.rodrigogurgel.hexagonalarchitecture.framework.adapter.output.datastore.mongo.mapper

import br.com.rodrigogurgel.hexagonalarchitecture.domain.entity.User
import br.com.rodrigogurgel.hexagonalarchitecture.framework.adapter.output.datastore.mongo.model.UserModel

object UserMapper {
    fun User.asModel(): UserModel = UserModel(
        id = id.value,
        name = name.value,
        email = email.value
    )
}
