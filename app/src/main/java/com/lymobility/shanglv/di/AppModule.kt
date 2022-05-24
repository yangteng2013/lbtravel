package com.lymobility.shanglv.di

import android.content.ClipboardManager
import android.content.Context
import android.os.Build
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun providesClipboardManager(@ApplicationContext context: Context):ClipboardManager{
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            context.applicationContext.getSystemService(ClipboardManager::class.java)
        } else {
            context.applicationContext.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        }
    }

}