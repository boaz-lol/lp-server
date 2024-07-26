import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = false
jar.enabled = true


allprojects {
    dependencies {
        api("org.springframework.boot:spring-boot-starter-data-jpa")
    }
}
