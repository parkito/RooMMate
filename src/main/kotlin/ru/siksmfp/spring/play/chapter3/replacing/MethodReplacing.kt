package ru.siksmfp.spring.play.chapter3.replacing

import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun main() {
    val ctx = AnnotationConfigApplicationContext(ReplacingLookupConfig::class.java)
    ctx.getBean(TargetBean::class.java).targetMethod()
    ctx.close()
}

