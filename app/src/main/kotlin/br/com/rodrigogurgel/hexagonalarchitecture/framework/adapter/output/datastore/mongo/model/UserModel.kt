package br.com.rodrigogurgel.hexagonalarchitecture.framework.adapter.output.datastore.mongo.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.UUID

@Document(collection = "users")
data class UserModel(
    @Id
    val id: UUID,
    @Field("name")
    val name: String,
    @Field("email")
    val email: String
)
