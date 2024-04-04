import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = true
jar.enabled = false


dependencies {
    // runtimeOnly(project(mapOf("path" to ":storage:core-mysql")))
    runtimeOnly(project(":storage:core-mysql"))
    implementation(project(":domain"))
    implementation("org.springframework.boot:spring-boot-starter-web")
}
