package ru.siksmfp.spring.play.chapter3.replacing

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = ["ru.siksmfp.spring.play.chapter3.replacing"])
open class ReplacingLookupConfig {

}