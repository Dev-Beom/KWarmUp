package com.benn.dev.kWarmUp

/**
 * @param repeatCount The number of counts the target method is executed
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class KWarmUp(val repeatCount: Int = 1000)