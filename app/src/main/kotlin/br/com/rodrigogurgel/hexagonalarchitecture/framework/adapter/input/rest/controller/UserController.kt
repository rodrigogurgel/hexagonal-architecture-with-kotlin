package br.com.rodrigogurgel.hexagonalarchitecture.framework.adapter.input.rest.controller

import br.com.rodrigogurgel.hexagonalarchitecture.application.exception.UserAlreadyExistsException
import br.com.rodrigogurgel.hexagonalarchitecture.domain.usecase.user.AddUserUseCase
import br.com.rodrigogurgel.hexagonalarchitecture.framework.adapter.input.rest.dto.mapper.UserMapper.asDTO
import br.com.rodrigogurgel.hexagonalarchitecture.framework.adapter.input.rest.dto.mapper.UserMapper.asEntity
import br.com.rodrigogurgel.hexagonalarchitecture.framework.adapter.input.rest.dto.request.CreateUserRequestDTO
import br.com.rodrigogurgel.hexagonalarchitecture.framework.adapter.input.rest.dto.response.CreateUserResponseDTO
import br.com.rodrigogurgel.hexagonalarchitecture.framework.adapter.input.rest.extensions.failure
import br.com.rodrigogurgel.hexagonalarchitecture.framework.adapter.input.rest.extensions.success
import com.github.michaelbull.result.andThen
import com.github.michaelbull.result.mapBoth
import com.github.michaelbull.result.mapCatching
import com.github.michaelbull.result.runCatching
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    private val addUserUseCase: AddUserUseCase,
) {
    @PostMapping
    suspend fun create(@RequestBody createUserRequestDTO: CreateUserRequestDTO): ResponseEntity<CreateUserResponseDTO> =
        runCatching {
            createUserRequestDTO.asEntity()
        }.andThen { user ->
            addUserUseCase.execute(user).mapCatching { user.asDTO() }
        }.mapBoth(success = { response ->
            success(value = response)
        }, failure = { throwable ->
            when (throwable) {
                is UserAlreadyExistsException -> failure(
                    throwable,
                    status = HttpStatus.CONFLICT,
                )

                else -> failure(throwable)
            }
        })
}
