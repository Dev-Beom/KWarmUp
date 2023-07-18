package com.benn.dev.kWarmUp

import org.springframework.context.annotation.Import

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.ANNOTATION_CLASS)
@Import(KWarmUpBeanRegistrationProcessor::class)
annotation class EnableKWarmUp