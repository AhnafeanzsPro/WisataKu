package com.example.wisataku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import com.example.wisataku.data.Wisataku
import com.example.wisataku.databinding.ActivityDetailBinding
import com.example.wisataku.home.MainActivity

class DetailActivity : AppCompatActivity(), View.OnClickListener {

    private var _binding: ActivityDetailBinding? = null
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnBack: ImageButton = findViewById(R.id.btn_back_detail)
        btnBack.setOnClickListener(this)


        val wisataku = intent.getParcelableExtra<Wisataku>(WISATAKU_DATA)

        val photoData = intent.getIntExtra(EXTRA_IMG, 0)
        val titleData = intent.getStringExtra(EXTRA_TITLE)
        val detailData = intent.getStringExtra(EXTRA_DETAIL)
        val highlightData = intent.getStringExtra(EXTRA_HIGHLIGHT)
        val facilitiesData = intent.getStringExtra(EXTRA_FACILITIES)
        val priceData = intent.getStringExtra(EXTRA_PRICE)

        if (wisataku != null){
            binding.imgDetail.setImageResource(wisataku.photo!!)
            binding.tvDataJudul.text = wisataku.name
            binding.tvDataDetail.text = wisataku.detail
            binding.tvHighlight.text = wisataku.highlight
            binding.tvFasilitas.text = wisataku.fasilitas
            binding.tvHarga.text = wisataku.harga
        }else{
            binding.imgDetail.setImageResource(photoData)
            binding.tvDataJudul.text = titleData
            binding.tvDataDetail.text = detailData
            binding.tvHighlight.text = highlightData
            binding.tvFasilitas.text = facilitiesData
            binding.tvHarga.text = priceData

        }
    }

    companion object{
        const val WISATAKU_DATA = "wisataku"
        const val EXTRA_IMG = "image"
        const val EXTRA_TITLE = "title"
        const val EXTRA_DETAIL = "detail"
        const val EXTRA_HIGHLIGHT = "highlight"
        const val EXTRA_FACILITIES = "facilities"
        const val EXTRA_PRICE = "price"
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btn_back_detail -> {
                val moveIntent = Intent(this@DetailActivity, MainActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}