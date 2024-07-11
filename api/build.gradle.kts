import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = true
jar.enabled = false


dependencies {
        runtimeOnly(project(":storage:core-mysql"))
        implementation(project(":storage:core-mongo"))
        implementation(project(":api:admin"))
        implementation(project(":domain"))
        implementation(project(":common:enum"))
        implementation(project(":common"))
        implementation(project(":infrastructure"))

        implementation("org.springframework.boot:spring-boot-starter-web")
        compileOnly("org.springframework:spring-tx")
}
