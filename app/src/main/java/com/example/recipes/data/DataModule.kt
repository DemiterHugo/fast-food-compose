package com.example.recipes.data

import android.content.Context
import androidx.room.Room
import com.example.recipes.data.database.FoodDataBase
import com.example.recipes.data.room.ItemDao
import com.example.recipes.data.network.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun foodDataBaseProvider(@ApplicationContext context: Context): FoodDataBase{
        return Room.databaseBuilder(context,FoodDataBase::class.java,"footDB")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun itemDao(db: FoodDataBase): ItemDao = db.itemDao()

    @Provides
    @Singleton
    @ApiEndPoint
    fun apiEndPointProvider(): String = "https://api.spoonacular.com/"

    @Provides
    fun loginInterceptorProvider(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    fun okkHttpClientProvider(
        loginInterceptor: HttpLoggingInterceptor,
        queryInterceptor: QueryInterceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(loginInterceptor)
        .addInterceptor(queryInterceptor)
        .build()

    @Provides
    fun restAdapterProvider(@ApiEndPoint apiEndPoint: String, okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(apiEndPoint)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    @Provides
    fun applesServiceProvider(restAdapter: Retrofit): ApplesService = restAdapter.create()
    @Provides
    fun burgersServiceProvider(restAdapter: Retrofit): BurgersService = restAdapter.create()
    @Provides
    fun pizzasServiceProvider(restAdapter: Retrofit): PizzasService = restAdapter.create()
    @Provides
    fun sushisServiceProvider(restAdapter: Retrofit): SushisService = restAdapter.create()
}

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class ApiEndPoint
