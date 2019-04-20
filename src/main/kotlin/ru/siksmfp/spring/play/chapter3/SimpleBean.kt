package ru.siksmfp.spring.play.chapter3

import org.springframework.beans.factory.annotation.Lookup
import org.springframework.stereotype.Component

@Component
open class SimpleBean {

    @Lookup("replaceMethod")
    fun targetMethod() {
        print("targetMethod")
    }
}