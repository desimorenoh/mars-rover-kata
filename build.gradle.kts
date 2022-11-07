import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.6.10"
	application
}

group = "com.my-backend-test"
version = "1.0-SNAPSHOT"

application {
	mainClass.set("com.marsRover.Application")
}

java.sourceSets["main"].java {
	srcDir(
		"src/main/kotlin"
	)
}

repositories {
	mavenCentral()
}

dependencies {
	implementation(kotlin("stdlib"))

	// Test
	testImplementation("org.junit.jupiter:junit-jupiter:5.9.0")
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
	testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.0")
	testImplementation("org.junit.vintage:junit-vintage-engine:5.9.0")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
	testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")
}

tasks.test {
	useJUnitPlatform()
	testLogging {
		events("passed", "skipped", "failed")
	}
}

// config JVM target to 1.8 for kotlin compilation tasks
tasks.withType<KotlinCompile>().configureEach {
	kotlinOptions.jvmTarget = "1.8"
}

tasks.test {
	useJUnitPlatform()
}

tasks.withType(Test::class).configureEach {
	useJUnitPlatform()
}

val run by tasks.getting(JavaExec::class) {
	standardInput = System.`in`
}