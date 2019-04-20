package ru.siksmfp.spring.play.chapter3

import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = ["ru.siksmfp.spring.play.chapter3"])
open class LookupConfig

fun main() {
    val ctx = AnnotationConfigApplicationContext(LookupConfig::class.java)
    ctx.getBean(SimpleBean::class.java).targetMethod()
    ctx.close()
}

