package ru.siksmfp.spring.play.chapter3.replacing

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Lookup
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

@Component
open class TargetBean(
        @Autowired
        @Qualifier("bean1")
        private val injBeanApi1: InjBeanApi
) {

    @Lookup
    fun getInjImp2(): InjBeanApi {
        print("Shouldn't print")
        return null!!
    }

    fun targetMethod() {
        injBeanApi1.doSomething()
        getInjImp2().doSomething()
    }
}