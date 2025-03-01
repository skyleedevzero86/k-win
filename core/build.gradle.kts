import org.springframework.boot.gradle.tasks.bundling.BootJar

tasks.withType<BootJar> {
    enabled = false
}

tasks.withType<Jar> {
    enabled = true
}

dependencies {
    implementation(project(":common"))
    testImplementation(testFixtures(project(":common")))

    // h2
    runtimeOnly("com.h2database:h2")
}
