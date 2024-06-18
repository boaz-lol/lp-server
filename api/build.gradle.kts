import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = true
jar.enabled = false

allprojects {
        dependencies {
                implementation("org.springframework.boot:spring-boot-starter-web")
                implementation(project(":domain"))
                implementation(project(":common:enum"))
                implementation(project(":common"))
        }
}

dependencies {
        runtimeOnly(project(":storage:core-mysql"))
        runtimeOnly(project(":storage:core-mongo"))
        implementation(project(":api:admin"))
        implementation(project(":infrastructure"))

        implementation("org.springframework.boot:spring-boot-starter-mail")
        compileOnly("org.springframework:spring-tx")
}
