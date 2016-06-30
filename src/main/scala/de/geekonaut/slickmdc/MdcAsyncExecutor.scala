package de.geekonaut.slickmdc

import java.util.concurrent._

import scala.concurrent._
import com.typesafe.scalalogging.StrictLogging
import slick.util.AsyncExecutor

/** Taken from the original Slick AsyncExecutor and simplified
  * @see https://github.com/slick/slick/blob/3.1/slick/src/main/scala/slick/util/AsyncExecutor.scala
  */

object MdcAsyncExecutor extends StrictLogging {
  /** Create an [[AsyncExecutor]] with a fixed-size thread pool.
    *
    * @param numThreads The number of threads in the pool.
    */
  def apply(numThreads: Int): AsyncExecutor = {
    new AsyncExecutor {
      lazy val executionContext = {
        new MdcExecutionContext(ExecutionContext.fromExecutor(Executors.newFixedThreadPool(numThreads)))
      }
      def close(): Unit = {}
    }
  }

  def default(name: String = "AsyncExecutor.default"): AsyncExecutor =
    apply(20)
}
