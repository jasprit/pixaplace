package com.pixaplace.storage

import android.content.Context
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import androidx.core.content.edit

class AndroidSecureStorage : SecureStorage, KoinComponent {

    private val context: Context by inject()
    private val prefs = context.getSharedPreferences("secure_storage", Context.MODE_PRIVATE)

    override suspend fun save(key: String, value: String) {
        prefs.edit { putString(key, value) }
    }

    override suspend fun get(key: String): String? = prefs.getString(key, null)

    override suspend fun remove(key: String) {
        prefs.edit { remove(key) }
    }

    override suspend fun clear() {
        prefs.edit { clear() }
    }
}