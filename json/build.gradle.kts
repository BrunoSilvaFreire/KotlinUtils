plugins {
    kotlin("jvm")
    `maven-publish`
}
repositories {
    mavenCentral()
}
dependencies {
    compile(rootProject)
    testCompile("junit:junit:4.12")
}

publishing {
    publications {
        create<MavenPublication>("kotlinJson") {
            from(components["java"])
        }
    }
}