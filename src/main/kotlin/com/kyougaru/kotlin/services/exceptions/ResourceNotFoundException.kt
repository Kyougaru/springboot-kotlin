package com.kyougaru.kotlin.services.exceptions

class ResourceNotFoundException(id: Int) : RuntimeException("Resource not found. Id: $id") {
}