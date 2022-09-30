package com.example.unittest.data

import kotlinx.serialization.Serializable

@Serializable
data class Event1(
    val TEST1: List<Info1>,
    val TEST2: List<Info2>,
): ExpectedObject
