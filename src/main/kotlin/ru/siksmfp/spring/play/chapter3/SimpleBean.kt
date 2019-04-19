package ru.siksmfp.spring.play.chapter3

import org.springframework.stereotype.Component

@Component
class SimpleBean {

    fun targetMethod() {
        print("targetMethod")
    }
}