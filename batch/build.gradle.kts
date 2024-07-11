import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = true
jar.enabled = false

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation(project(":domain"))
    implementation(project(":common:enum"))
    implementation(project(":common"))

    implementation(project(":storage:core-mongo"))
    implementation(project(":infrastructure"))
    implementation(project(":infrastructure:kafka"))

    runtimeOnly(project(":storage:core-mysql"))
    implementation("org.springframework.boot:spring-boot-starter-batch")
}