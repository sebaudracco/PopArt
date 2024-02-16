package com.example.poparticlestest.main.datasource.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class ViewedArticle(
    @PrimaryKey
    val copyright: String,
    val status: String,
    val num_results: Int,
    val results: List<Results>?
)

data class Results(
    val id: Long,
    val uri: String,
    val url: String,
    val adx_keywords: String,
    val colum: String,
    val section: String,
    val subsection: String,
    val nytdsection: String,
    val byline: String,
    val type: String,
    val title: String,
    val abstract: String,
    val published_date: String,
    val update: String,
    val source: String,
    val asset_id: Long,
    val media: List<Media>?,
    val subtype: String,
    val eta_id: Int
)

data class Media(
    val type: String,
    val subtype: String,
    val caption: String,
    val copyrigth: String,
    val approved_for_syndication: Int,
    val mediaMetadata: List<MediaMetaData>?
)

data class MediaMetaData(
    val url: String,
    val format: String,
    val heigth: Int,
    val width: Int
)

