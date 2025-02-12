plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "k-win"

include("common")
include("core")
include("adapter")
include("application")