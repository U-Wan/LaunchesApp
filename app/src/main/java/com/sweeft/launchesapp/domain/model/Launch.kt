package com.sweeft.launchesapp.domain.model

import com.google.gson.annotations.SerializedName

data class Launch(
    @SerializedName("mission_name")
    var missionName: String?,
    @SerializedName("flight_number")
    val flightNumber: Int,
    @SerializedName("launch_year")
    val launchYear: String,
    val rocket: Rocket,
    val links: Links?,
    val details: String?
)

data class Rocket(
    @SerializedName("rocket_id")
    val rocketId: String?,
    @SerializedName("rocket_name")
    val rocketName: String
)

data class Links(
    @SerializedName("flickr_images")
    val flickrImages: List<String>
)
