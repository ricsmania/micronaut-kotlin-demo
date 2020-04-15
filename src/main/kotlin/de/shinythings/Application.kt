package de.shinythings

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("de.shinythings")
                .mainClass(Application.javaClass)
                .start()
    }
}