package com.tjasink.datastorefindalltest

import com.google.cloud.spring.data.datastore.core.mapping.Entity
import org.springframework.data.annotation.Id

@Entity
data class Book (
    @Id
    val id: Long,
    val title: String,
    val author: String
)
