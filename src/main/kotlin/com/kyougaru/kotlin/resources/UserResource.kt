package com.kyougaru.kotlin.resources

import com.kyougaru.kotlin.entities.User
import com.kyougaru.kotlin.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping("/users")
class UserResource(
    private val service : UserService
) {

    @GetMapping
    fun findAll() : ResponseEntity<List<User>> {
        val list : List<User> = service.findAll()
        return ResponseEntity.ok(list)
    }

    @PostMapping
    fun insert(@RequestBody user : User): ResponseEntity<Void> {
        val insertedUser = service.insert(user)
        val uri : URI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(insertedUser.id).toUri()
        return ResponseEntity.created(uri).build()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id : Int) : ResponseEntity<User> {
        val user : User = service.findById(id)
        return ResponseEntity.ok().body(user)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id : Int, @RequestBody user : User) : ResponseEntity<Void> {
        service.update(id, user)
        return ResponseEntity.ok().build()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id : Int) : ResponseEntity<Void> {
        service.delete(id)
        return ResponseEntity.ok().build()
    }
}