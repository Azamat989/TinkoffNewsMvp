package com.example.tinkoffnewsmvp.dto.news

import com.google.gson.annotations.SerializedName

class NewsBlockResponse(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("text") val text: String,
    @SerializedName("publicationDate") val publicationDate: PublicationDate,
    @SerializedName("bankInfoTypeId") val bankInfoTypeId: Int
)