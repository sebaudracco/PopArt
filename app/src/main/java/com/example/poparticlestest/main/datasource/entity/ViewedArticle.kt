package com.example.poparticlestest.main.datasource.entity

import android.media.Image

data class ViewedArticle (
    val url: String,
    val adx_keywords: String,
    val colum: String,
    val section: String,
    val byline: String,
    val type: String,
    val title: String,
    val abstract: String,
    val published_date: String,
    val source: String,
    val id: Int,
    val asset_id: Int,
    val des_facet: Array <String>,
    val org_facet: Array <String>,
    val per_facet: Array <String>,
    val geo_facet: Array <String>,
    val media: Array <Image>,
    val subtype: String,
    val caption: String,
    val copyrigth: String,
    val approved_for_syndication : Boolean)

