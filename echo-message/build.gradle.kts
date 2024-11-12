plugins {
    java
    id("org.springframework.boot") version "2.7.18"
    id("io.spring.dependency-management") version "1.1.6"
}

group = "com.github.pakisan.podlodkajavacrew5"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    val apacheEventMeshVersion = "1.10.0-release"

    implementation("org.springframework.boot:spring-boot-starter-web")

    // EventMesh
    implementation("org.apache.eventmesh:eventmesh-sdk-java:${apacheEventMeshVersion}")
    implementation("org.apache.eventmesh:eventmesh-common:${apacheEventMeshVersion}")
    implementation("org.apache.eventmesh:eventmesh-storage-api:${apacheEventMeshVersion}")
    implementation("org.apache.eventmesh:eventmesh-connector-spring:${apacheEventMeshVersion}")

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
