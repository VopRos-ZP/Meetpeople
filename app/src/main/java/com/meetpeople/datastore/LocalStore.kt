package com.meetpeople.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalStore @Inject constructor(private val context: Context) {

    private val Context.dataStore by preferencesDataStore(name = "settings")

    companion object {
        val TOKEN_KEY = stringPreferencesKey("token")
        val PHONE_KEY = stringPreferencesKey("phone")
        val PASSWORD_KEY = stringPreferencesKey("password")
    }

    val token: Flow<String?> = context.dataStore.data.map { it[TOKEN_KEY] }
    val phone = context.dataStore.data.map { it[PHONE_KEY] }
    val password = context.dataStore.data.map { it[PASSWORD_KEY] }

    val config = token
        .combine(phone) { t, p -> Pair(t, p) }
        .combine(password) { (t, ph), pas -> Triple(t, ph, pas) }

    suspend fun saveToken(token: String) {
        context.dataStore.edit { it[TOKEN_KEY] = token }
    }

    suspend fun savePhone(phone: String) {
        context.dataStore.edit { it[PHONE_KEY] = phone }
    }

    suspend fun savePassword(password: String) {
        context.dataStore.edit { it[PASSWORD_KEY] = password }
    }

}