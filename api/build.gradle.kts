import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = true
jar.enabled = false


dependencies {
        runtimeOnly(project(":storage:core-mysql"))
        implementation(project(":api:admin"))
        implementation(project(":domain"))
        implementation(project(":common:enum"))
        implementation(project(":infrastructure"))

        implementation("org.springframework.boot:spring-boot-starter-web")
        // implementation("jakarta.transaction:jakarta.transaction-api:2.0.1")
        compileOnly("org.springframework:spring-tx")
}
