package br.com.rodrigogurgel.hexagonal_architecture_with_kotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class HexagonalArchitectureWithKotlinApplication

fun main(args: Array<String>) {
	runApplication<HexagonalArchitectureWithKotlinApplication>(*args)
}
