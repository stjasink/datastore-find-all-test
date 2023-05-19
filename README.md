# Datastore findAll() test

This tests `findAll(Pageable)` in `spring-cloud-gcp-data-datastore` release `4.3.1`.  It uses `TestContainers` to 
start up a Datastore emulator, so may take a while to start up, and you will also need Docker running for it to work.

Run `./gradlew test` from the command line, or find `BookRepositoryTest` in your IDE and run it.  There are
two tests.  The `find all books` test will pass, and `find all books with pages and sorting` will fail with an 
exception.

Update `build.gradle.kts` to have `extra["springCloudGcpVersion"] = "4.3.0"` instead of `4.3.1` and re-run.  Now
both tests pass.
