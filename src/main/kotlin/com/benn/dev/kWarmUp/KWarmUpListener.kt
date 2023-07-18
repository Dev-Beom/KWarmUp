package com.benn.dev.kWarmUp

import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component
import kotlin.jvm.Throws
import kotlin.concurrent.thread

@Component
class KWarmUpListener : ApplicationListener<ContextRefreshedEvent> {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @Throws(IllegalArgumentException::class)
    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        val applicationContext = event.applicationContext
        val beans = applicationContext.getBeansWithAnnotation(Component::class.java)
        for (bean in beans.values) {
            val methods = bean.javaClass.declaredMethods
            for (method in methods) {
                if (method.isAnnotationPresent(KWarmUp::class.java)) {
                    KWarmUpValidator.valid(method)
                    val metadata = method.getAnnotation(KWarmUp::class.java)
                    val count = metadata.repeatCount
                    val workerThread = thread(false) {
                        repeat(count) {
                            method.invoke(bean)
                        }
                    }
                    logger.info("warm up start. thread: ${workerThread.name}, method: ${method.name}, count: $count")
                    workerThread.start()
                    logger.info("warm up end. thread: ${workerThread.name}, method: ${method.name}, count: $count")
                }
            }
        }
    }
}