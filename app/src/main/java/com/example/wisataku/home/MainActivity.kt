package com.example.wisataku.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wisataku.AboutActivity
import com.example.wisataku.R
import com.example.wisataku.adapter.WisatakuAdapter
import com.example.wisataku.data.DataWisataku
import com.example.wisataku.data.Wisataku
import com.example.wisataku.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var rvList: RecyclerView
    private val list: ArrayList<Wisataku> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnAboutActivity: ImageView = findViewById(R.id.btn_about)
        btnAboutActivity.setOnClickListener(this)

        rvList = findViewById(R.id.rv_list)
        rvList.setHasFixedSize(true)

        list.addAll(DataWisataku.listWisataku)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvList.layoutManager = LinearLayoutManager(this)
        val listWisatakuAdapter = WisatakuAdapter(list)
        rvList.adapter = listWisatakuAdapter
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btn_about -> {
                val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }
}