package br.com.rodrigogurgel.hexagonalarchitecture.framework.adapter.input.rest.dto.mapper

import br.com.rodrigogurgel.hexagonalarchitecture.domain.entity.User
import br.com.rodrigogurgel.hexagonalarchitecture.domain.vo.Email
import br.com.rodrigogurgel.hexagonalarchitecture.domain.vo.Id
import br.com.rodrigogurgel.hexagonalarchitecture.domain.vo.Name
import br.com.rodrigogurgel.hexagonalarchitecture.framework.adapter.input.rest.dto.request.CreateUserRequestDTO
import br.com.rodrigogurgel.hexagonalarchitecture.framework.adapter.input.rest.dto.response.CreateUserResponseDTO

object UserMapper {
    fun CreateUserRequestDTO.asEntity(): User = User(
        id = Id(),
        name = Name(name),
        email = Email(email)
    )

    fun User.asDTO(): CreateUserResponseDTO = CreateUserResponseDTO(
        id = id.value,
        name = name.value,
        email = email.value
    )
}
