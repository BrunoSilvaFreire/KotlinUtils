buildscript {
    repositories {
        mavenCentral()
    }
}
plugins {
    kotlin("jvm") version "1.3.50"
    id("io.wusa.semver-git-plugin") version "2.0.0-alpha.1"
    `maven-publish`
}


val ver = semver.info

allprojects {
    group = "me.ddevil"
    version = ver

}

repositories {
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile("com.google.guava:guava:28.1-jre")
}
publishing {
    publications {
        create<MavenPublication>("kotlinUtils") {
            from(components["java"])
        }
    }
}