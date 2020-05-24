package com.example.tinkoffnewsmvp.dto.news

import com.google.gson.annotations.SerializedName

class NewsResponse(
    @SerializedName("payload") val list: List<NewsBlockResponse>
)