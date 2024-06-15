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
        implementation(project(":common"))
        implementation(project(":infrastructure"))

        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("org.springframework.boot:spring-boot-starter-mail")
        compileOnly("org.springframework:spring-tx")
}
