package com.benn.dev.kWarmUp

import org.springframework.context.annotation.Import

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.TYPE)
@Import(KWarmUpBeanRegistrationProcessor::class)
annotation class EnableKWarmUp
