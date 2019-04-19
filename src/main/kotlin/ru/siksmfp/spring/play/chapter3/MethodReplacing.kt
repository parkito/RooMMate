package ru.siksmfp.spring.play.chapter3

import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = ["ru.siksmfp.spring.play.chapter3"])
open class LookupConfig

fun main() {
    val ctx = AnnotationConfigApplicationContext(LookupConfig::class.java)

    ctx.getBean(SimpleBean::class.java).targetMethod()
    //Arrays.stream(ctx.getBeanDefinitionNames()).forEach(s-> System.out.println(s));

//    val abstractBean = ctx.getBean("abstractLookupBean", DemoBean::class.java)
//    val standardBean = ctx.getBean("standardLookupBean", DemoBean::class.java)


//    displayInfo("abstractLookupBean", abstractBean)
//    displayInfo("standardLookupBean", standardBean)

    ctx.close()
}

//fun displayInfo(beanName: String, bean: DemoBean) {
//    val singer1 = bean.getMySinger()
//    val singer2 = bean.getMySinger()
//
//    println("[" + beanName + "]: Singer Instances the Same?  "
//            + (singer1 === singer2))
//
//    val stopWatch = StopWatch()
//    stopWatch.start("lookupDemo")
//
//    for (x in 0..99999) {
//        val singer = bean.getMySinger()
//        singer.sing()
//    }
//
//    stopWatch.stop()
//    println("100000 gets took " + stopWatch.totalTimeMillis + " ms")
//}
