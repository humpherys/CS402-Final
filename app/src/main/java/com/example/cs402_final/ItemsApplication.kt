package com.example.cs402_final

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class ItemsApplication : Application() {

    // Will be torn down with process
    val applicationScope = CoroutineScope(SupervisorJob())


    // Using by lazy so the database and repository are only created when theyre needed
    // rather than when the application starts
    val database by lazy { ItemDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { ItemRepository(database.itemDao) }
}