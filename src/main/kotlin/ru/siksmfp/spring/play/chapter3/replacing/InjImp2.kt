package ru.siksmfp.spring.play.chapter3.replacing

import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component
@Scope(scopeName = "prototype")
class InjImp2 : InjBeanApi {

    override fun doSomething() {
        println("Bean2")
    }
}