# Meetpeople

## Setup

If you are using a version of Gradle below 8.1, 
you need to annotate the `plugins{}` block with `@Suppress("DSL_SCOPE_VIOLATION")` when using version catalogs.

Example:

`build.gradle.kts`
```.gradle.kts
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    //...
}
true // Use it only top level build.gradle.kts
```
