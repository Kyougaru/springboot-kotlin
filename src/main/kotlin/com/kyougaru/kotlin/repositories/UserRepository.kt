package com.kyougaru.kotlin.repositories

import com.kyougaru.kotlin.entities.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Int> {
}