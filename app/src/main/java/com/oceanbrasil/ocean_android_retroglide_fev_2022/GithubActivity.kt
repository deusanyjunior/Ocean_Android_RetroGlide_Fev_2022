package com.oceanbrasil.ocean_android_retroglide_fev_2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GithubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github)

        val nomeDoPrimeiroRepositorio = findViewById<TextView>(R.id.nomeDoRepositorio)
        val donoDoRepositorio = findViewById<TextView>(R.id.donoDoRepositorio)
        val avatar = findViewById<View>(R.id.avatar) as ImageView

        // Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(GitHubService::class.java)

        val repos: Call<List<Repo?>?>? =
            service.listarRepositorios("paulosalvatore")

        repos?.enqueue(
            object : Callback<List<Repo?>?> {

                override fun onResponse(
                    call: Call<List<Repo?>?>,
                    response: Response<List<Repo?>?>
                ) {
                    val body = response.body()

                    body?.get(0).let {
                        nomeDoPrimeiroRepositorio.setText(it?.name)
                        donoDoRepositorio.setText(it?.owner?.login)
                        // Glide
                        Glide
                            .with(this@GithubActivity)
                            .load(it?.owner?.avatar_url)
                            .into(avatar)
                    }
                }

                override fun onFailure(call: Call<List<Repo?>?>, t: Throwable) {
                    nomeDoPrimeiroRepositorio.setText("Ocorreu algum erro!")
                }

            }
        )
    }
}