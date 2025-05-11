package br.com.rodrigogurgel.hexagonalarchitecture.domain.usecase.task

import br.com.rodrigogurgel.hexagonalarchitecture.domain.entity.Task
import br.com.rodrigogurgel.hexagonalarchitecture.domain.vo.Id
import com.github.michaelbull.result.Result

interface FindAllTaskByBoardIdUseCase {
    suspend fun execute(userId: Id, boardId: Id): Result<List<Task>, Throwable>
}
