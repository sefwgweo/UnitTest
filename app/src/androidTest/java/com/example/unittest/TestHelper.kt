package com.example.unittest

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.unittest.data.Event1
import com.example.unittest.data.ExpectedObject
import junit.framework.TestCase
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlin.reflect.full.memberProperties

val appContext: Context = ApplicationProvider.getApplicationContext()
const val event1JsonPath = "expected-data/test_event1.json"

// Jsonをオブジェクト変換
inline fun <reified T> decodeJson(jsonString: String): T {
    return Json.decodeFromString<T>(jsonString)
}

// assetsからJson読み込み
fun loadJsonFromAssets(path: String): String {
    return appContext.assets.open(path).use {
        it.reader().readText()
    }
}

// アサーション
inline fun <reified T : ExpectedObject> assertion(
    expectedData: T,
    actualValues: List<Map<String, String?>>
) {
    when (expectedData) {
        is Event1 -> {
            // DataClassをMutableなMapにする
            val map1 = expectedData.TEST1[0].asMap().toMutableMap()
            val map2 = expectedData.TEST2[0].asMap().toMap()

            // Info1でNullableで、本テストでは削除対象なKey
            val nullableKeys = listOf("total", "date")
            nullableKeys.map {
                if (map1[it] == null) {
                    map1.remove(it)
                }
            }
            
            TestCase.assertEquals(map1, actualValues[0])
            TestCase.assertEquals(map2, actualValues[1])
        }
        else -> {
        }
    }
}

// DataクラスをMapにするための処理(リフレクションを用いています)
inline fun <reified T : Any> T.asMap(): Map<String, Any?> {
    val props = T::class.memberProperties.associateBy { it.name }
    return props.keys.associateWith { props[it]?.get(this) }
}
