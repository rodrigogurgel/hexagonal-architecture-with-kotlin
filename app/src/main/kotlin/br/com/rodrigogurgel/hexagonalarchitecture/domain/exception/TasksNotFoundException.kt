package br.com.rodrigogurgel.hexagonalarchitecture.domain.exception

import br.com.rodrigogurgel.hexagonalarchitecture.domain.vo.Id

data class TasksNotFoundException(val ids: List<Id>) : IllegalArgumentException(
    "The following task IDs were not found: [$ids]"
)
