import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = true
jar.enabled = false


dependencies {
    implementation("org.springframework.security:spring-security-web")
    implementation("org.springframework.security:spring-security-config")
}