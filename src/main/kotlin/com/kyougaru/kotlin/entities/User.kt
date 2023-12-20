package com.kyougaru.kotlin.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "tb_user")
data class User(@Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                val id : Int?=null,
                var name : String,
                var email : String)
