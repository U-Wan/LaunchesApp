package com.sweeft.myapp.domain



data class Launch(
    val flightNumber: Int,
    val missionName: String,
    val launchYear: String?,
    val rocket: Rocket?,
    val links: LaunchLinks?,
    val details: String?
)

data class Rocket(
    val rocketId: String?,
    val rocketName: String?
)

data class LaunchLinks(
    val flickrImages: List<String?>
)

