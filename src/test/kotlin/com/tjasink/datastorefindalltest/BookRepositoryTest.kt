package com.tjasink.datastorefindalltest

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.DatastoreEmulatorContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import org.testcontainers.utility.DockerImageName

@SpringBootTest
@Testcontainers
class BookRepositoryTest() {

    companion object {
        @Container
        val datastoreEmulator: DatastoreEmulatorContainer = DatastoreEmulatorContainer(
            DockerImageName.parse("gcr.io/google.com/cloudsdktool/cloud-sdk:emulators")
        ).withFlags("--consistency=1")

        @DynamicPropertySource
        @JvmStatic
        fun emulatorProperties(registry: DynamicPropertyRegistry) {
            registry.add("spring.cloud.gcp.datastore.host") { "http://" + datastoreEmulator.emulatorEndpoint }
        }
    }

    @Autowired
    lateinit var repository: BookRepository

    @Test
    fun `find all books`() {
        repository.findAll()
    }

    @Test
    fun `find all books with pages and sorting`() {
        val direction = Sort.Direction.ASC
        val sortOrder = Sort.Order(direction, "title")
        val pageable = PageRequest.of(1, 10, Sort.by(sortOrder))
        repository.findAll(pageable)
    }
}
