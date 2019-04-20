package ru.siksmfp.spring.play.chapter3.replacing

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Lookup
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

@Component
open class TargetBean(
        @Autowired
        @Qualifier("bean1")
        private val injBeanApi1: InjBeanApi) {


    fun setBeanApi1(injBeanApi: InjBeanApi): InjBeanApi? {
        return null
    }

    @Lookup("bean2")//todo why it doesn't work
    fun getBeanApi2(): InjBeanApi? {
        return null
    }

    fun targetMethod() {
        injBeanApi1.doSomething()
        println(injBeanApi1)
        println(injBeanApi1)

        getBeanApi2()?.doSomething()
        println(getBeanApi2())
        println(getBeanApi2())
    }
}