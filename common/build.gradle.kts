import org.springframework.boot.gradle.tasks.bundling.BootJar

tasks.withType<BootJar> {
    enabled = false
}

tasks.withType<Jar> {
    enabled = true
}

dependencies {
    api("io.github.microutils:kotlin-logging-jvm:2.0.11")
<<<<<<< HEAD

    // jasypt
    implementation("com.github.ulisesbocchio:jasypt-spring-boot-starter:3.0.5")
=======
>>>>>>> 956c160 (feat:모듈 정리)
}
