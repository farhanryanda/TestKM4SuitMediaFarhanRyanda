package com.farhanryanda.testkm4suitmediafarhanryanda.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class UserEntity(
    @field:ColumnInfo(name = "id")
    @field:PrimaryKey
    val id: Int,

    @field:ColumnInfo(name = "first_name")
    val firstName: String,

    @field:ColumnInfo(name = "last_name")
    val lastName: String,

    @field:ColumnInfo(name = "avatar")
    val avatar: String,

    @field:ColumnInfo(name = "email")
    val email: String,

) : Parcelable