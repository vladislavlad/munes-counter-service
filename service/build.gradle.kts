import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

repositories {
    mavenLocal()
    mavenCentral()
}

val springCloudVersion = "2023.0.0"
val kotestVersion = "5.8.0"
val platformVersion = "0.4.2"
val schemaRegistryVersion = "0.0.1"

dependencies {
    implementation(project(":api-client"))
    implementation("software.darkmatter:interaction-protocol:$platformVersion")
    implementation("software.darkmatter:interaction-messaging:$platformVersion")
    implementation("software.darkmatter:platform-core:$platformVersion")
    implementation("software.darkmatter:security-core:$platformVersion")
    implementation("software.darkmatter:security-jwt-client-starter:$platformVersion")
    implementation("software.darkmatter:schema-registry:$schemaRegistryVersion")

    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    implementation("jakarta.validation:jakarta.validation-api:3.0.2")
    implementation("org.hibernate:hibernate-validator:8.0.1.Final")

    implementation("org.flywaydb:flyway-core")
    implementation("org.postgresql:r2dbc-postgresql")
    runtimeOnly("org.postgresql:postgresql")

    implementation("io.arrow-kt:arrow-core:1.1.5")
    implementation("io.github.microutils:kotlin-logging:3.0.5")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
//    testImplementation("org.springframework.boot:spring-boot-starter-test")
//    testImplementation("io.projectreactor:reactor-test")
    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion")
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

java.sourceCompatibility = JavaVersion.VERSION_21

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict", "-Xjvm-default=all")
        jvmTarget = "21"
    }
}

tasks.jar { enabled = false }

tasks.withType<Test> {
    useJUnitPlatform()
}
