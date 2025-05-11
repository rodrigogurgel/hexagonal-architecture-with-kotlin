package br.com.rodrigogurgel.hexagonalarchitecture.domain.entity

import br.com.rodrigogurgel.hexagonalarchitecture.domain.vo.Description
import br.com.rodrigogurgel.hexagonalarchitecture.domain.vo.Id
import br.com.rodrigogurgel.hexagonalarchitecture.domain.vo.Status

data class Task(
    val id: Id,
    var description: Description,
    var status: Status,
)
