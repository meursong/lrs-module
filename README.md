# xAPI Module

** xAPI Module is a lightweight and modular library for creating xAPI-compliant statements in Java-based projects. It simplifies the process of generating xAPI statements while adhering to the xAPI (Experience API) specification. This library does not include Learning Record Store (LRS) integration, focusing instead on statement creation.

---

## Features

- xAPI Statement Creation: Easily create xAPI-compliant statements, including actors, verbs, objects, and contexts.
- Modular Design: Use only the components you need for your project.
- Extensible: Customize and extend functionality to suit your requirements.
- Lightweight: Designed for efficiency with minimal dependencies.
- Easy Integration: Compatible with Gradle and Maven for seamless dependency management.
- Multilingual Support: Generate statements with display names in multiple languages based on the RFC 5646 language tag standard.

---

## Getting Started

### Prerequisites

- Java 11 or higher
- Gradle or Maven

### Installation

#### Gradle
Add the following dependency to your `build.gradle` file:
```gradle
dependencies {
    implementation 'com.meursong:lrs-module:0.1.0-SNAPSHOT'
}
```

#### Maven
Add the following dependency to your `pom.xml` file:
```maven
<dependency>
    <groupId>com.meursong</groupId>
    <artifactId>lrs-module</artifactId>
    <version>0.1.0-SNAPSHOT</version>
</dependency>
```
