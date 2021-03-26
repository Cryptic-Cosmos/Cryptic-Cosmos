import Build_gradle.*
import net.minecraftforge.gradle.userdev.DependencyManagementExtension

buildscript {
	repositories {
		maven(url = "https://files.minecraftforge.net/maven")
		jcenter()
		mavenCentral()
	}

	dependencies {
		classpath(group = "net.minecraftforge.gradle", name = "ForgeGradle", version = "4.1.+") { isChanging = true }
	}
}

plugins {
	`java-library`
	id("eclipse")
}

apply(plugin = "net.minecraftforge.gradle")

val minecraftVersion: String by extra
val forgeVersion: String by extra
val modVersion: String by extra
val geckolibVersion: String by extra

val modId: String by extra
val author: String by extra

val mavenGroup: String by extra
val baseName: String by extra

version = "$minecraftVersion-$modVersion"
group = mavenGroup
base.archivesBaseName = baseName

// Java 8 Target
tasks.withType<JavaCompile> {
	sourceCompatibility = "1.8"
	targetCompatibility = "1.8"
}

repositories {
	maven(url = "https://repo.repsy.io/mvn/gandiber/geckolib")
	maven(url = "https://jitpack.io")
}

dependencies {
	"minecraft"(group = "net.minecraftforge", name = "forge", version = "$minecraftVersion-$forgeVersion")

	// geckolib
	implementation(project.the<DependencyManagementExtension>()
		.deobf("software.bernie.geckolib:geckolib-forge-$minecraftVersion:$geckolibVersion"))
}

minecraft {
	mappingChannel = "official"
	mappingVersion = minecraftVersion

	accessTransformer(file("src/main/resources/META-INF/accesstransformer.cfg"))

	runs {
		config("client")

		config("server")

		config("data") {
			args(
				"--mod",
				modId,
				"--all",
				"--output",
				file("src/generated/resources/"),
				"--existing",
				file("src/main/resources/")
			)
		}
	}
}

// Manifest
tasks.withType<Jar> {
	manifest {
		attributes(
			"Specification-Title" to modId,
			"Specification-Vendor" to author,
			"Specification-Version" to "1",
			"Implementation-Title" to "Cryptic Cosmos",
			"Implementation-Version" to modVersion,
			"Implementation-Vendor" to author,
			"Implementation-Timestamp" to Date().format("yyyy-MM-dd'T'HH:mm:ssZ")
		)
	}
}

// Finalize the jar by Reobf
tasks.named<Jar>("jar") { finalizedBy("reobfJar") }

sourceSets["main"].resources.srcDir("src/generated/resources")

// Utilities

typealias Date = java.util.Date
typealias SimpleDateFormat = java.text.SimpleDateFormat

fun Date.format(format: String) = SimpleDateFormat(format).format(this)

typealias RunConfig = net.minecraftforge.gradle.common.util.RunConfig
typealias UserDevExtension = net.minecraftforge.gradle.userdev.UserDevExtension

typealias RunConfiguration = RunConfig.() -> Unit

fun minecraft(configuration: UserDevExtension.() -> Unit) =
	configuration(extensions.getByName("minecraft") as UserDevExtension)

fun NamedDomainObjectContainerScope<RunConfig>.config(name: String, additionalConfiguration: RunConfiguration = {}) {
	val runDirectory = project.file("run")
	val sourceSet = the<JavaPluginConvention>().sourceSets["main"]

	create(name) {
		workingDirectory(runDirectory)
		property("forge.logging.markers", "NONE")
		property("forge.logging.console.level", "debug")

		additionalConfiguration(this)

		mods { create(modId) { source(sourceSet) } }
	}
}