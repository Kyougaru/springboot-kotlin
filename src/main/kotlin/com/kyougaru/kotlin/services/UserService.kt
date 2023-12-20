package com.kyougaru.kotlin.services

import com.kyougaru.kotlin.entities.User
import com.kyougaru.kotlin.repositories.UserRepository
import com.kyougaru.kotlin.services.exceptions.ResourceNotFoundException
import org.springframework.stereotype.Service

@Service
data class UserService(
    private val repository: UserRepository
) {

    fun findAll() : List<User> {
        return repository.findAll()
    }

    fun insert(user : User) : User {
        return repository.save(user)
    }

    fun findById(id : Int) : User {
        return repository.findById(id).orElseThrow { ResourceNotFoundException(id) }
    }

    fun update(id : Int, user : User) {
        val entity : User = repository.getReferenceById(id)
        updateData(entity, user)
        repository.save(entity)
    }

    fun delete(id : Int) {
        if(!repository.existsById(id)) {
            throw ResourceNotFoundException(id)
        } else {
            repository.deleteById(id)
        }
    }

    private fun updateData(entity : User, user : User) {
        entity.name = user.name
        entity.email = user.email
    }
}