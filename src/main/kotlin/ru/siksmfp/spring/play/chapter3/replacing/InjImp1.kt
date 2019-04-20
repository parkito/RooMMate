package ru.siksmfp.spring.play.chapter3.replacing

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component("bean1")
@Qualifier("bean1")
@Scope(scopeName = "prototype")
class InjImp1 : InjBeanApi {

    override fun doSomething() {
        println("Bean1")
    }
}