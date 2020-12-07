package com.acme.tour

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class TourApplication{

}

fun main(args: Array<String>) {
    runApplication<TourApplication>(*args)
}
