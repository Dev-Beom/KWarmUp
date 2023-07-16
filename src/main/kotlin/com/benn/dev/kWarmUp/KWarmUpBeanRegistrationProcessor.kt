package com.benn.dev.kWarmUp

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory
import org.springframework.beans.factory.support.BeanDefinitionRegistry
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider
import org.springframework.core.type.filter.AnnotationTypeFilter
import org.springframework.stereotype.Component

class KWarmUpBeanRegistrationProcessor : BeanDefinitionRegistryPostProcessor {
    override fun postProcessBeanFactory(beanFactory: ConfigurableListableBeanFactory) {}

    override fun postProcessBeanDefinitionRegistry(registry: BeanDefinitionRegistry) {
        val componentProvider = ClassPathScanningCandidateComponentProvider(false)
        componentProvider.addIncludeFilter(AnnotationTypeFilter(Component::class.java))

        val basePackage = "com.benn.dev.kWarmUp"
        val beanDefinitions = componentProvider.findCandidateComponents(basePackage)
        for (beanDefinition in beanDefinitions) {
            beanDefinition.beanClassName?.let { registry.registerBeanDefinition(it, beanDefinition) }
        }
    }
}