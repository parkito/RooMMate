package ru.siksmfp.spring.play.chapter3.replacing

import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun main() {
    val ctx = AnnotationConfigApplicationContext(ReplacingLookupConfig::class.java)
//    ctx.getBean(TargetBean::class.java).targetMethod()
    val bean = ctx.getBean(StudentServices::class.java)
    println(bean.getNotification())
    println(bean.getNotification())
    ctx.close()
}

