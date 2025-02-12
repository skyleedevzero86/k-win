import org.springframework.boot.gradle.tasks.bundling.BootJar

tasks.withType<BootJar> {
    enabled = false
}

tasks.withType<Jar> {
    enabled = true
}

dependencies {
    implementation(project(":common"))
    implementation(project(":core"))
    testImplementation(testFixtures(project(":common")))
    testImplementation(testFixtures(project(":core")))
}
