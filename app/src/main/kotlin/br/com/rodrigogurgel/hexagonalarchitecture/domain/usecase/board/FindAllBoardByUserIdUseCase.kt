package br.com.rodrigogurgel.hexagonalarchitecture.domain.usecase.board

import br.com.rodrigogurgel.hexagonalarchitecture.domain.entity.Board
import br.com.rodrigogurgel.hexagonalarchitecture.domain.vo.Id
import com.github.michaelbull.result.Result

interface FindAllBoardByUserIdUseCase {
    suspend fun execute(userId: Id): Result<List<Board>, Throwable>
}
