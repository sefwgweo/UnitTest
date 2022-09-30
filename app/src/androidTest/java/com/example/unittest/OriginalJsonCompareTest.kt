package com.example.unittest

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.unittest.data.Event1
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class OriginalJsonCompareTest {
    @Test
    fun event1Test2() {
        // assets配下に保存されたJsonを読み込みEvent1オブジェクトに変換
        val expectedObj = decodeJson<Event1>(loadJsonFromAssets(event1JsonPath))

        // 検査対象のデータは取り急ぎmapで生成
        val actualObjTest1 = mapOf("keyCode" to "1234-5678")
        val actualObjTest2 = mapOf(
                "id" to "5759348",
                "count" to "417355",
                "name" to "TOP"
            )

        // アサーション実行
        assertion(expectedObj, listOf(actualObjTest1, actualObjTest2))
    }
}