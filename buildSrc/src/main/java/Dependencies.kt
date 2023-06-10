object AndroidX {
    const val coreKtx = "androidx.core:core-ktx:1.10.1"
    const val appCompat = "androidx.appcompat:appcompat:1.6.1"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.3"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navigationCompose = "androidx.navigation:navigation-compose:${Versions.navigation}"
    const val recyclerView = "androidx.recyclerview:recyclerview:1.2.1"
    const val recyclerViewSelection = "androidx.recyclerview:recyclerview-selection:1.1.0"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifeCycle}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifeCycle}"
    const val savedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifeCycle}"
    const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifeCycle}"
    const val processLifecycle = "androidx.lifecycle:lifecycle-process:${Versions.lifeCycle}"
    const val serviceLifecycle = "androidx.lifecycle:lifecycle-service:${Versions.lifeCycle}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val viewpager2 = "androidx.viewpager2:viewpager2:1.0.0"
    const val framePacing = "androidx.games:games-frame-pacing:1.9.1"
    const val performanceTuner = "androidx.games:games-performance-tuner:1.6.0"
    const val gamesActivity = "androidx.games:games-activity:1.2.2"
    const val gamesController = "androidx.games:games-controller:1.1.0"
    const val datastore = "androidx.datastore:datastore-preferences:1.0.0"
    const val activityCompose = "androidx.activity:activity-compose:1.7.2"
    const val composeRuntime = "androidx.compose.runtime:runtime:${Versions.compose}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val composeCompiler = "androidx.compose.compiler:compiler:${Versions.composeCompiler}"
    const val material3 = "androidx.compose.material3:material3:1.1.0"
}

object AndroidXTest {
    const val extJunit = "androidx.test.ext:junit:1.1.5"
    const val extJunitKtx = "androidx.test.ext:junit-ktx:1.1.5"
    const val espressoCore = "androidx.test.espresso:espresso-core:3.4.0"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4"
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4"
    const val testCore = "androidx.test:core:1.5.0"
    const val testCoreKtx = "androidx.test:core-ktx:1.5.0"
    const val roomTestHelpers = "androidx.room:room-testing:${Versions.room}"
}

object Google {
    const val material = "com.google.android.material:material:1.9.0"
}

object Hilt {
    const val android = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val compiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
}

object OkHttp {
    const val bom = "com.squareup.okhttp3:okhttp-bom:4.9.3"
    const val core = "com.squareup.okhttp3:okhttp"
    const val url = "com.squareup.okhttp3:okhttp-urlconnection"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor"
}

object Retrofit {
    const val core = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
}

object LiveEvent {
    const val core = "com.github.hadilq:live-event:1.3.0"
}

object Moshi {
    const val adapters = "com.squareup.moshi:moshi-adapters:${Versions.moshi}"
    const val core = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val codeGen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
}

object Tests {
    const val junit = "junit:junit:4.13.2"
}
