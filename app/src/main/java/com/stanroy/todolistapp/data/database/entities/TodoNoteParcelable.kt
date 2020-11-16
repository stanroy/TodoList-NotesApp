package com.stanroy.todolistapp.data.database.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class TodoNoteParcelable(
    var noteId: Int?,
    var noteTitle: String?,
    var noteBody: String?
) : Parcelable