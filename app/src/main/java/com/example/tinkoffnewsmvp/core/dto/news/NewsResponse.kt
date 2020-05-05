package com.example.tinkoffnewsmvp.core.dto.news

import com.google.gson.annotations.SerializedName

class NewsResponse(
    @SerializedName("payload") val list: List<NewsBlockResponse>
)