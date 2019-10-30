buildscript {
    repositories {
        mavenCentral()
    }
}
plugins {
    kotlin("jvm") version "1.3.50"
    id("io.wusa.semver-git-plugin") version "2.0.0-alpha.1"
    id("com.novoda.build-properties") version "0.4.1"
    `maven-publish`
}

repositories {
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile("com.google.guava:guava:28.1-jre")
}

val ver = semver.info
val secretPropertiesName = "secrets"
buildProperties {
    create(secretPropertiesName) {
        using(file("secrets.properties"))
    }
}

val (gitHubPackagesUsername, gitHubPackagesToken) = with(buildProperties) {
    var u: String? = null
    var p: String? = null
    named(secretPropertiesName) {
        u = getAt("gpr.username").string
        p = getAt("gpr.token").string
    }
    return@with u to p
}

allprojects {
    group = "me.ddevil"
    version = ver
    apply(plugin = "org.gradle.maven-publish")

    publishing {
        repositories {
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/BrunoSilvaFreire/KotlinUtils")
                credentials {
                    username = gitHubPackagesUsername
                    password = gitHubPackagesToken
                }
            }
        }
    }
}


val sourcesJar by tasks.creating(Jar::class) {
    group = "documentation"
    from(sourceSets.main.get().allSource)
    archiveClassifier.set("sources")
}

publishing {
    publications {
        create<MavenPublication>("kotlinUtils") {
            pom {
                url.set("https://github.com/BrunoSilvaFreire/KotlinUtils")
            }
            from(components["java"])
            artifact(sourcesJar)
        }
    }
}