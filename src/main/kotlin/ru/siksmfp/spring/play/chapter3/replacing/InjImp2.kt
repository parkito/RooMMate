package ru.siksmfp.spring.play.chapter3.replacing

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component("bean2")
@Scope(scopeName = "singleton")
class InjImp2 : InjBeanApi {

    override fun doSomething() {
        println("Bean2")
    }
}