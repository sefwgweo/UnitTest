package com.example.unittest.data

import kotlinx.serialization.Serializable

@Serializable
data class Info1(
    val keyCode: String,
    val total: String? = null,
    val date: String? = null,
)
