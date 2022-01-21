package id.ibnu_19104020.praktikum6

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MyData(
    var name : String,
    var description : String,
    var photo : String,
    var lat : Double,
    var long: Double
) : Parcelable
