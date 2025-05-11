package br.com.rodrigogurgel.hexagonalarchitecture.framework.adapter.input.rest.extensions

import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.http.ResponseEntity

fun <T> failure(
    throwable: Throwable,
    message: String? = throwable.message,
    status: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
    vararg properties: Pair<String, String> = emptyArray()
): ResponseEntity<T> {
    val problemDetail = ProblemDetail.forStatusAndDetail(status, message)
    problemDetail.title = status.reasonPhrase
    problemDetail.status = status.value()
    problemDetail.properties = mapOf(*properties)

    return ResponseEntity.of(problemDetail).build()
}
