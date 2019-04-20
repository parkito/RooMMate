package ru.siksmfp.spring.play.chapter3.replacing

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class LookupBean {

    @PostConstruct
    fun init() {
        println("init lookup")
    }

    @Qualifier("replaceMethod")
    fun replaceMethod() {
        print("replaceMethod")
    }
}