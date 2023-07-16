package com.benn.dev.kWarmUp

import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component
import kotlin.jvm.Throws

@Component
class KWarmUpListener : ApplicationListener<ContextRefreshedEvent> {

    @Throws(IllegalArgumentException::class)
    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        val applicationContext = event.applicationContext
        val beans = applicationContext.getBeansWithAnnotation(KWarmUp::class.java)
        for (bean in beans.values) {
            val methods = bean.javaClass.declaredMethods
            for (method in methods) {
                if (method.isAnnotationPresent(KWarmUp::class.java)) {
                    KWarmUpValidator.valid(method)
                    val metadata = method.getAnnotation(KWarmUp::class.java)
                    val count = metadata.count

                    // TODO configured to work in a separate thread
                    repeat(count) {
                        method.invoke(bean)
                    }
                }
            }
        }
    }
}