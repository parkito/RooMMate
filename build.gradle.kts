group = "ru.siksmfp.spring.play"
version = "0.1.1"

val appArchiveName = "stream-$version"

plugins {
    application
    kotlin("jvm") version "1.3.20"
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

//application {
//    mainClassName = "samples.HelloWorldKt"
//}

dependencies {
    compile(kotlin("stdlib"))
    compile("org.springframework:spring-context:5.1.6.RELEASE")
    testCompile("org.junit.jupiter:junit-jupiter-engine:5.4.1")
}

repositories {
    jcenter()
    mavenCentral()
}

val jar by tasks.getting(Jar::class) {
    archiveName = "$appArchiveName.jar"
    into("META-INF") {
    }
}
