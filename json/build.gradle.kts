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

val sourcesJar by tasks.creating(Jar::class) {
    group = "documentation"
    from(sourceSets.main.get().allSource)
    archiveClassifier.set("sources")
}
publishing {
    publications {
        create<MavenPublication>("kotlinJson") {
            from(components["java"])
            artifact(sourcesJar)
        }
    }
}