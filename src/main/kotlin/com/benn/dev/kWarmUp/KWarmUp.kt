package com.benn.dev.kWarmUp

/**
 * @param count The number of counts the target method is executed
 */
@Target(AnnotationTarget.FUNCTION)
annotation class KWarmUp(val count: Int)