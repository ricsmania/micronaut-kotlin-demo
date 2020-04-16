package de.shinythings.boundary

import io.kotlintest.specs.AnnotationSpec
import io.kotlintest.shouldBe
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.annotation.MicronautTest
import java.lang.Thread.sleep
import javax.inject.Inject

@MicronautTest
class HelloControllerTest : AnnotationSpec() {

    @Inject
    lateinit var server: EmbeddedServer

    @Inject
    @field:Client("/")
    lateinit var client: HttpClient

    @Test
    fun `should respond hello world`() {
        var response: String = "empty"
        print(response)
        sleep(5000)

        try {
            response = client.toBlocking().retrieve("/hello")
        } catch (e: Exception) {
            print(e.message)
        }
        print(response)

        response shouldBe "Hello World"
    }
}
