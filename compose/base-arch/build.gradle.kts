plugins {
    libPlugins().forEach(::id)
}

apply<com.splanes.plugins.JitpackPublishPlugin>()
configure<com.splanes.plugins.JitpackPublishPluginExtension> {
    artifactVersion.set(project.property("lib.base-arch.version") as String)
}

android {
    namespace = "com.splanes.toolkit.compose.base_arch"

    applyLibModuleDefaultConfig()

    applyLibFlavors()

    applyCompileOptions()

    kotlinOptions { jvmTarget() }

    withFeatures(Feature.Compose)

    composeOptions { kotlinCompilerExtensionVersion = DependencyVersion.compose }
}

dependencies {
    androidCore()
    androidRuntime()

    timber()

    compose()
    ktxCoroutines()

    test()
}