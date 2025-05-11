package br.com.rodrigogurgel.hexagonalarchitecture.domain.usecase.task

import br.com.rodrigogurgel.hexagonalarchitecture.domain.vo.Description
import br.com.rodrigogurgel.hexagonalarchitecture.domain.vo.Id
import com.github.michaelbull.result.Result

interface UpdateTaskDescriptionByIdUseCase {
    suspend fun execute(userId: Id, boardId: Id, taskId: Id, description: Description): Result<Unit, Throwable>
}
