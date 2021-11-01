package com.example.recyclerviewapisimple

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var rvNames: RecyclerView
    lateinit var nameArray: ArrayList <String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvNames = findViewById(R.id.rvNames)
        nameArray = arrayListOf()
        val apiInterface = APINames().getName()?.create(APIInterface::class.java)
        val call: Call<ArrayList<namesListItem?>> = apiInterface!!.showNames()
        call?.enqueue(object: Callback<ArrayList<namesListItem?>>{
            override fun onResponse(
                call: Call<ArrayList<namesListItem?>>,
                response: Response<ArrayList<namesListItem?>>
            ) {
                updateArrayJSON(response.body()!!)
            }

            override fun onFailure(call: Call<ArrayList<namesListItem?>>, t: Throwable) {
                Log.d("MainActivity", "${t.message}")
            }

        })
    }
    fun updateArrayJSON(body: ArrayList<namesListItem?>) {
        rvNames.adapter = RVnames(body)
        rvNames.layoutManager = LinearLayoutManager(this)
    }
}