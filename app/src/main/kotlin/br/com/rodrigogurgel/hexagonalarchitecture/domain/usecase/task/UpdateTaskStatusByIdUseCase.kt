package br.com.rodrigogurgel.hexagonalarchitecture.domain.usecase.task

import br.com.rodrigogurgel.hexagonalarchitecture.domain.vo.Id
import br.com.rodrigogurgel.hexagonalarchitecture.domain.vo.Status
import com.github.michaelbull.result.Result

interface UpdateTaskStatusByIdUseCase {
    suspend fun execute(userId: Id, boardId: Id, taskId: Id, status: Status): Result<Unit, Throwable>
}
