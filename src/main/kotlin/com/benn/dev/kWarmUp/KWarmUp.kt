package com.benn.dev.kWarmUp

/**
 * @param count The number of counts the target method is executed
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class KWarmUp(val count: Int)