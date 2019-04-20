package ru.siksmfp.spring.play.chapter3.replacing

import org.springframework.beans.factory.annotation.Lookup
import org.springframework.stereotype.Component

@Component
open class TargetBean {

    @Lookup("replaceMethod")
    fun targetMethod() {
        print("targetMethod")
    }
}