package com.benn.dev.kWarmUp

import java.lang.reflect.Method
import kotlin.jvm.Throws

object KWarmUpValidator {
    @Throws(IllegalArgumentException::class)
    fun valid(method: Method) {
        val annotationMetadata = method.getAnnotation(KWarmUp::class.java)
        require(annotationMetadata.count >= 0) { "count must be a non-negative value" }
    }
}