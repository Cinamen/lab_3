plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.hibernate.validator:hibernate-validator:8.0.1.Final")
    // https://mvnrepository.com/artifact/org.testng/testng
    testImplementation("org.testng:testng:7.8.0")
}

tasks.test {
    useTestNG()
}