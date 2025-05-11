package br.com.rodrigogurgel.hexagonalarchitecture.domain.usecase.board

import br.com.rodrigogurgel.hexagonalarchitecture.domain.entity.Board
import br.com.rodrigogurgel.hexagonalarchitecture.domain.vo.Id
import com.github.michaelbull.result.Result

interface AddBoardUseCase {
    suspend fun execute(userId: Id, board: Board): Result<Unit, Throwable>
}
