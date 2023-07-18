[![](https://jitpack.io/v/Dev-Beom/KWarmUp.svg)](https://jitpack.io/#Dev-Beom/KWarmUp)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
# KWarmUp
A project that facilitates JVM Warmup in Spring-based projects.

# Version
✅ Spring Framework 5.3.x with JDK 8 - 19 (expected)  
✅ Spring Framework 5.2.x with JDK 8 - 15  
✅ Spring Framework 5.1.x with JDK 8 - 12  
❌ Spring Framework 5.0.x with JDK 8 - 10  
❌ Spring Framework 4.3.x with JDK 6 - 8 (its official EOL(end-of-life))  
  
✅ Spring Boot 2.3↑ with Java 9 and above  
✅ Spring Boot 2.1↓ with Java 8 - 11

# Usage
#### 1. Add the JitPack repository to your build file
- gradle
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}  
```
- maven
```
<positories>
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
</repositories>
```
#### 2. Add the dependency
- gradle
```
dependencies {
    implementation 'com.github.Dev-Beom:KWarmUp:Tag'
}
```
- maven
```
<dependency>
	<groupId>com.github.Dev-Beom</groupId>
	<artifactId>KWarmUp</artifactId>
    <version>Tag</version>
</dependency>
```

#### 3. Add EnableKWarmUp Annotation to @Component
```kotlin
@EnableKWarmUp
@Configuration
class SomeConfiguration
```

#### 4. Write KWarmUp annotation on the target (method) to be warmed up.
However, the class of the target method must be @Component. (Annotations that inherit and use this are also possible. @Service, @Repository, @Configuration...)
```kotlin
@Service
class SomeService {
    @KWarmUp(repeatCount = 256)
    fun callMailService() {
    }
}
```
