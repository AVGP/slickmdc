package de.geekonaut.slickmdc

import org.slf4j.MDC
import scala.concurrent.ExecutionContext

/**
  * Execution context proxy for propagating SLF4J diagnostic context from caller thread to execution thread.
  */
class MdcExecutionContext(executionContext: ExecutionContext) extends ExecutionContext {
  override def execute(runnable: Runnable): Unit =  {
    val callerMdc = MDC.getCopyOfContextMap
    executionContext.execute(new Runnable {
      def run(): Unit = {
        // copy caller thread diagnostic context to execution thread
        if(callerMdc != null) MDC.setContextMap(callerMdc)
        runnable.run()
      }
    })
  }

  override def reportFailure(cause: Throwable): Unit = executionContext.reportFailure(cause)
}
