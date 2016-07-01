# Slick MDC logging
## Keeping your mapped diagnostic context when using Slick

## Basic usage

Add this to your `build.sbt`

```scala
  libraryDependencies ++= "de.geekonaut" %% "slickmdc"  % "1.0.0",
```

In your application, you need to pass the `MdcAsyncExecutor` to your database setup:

```scala
  val db = Database.forDataSource(connectionPool, MdcAsyncExecutor.apply("Database", 10)) // using 10 threads
```

Voila!
