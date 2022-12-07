package de.dimitrikrylasov.wavejet.data.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import de.dimitrikrylasov.wavejet.data.model.Events
import org.checkerframework.common.reflection.qual.GetClass
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET

const val BASE_URL = "https://public.syntax-institut.de/apps/batch3/Dimitri/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ApiService{
    @GET("data.json")
    suspend fun getAllEvents(): List<Events>
}
object EventApi {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}