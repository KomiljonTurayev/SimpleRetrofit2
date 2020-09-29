package com.example.simpleretrofit2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.simpleretrofit2.repository.Repository
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Picasso
        Picasso.get().load("http://i.imgur.com/DvpvklR.png")
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground)
            .into(image_view)


        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(this, { response ->
            Log.d("Response", response.body()?.myUserId.toString())
            Log.d("Response", response.body()?.id.toString())
            Log.d("Response", response.body()?.title.toString())
            Log.d("Response", response.body()?.body.toString())

            text_view.text = response.body()?.myUserId.toString()

        })
    }
}