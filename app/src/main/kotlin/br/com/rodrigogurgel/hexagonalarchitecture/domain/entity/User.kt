package br.com.rodrigogurgel.hexagonalarchitecture.domain.entity

import br.com.rodrigogurgel.hexagonalarchitecture.domain.exception.BoardsNotFoundException
import br.com.rodrigogurgel.hexagonalarchitecture.domain.exception.DuplicatedBoardException
import br.com.rodrigogurgel.hexagonalarchitecture.domain.vo.Email
import br.com.rodrigogurgel.hexagonalarchitecture.domain.vo.Id
import br.com.rodrigogurgel.hexagonalarchitecture.domain.vo.Name

data class User(
    val id: Id,
    var name: Name,
    val email: Email,
) {
    constructor(id: Id, name: Name, email: Email, boards: List<Board>) : this(id, name, email) {
        this.boards = boards.toMutableList()
    }

    private lateinit var mutableBoardMap: MutableMap<Id, Board>

    var boards: MutableList<Board>
        get() = mutableBoardMap.values.toMutableList()
        set(value) {
            mutableBoardMap = value.associateBy { it.id }.toMutableMap()
        }

    fun addBoard(board: Board) = addBoards(boards = listOf(board))
    fun removeBoard(id: Id) = removeBoards(ids = listOf(id))
    fun updateBoard(board: Board) = updateBoards(boards = listOf(board))

    fun addBoards(boards: List<Board>) {
        this.boards.addAll(boards)
        val duplicateBoards = this.boards.groupBy { it.id }.filter { it.value.size > 1 }
        if (duplicateBoards.isNotEmpty()) throw DuplicatedBoardException(ids = duplicateBoards.keys)
    }

    fun removeBoards(ids: List<Id>) {
        this.boards.removeIf { it.id in ids }
    }

    fun updateBoards(boards: List<Board>) {
        val ids = this.boards.map { board -> board.id }
        val notFoundIds = boards.filterNot { id in ids }.map { board -> board.id }

        if (notFoundIds.isNotEmpty()) throw BoardsNotFoundException(notFoundIds)

        boards.forEach { board ->
            if (mutableBoardMap.containsKey(board.id)) {
                mutableBoardMap[board.id] = board
            }
        }
    }
}
