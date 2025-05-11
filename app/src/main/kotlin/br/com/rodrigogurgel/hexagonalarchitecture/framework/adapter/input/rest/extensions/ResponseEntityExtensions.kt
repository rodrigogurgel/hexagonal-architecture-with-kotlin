package br.com.rodrigogurgel.hexagonalarchitecture.framework.adapter.input.rest.extensions

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity

fun <V> success(value: V, statusCode: HttpStatusCode = HttpStatus.OK): ResponseEntity<V> {
    return when (value) {
        Unit -> ResponseEntity.status(statusCode).build()
        else -> ResponseEntity.status(statusCode).body(value)
    }
}
