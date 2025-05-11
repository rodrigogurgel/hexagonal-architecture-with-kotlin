package br.com.rodrigogurgel.hexagonalarchitecture.domain.exception

import br.com.rodrigogurgel.hexagonalarchitecture.domain.vo.Id

data class DuplicatedBoardException(val ids: Set<Id>) :
    IllegalArgumentException(
        "The provided identifiers already exist in the system: [$ids]",
    )
