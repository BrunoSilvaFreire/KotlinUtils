buildscript {
    repositories {
        mavenCentral()
    }
}
plugins {
    kotlin("jvm") version "1.3.50"
    `maven-publish`
}

allprojects {
    group = "me.ddevil"
    version = "1.2.0-SNAPSHOT"

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