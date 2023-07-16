plugins {
    kotlin("jvm") version "1.8.0"
    `maven-publish`
    java
}

group = "com.github.Dev-Beom"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework:spring-context:5.2.21.RELEASE")
    implementation("org.slf4j:slf4j-api:1.7.30")
    testImplementation(kotlin("test"))
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "${JavaVersion.VERSION_11}"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "${JavaVersion.VERSION_11}"
    }
}


tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = group.toString()
            artifactId = "kwarm-up"
            version = version

            from(components["java"])
        }
    }
}