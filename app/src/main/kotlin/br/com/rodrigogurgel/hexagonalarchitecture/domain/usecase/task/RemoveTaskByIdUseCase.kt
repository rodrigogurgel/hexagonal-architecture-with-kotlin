package br.com.rodrigogurgel.hexagonalarchitecture.domain.usecase.task

import br.com.rodrigogurgel.hexagonalarchitecture.domain.vo.Id
import com.github.michaelbull.result.Result

interface RemoveTaskByIdUseCase {
    suspend fun execute(userId: Id, boardId: Id, taskId: Id): Result<Unit, Throwable>
}
