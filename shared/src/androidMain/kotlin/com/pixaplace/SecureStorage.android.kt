package com.pixaplace.storage

import android.content.Context
import com.pixaplace.SecureStorage

class AndroidSecureStorage(context: Context) : SecureStorage {
    private val prefs = context.getSharedPreferences("secure_storage", Context.MODE_PRIVATE)

    override suspend fun save(key: String, value: String) {
        prefs.edit().putString(key, value).apply()
    }

    override suspend fun get(key: String): String? = prefs.getString(key, null)

    override suspend fun remove(key: String) {
        prefs.edit().remove(key).apply()
    }

    override suspend fun clear() {
        prefs.edit().clear().apply()
    }
}