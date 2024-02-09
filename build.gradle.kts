group = "software.darkmatter"
version = "0.1.0"

subprojects {
    version = rootProject.version
    group = rootProject.group
}

repositories {
    mavenLocal()
    mavenCentral()
}

plugins {
    kotlin("jvm") version "1.9.22" apply false
    kotlin("plugin.spring") version "1.9.22" apply false
    id("org.springframework.boot") version "3.2.2" apply false
    id("io.spring.dependency-management") version "1.1.4" apply false
}
