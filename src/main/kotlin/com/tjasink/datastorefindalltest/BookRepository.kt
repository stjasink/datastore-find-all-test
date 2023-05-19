package com.tjasink.datastorefindalltest

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository

interface BookRepository : DatastoreRepository<Book, Long>
