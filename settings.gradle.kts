import java.io.File

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "CrosshairOverlay"
include(":app")

// Keep Gradle outputs outside OneDrive to avoid file-lock build failures on Windows.
val localBuildRoot = File(System.getProperty("user.home"), ".crosshair-overlay-build")
gradle.beforeProject {
    val segment = path.removePrefix(":").replace(':', File.separatorChar)
    val dir = if (segment.isEmpty()) "root" else segment
    layout.buildDirectory.set(localBuildRoot.resolve(dir))
}
