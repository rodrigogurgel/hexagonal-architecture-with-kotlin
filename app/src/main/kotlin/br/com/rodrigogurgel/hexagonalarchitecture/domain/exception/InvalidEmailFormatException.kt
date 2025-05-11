package br.com.rodrigogurgel.hexagonalarchitecture.domain.exception

class InvalidEmailFormatException :
    IllegalArgumentException(
        "The email address provided is not valid. Please enter a valid email in the format name@example.com."
    )
