plugins {
    kotlin("jvm") version "1.8.0"
    `maven-publish`
}

group = "com.github.Dev-Beom"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework:spring-context:5.2.21.RELEASE")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}