package com.example.unittest

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.skyscreamer.jsonassert.JSONAssert
import org.skyscreamer.jsonassert.JSONCompareMode

@RunWith(AndroidJUnit4::class)
class UseLibraryJsonCompareTest {
    @Test
    fun event1Test1() {
        val expected = loadJsonFromAssets(event1JsonPath)
        val actual = "{ \"TEST1\": [{\"keyCode\": \"1234-5678\"}],  " +
            "\"TEST2\": [{\"id\": \"5759348\",\"count\": \"417355\",\"name\": \"TOP\"}]}"

        JSONAssert.assertEquals(expected, actual, JSONCompareMode.LENIENT)
    }
}