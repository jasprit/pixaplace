package com.pixaplace.storage

import com.pixaplace.SecureStorage
import platform.Foundation.NSUserDefaults

class IOSSecureStorage : SecureStorage {
    private val defaults = NSUserDefaults.standardUserDefaults

    override suspend fun save(key: String, value: String) {
        defaults.setObject(value, key)
    }

    override suspend fun get(key: String): String? = defaults.stringForKey(key)

    override suspend fun remove(key: String) {
        defaults.removeObjectForKey(key)
    }

    override suspend fun clear() {
        defaults.dictionaryRepresentation().keys.forEach { defaults.removeObjectForKey(it as String) }
    }
}