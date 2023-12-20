package com.kyougaru.kotlin.resources.exceptions

import java.time.Instant

class StandardError(val timestamp : Instant, val status : Int, val error : String, val message : String) {
}