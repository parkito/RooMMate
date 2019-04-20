package ru.siksmfp.spring.play.chapter3

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

@Component
class LookupBean{

    @Qualifier("replaceMethod")
    fun replaceMethod() {
        print("replaceMethod")
    }
}