# Mathem Book A Delivery - Sample Assignment App

This app was originally meant to serve as Mathem's code assignment, but I have been expanding it as a way to experiment and practice the new modern Android development techniques. Description of the assignment can be found here: [Mathem's Original Assignmwnt](https://github.com/FelipeRRM/mathem/blob/aaed92e5dd7474ff78fce70d7e2ee6ea25235b95/specs.pdf).

The app loads and displays possible delivery dates to the user, who can select one of them and book. The user can filter the delivery slots by excluding non in-home deliveries. Delivery dates and slots, after loaded from the network, are cached in a database and are not loaded again. The logic is very naive and just assumes the data stored in the database is up to date, and never really refreshes it. This is no good for a production app, which should care about syncing the data between the device and the network. Google has a pretty good documentation about it here: [Build an offline-first app](https://developer.android.com/topic/architecture/data-layer/offline-first).

I had a lot of fun working on this project and I hope you have a good time reviewing it and experimenting with it. Remember that I did this on my free time while trying to keep a healthy work-life balance so don't judge it too harshly. Of course there are a lot of things to be improved and I would love to hear your thoughts about it! A project is never really "done", is it? There will always be things to improve!

In this app you'll find:
*   User Interface built with **[Jetpack Compose](https://developer.android.com/jetpack/compose)** 
*   A single-activity architecture, using **[Navigation Compose](https://developer.android.com/jetpack/compose/navigation)**.
*   A presentation layer that contains a Compose screen (View) and a **ViewModel** per screen (or feature).
*   Reactive UIs using **[Flow](https://developer.android.com/kotlin/flow)** and **[coroutines](https://kotlinlang.org/docs/coroutines-overview.html)** for asynchronous operations.
*   A **data layer** with a repository and two data sources (local using Room and a remote).
*   Dependency injection using [Hilt](https://developer.android.com/training/dependency-injection/hilt-android).
*   Multi-module approach. Separated into feature-modules and libraries. Very good strategy to avoid circular dependencies, allows for easy code reusability, facilitates multiple teams working in the same app and enables great features like instant-app experiences. Build times are also greatly reduced in a multi-modular project, when structured properly. A complete guide to the approach utilized here can be found here: [Modularization - Why you should care](https://jeroenmols.com/blog/2019/03/06/modularizationwhy/) 
*   A couple of industry-standard libraries are used throughout the project, like Retrofit, Moshi, Lottie, OkHttp

## App Running



## Opening & Building in Android Studio

This project was created and is tested to be working with Android Studio Flamingo 2022.2.1 Patch 2 (Build on May 12, 2023)
