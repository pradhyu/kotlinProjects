// Run Kotlin REPL with built source code and main classpath in Gradle
// Run as: ./gradlew kotlinRepl --console plain --no-daemon
val kotlinRepl by tasks.creating {
  description = "Starts Kotlin REPL with compiled main classes and runtime classpath"
  val mainSourceSet = java.sourceSets["main"]
  dependsOn(mainSourceSet.output)
  doFirst {
    val buildscriptClasspath = rootProject.buildscript.configurations["classpath"]

    val kotlinPluginJars = buildscriptClasspath
      .resolvedConfiguration
      .resolvedArtifacts
      .filter { it.moduleVersion.id.group == "org.jetbrains.kotlin" }
      .map { it.file }

    val mainClasspath = mainSourceSet.runtimeClasspath.joinToString(separator = ":")
    javaexec {
      classpath = files(kotlinPluginJars)
      main = "org.jetbrains.kotlin.cli.jvm.K2JVMCompiler"
      standardInput = System.`in`
      args("-cp", mainClasspath)
    }
  }
}
