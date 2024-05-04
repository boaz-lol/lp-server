import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = false
jar.enabled = true


dependencies {
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign:4.1.1")
}

dependencyManagement {

    imports {
        mavenBom ("org.springframework.cloud:spring-cloud-dependencies:2023.0.1")
    }

}