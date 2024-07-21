import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = false
jar.enabled = true
dependencies {
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign:4.1.1")
    implementation(project(":common"))
    implementation(project(":infrastructure:kafka"))
    // implementation("io.github.openfeign:feign-jackson:11.9")
}

dependencyManagement {

    imports {
        mavenBom ("org.springframework.cloud:spring-cloud-dependencies:2023.0.1")
    }

}