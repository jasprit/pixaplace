package com.pixaplace

interface SecureStorage {
    suspend fun save(key: String, value: String)
    suspend fun get(key: String): String?
    suspend fun remove(key: String)
    suspend fun clear()
}

// Optional: define common keys
object StorageKeys {
    const val TOKEN = "auth_token"
    const val USER_ID = "user_id"
    const val REFRESH_TOKEN = "refresh_token"
}

class AuthRepository(private val storage: SecureStorage) {

    suspend fun saveToken(token: String) = storage.save(StorageKeys.TOKEN, token)
    suspend fun getToken(): String? = storage.get(StorageKeys.TOKEN)
    suspend fun removeToken() = storage.remove(StorageKeys.TOKEN)
    suspend fun isLoggedIn(): Boolean = !getToken().isNullOrEmpty()

    // Generic key-value helpers
    suspend fun saveValue(key: String, value: String) = storage.save(key, value)
    suspend fun getValue(key: String): String? = storage.get(key)
}