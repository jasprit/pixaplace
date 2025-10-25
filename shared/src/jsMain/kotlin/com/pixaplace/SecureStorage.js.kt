package com.pixaplace

import kotlinx.browser.localStorage

class JSSecureStorage : SecureStorage {
    override suspend fun save(key: String, value: String) {
        localStorage.setItem(key, value)
    }

    override suspend fun get(key: String): String? = localStorage.getItem(key)

    override suspend fun remove(key: String) {
        localStorage.removeItem(key)
    }

    override suspend fun clear() {
        localStorage.clear()
    }
}