package com.example.poparticlestest.main.datasource.entity

import com.google.gson.annotations.SerializedName


data class ViewedArticle (
    val status: String,
    val copyright: String,
    val num_results: Int,
    val results : List<Results>
)

data class Results (
    val uri: String,
    val url: String,
    val id: Long,
    val adx_keywords: String,
    val colum: String,
    val section: String,
    val subsection: String,
    val nytdsection: String,
   // val column : String ?=null,
    val byline: String,
    val type: String,
    val title: String,
    val abstract: String,
    val published_date: String,
    val update: String,
    val source: String,
    val asset_id: Long,
    val des_facet: Array <String>,
    val org_facet: Array <String>,
    val per_facet: Array <String>,
    val geo_facet: Array <String>,
    val media: List <Media>,
    val subtype: String,
    val eta_id: Int
    )

    data class Media(
        val type: String,
        val subtype: String,
        val caption: String,
        val copyrigth: String,
        val approved_for_syndication: Int,
        val mediaMetadata : List <MediaMetaData>
    )

    data class MediaMetaData(
        val url: String,
        val format: String,
        val heigth: Int,
        val width: Int
    )

