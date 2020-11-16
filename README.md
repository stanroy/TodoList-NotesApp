<!-- PROJECT LOGO -->
<br />
<p align="center">


  <h1 align="center">TodoList-NotesApp</h3>


<!-- ABOUT THE PROJECT -->
## About The Project
Android TodoList/Notes app made using <b>Kotlin</b>. My main goal was to get familliar with MVVM architecture design and Android Navigation Component.
App uses one activity with two fragments.


### What I Used

* [Android Navigation Components](https://developer.android.com/guide/navigation/navigation-getting-started)
* [Kotlin Android Extensions](https://antonioleiva.com/kotlin-android-extensions/)
* [Data-binding](https://developer.android.com/topic/libraries/data-binding)
* [Safeargs](https://developer.android.com/guide/navigation/navigation-pass-data)
* [Kotlin Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)
* [Room database](https://developer.android.com/training/data-storage/room)
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
* [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
* [Koin](https://github.com/InsertKoinIO/koin)
* [RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview)


## First fragment

First fragment contains main screen with the list of all notes saved in the Room database. List is being shown by RecyclerView, so it is possible to scroll it. You can add new notes by pressing plus button in the bottom right corner.

Every note has two buttons next to it. You can modify single note by pressing button with pen icon or you can delete it by pressing trashcan icon.

If you want to delete all notes, you can do so by pressing Clear All button in the bottom left corner.

<img src="https://i.ibb.co/wyyL9Mk/Screenshot-from-2020-11-16-17-48-32.png" width="340px">
<img src="https://i.ibb.co/pvm28JR/Screenshot-from-2020-11-16-17-48-46.png" width="340px">



## Second fragment

After pressing Modify button or Add button you are transitioned to the second fragment. In the second fragment you can add or modify note's title and body. You save the note to the database by pressing Save button or you can cancel it by pressing Cancel button

<img src="https://i.ibb.co/pdr9HBR/Screenshot-from-2020-11-16-17-48-59.png" width="340px">

## TODO

- Checkboxes
