package ru.siksmfp.spring.play.chapter3.replacing

import org.springframework.stereotype.Component

@Component("bean1")
class InjImp1 : InjBeanApi {

    override fun doSomething() {
        println("Bean1")
    }
}