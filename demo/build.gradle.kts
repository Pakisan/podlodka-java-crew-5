plugins {
	java
	id("org.springframework.boot") version "2.7.18"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com.github.pakisan.podlodkajavacrew5"
version = "1.0.0"

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
	val cloudEventsVersion = "4.0.1"

	implementation("org.springframework.boot:spring-boot-starter-web")

	implementation("org.apache.eventmesh:eventmesh-sdk-java:${apacheEventMeshVersion}")
	implementation("org.apache.eventmesh:eventmesh-common:${apacheEventMeshVersion}")
	implementation("org.apache.eventmesh:eventmesh-storage-api:${apacheEventMeshVersion}")
	implementation("org.apache.eventmesh:eventmesh-connector-spring:${apacheEventMeshVersion}")

	// CloudEvents
	implementation("io.cloudevents:cloudevents-core:${cloudEventsVersion}")
	implementation("io.cloudevents:cloudevents-json-jackson:${cloudEventsVersion}")

	// OpenMessaging
	implementation("io.openmessaging:openmessaging-api:2.2.1-pubsub")

	// Boilerplate code
	compileOnly("org.projectlombok:lombok:1.18.30")
	annotationProcessor("org.projectlombok:lombok:1.18.30")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
