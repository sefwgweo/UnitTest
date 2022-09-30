package com.example.unittest.data

import kotlinx.serialization.Serializable

@Serializable
data class Info2(
    val id: String,
    val count: String,
    val name: String,
)
