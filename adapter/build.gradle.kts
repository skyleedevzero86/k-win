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
    implementation(project(":application"))
    testImplementation(testFixtures(project(":common")))
    testImplementation(testFixtures(project(":core")))
    testImplementation(testFixtures(project(":application")))

    // Swagger
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.4")

    // jwt
    implementation("io.jsonwebtoken:jjwt-api:0.12.6")
    implementation("io.jsonwebtoken:jjwt-impl:0.12.6")
    implementation("io.jsonwebtoken:jjwt-jackson:0.12.6")
}