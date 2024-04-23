import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = false
jar.enabled = true

dependencies {
    implementation(project(":api"))
    implementation(project(":storage:core-mysql"))
    implementation(project(":api:admin"))
    implementation("org.springframework.boot:spring-boot-starter")
}
