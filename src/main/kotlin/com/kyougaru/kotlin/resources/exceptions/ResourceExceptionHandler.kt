package com.kyougaru.kotlin.resources.exceptions

import com.kyougaru.kotlin.services.exceptions.ResourceNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.Instant

@ControllerAdvice
class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException::class)
    fun resourceNotFound(exception: ResourceNotFoundException) : ResponseEntity<StandardError> {
        val error = "Resource not found"
        val status = HttpStatus.NOT_FOUND
        val err = StandardError(Instant.now(), status.value(), error, exception.message.toString())
        return ResponseEntity.status(status).body(err)
    }
}