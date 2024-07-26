import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = true
jar.enabled = false

dependencies {
    implementation(project(":domain"))
    implementation(project(":common:enum"))
    implementation(project(":common"))

    implementation(project(":storage:core-mongo"))
    implementation(project(":infrastructure"))
    implementation(project(":infrastructure:kafka"))

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-batch")
    runtimeOnly("com.mysql:mysql-connector-j")
}