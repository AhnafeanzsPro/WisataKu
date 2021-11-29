package com.example.wisataku.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Wisataku(
    var name: String?,
    var detail: String?,
    var highlight: String?,
    var fasilitas: String?,
    var harga: String?,
    var photo: Int?
): Parcelable