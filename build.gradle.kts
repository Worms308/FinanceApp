import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.0.2"
    id("io.spring.dependency-management") version "1.1.0"
    id("groovy")
    kotlin("jvm") version "1.8.10"
    kotlin("plugin.spring") version "1.8.10"
}

group = "com.worms"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

extra["testcontainersVersion"] = "1.17.6"

project.ext {
    set("spockVersion", "2.4-M1-groovy-4.0")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-elasticsearch")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.8.10")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.8.10")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    testImplementation("org.apache.groovy:groovy:4.0.8")

    testImplementation("org.spockframework:spock-core:${property("spockVersion")}")
    testImplementation("org.spockframework:spock-spring:${property("spockVersion")}")
    testImplementation("org.testcontainers:spock")
    testImplementation("org.testcontainers:elasticsearch")
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

dependencyManagement {
    imports {
        mavenBom("org.testcontainers:testcontainers-bom:${property("testcontainersVersion")}")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
