package com.example.selectimage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.selectimage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val list = arrayListOf<Model>()

    private val listSelect = arrayListOf<Model>()

    private lateinit var adapter: ImageAdapter

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadImage()
        initAdapter()
        imageSend()    }


    private fun loadImage() {
        list.add(Model(R.drawable.ic_cat, true))
        list.add(Model(R.drawable.ic_elephant, true))
        list.add(Model(R.drawable.ic_fish, true))
        list.add(Model(R.drawable.ic_fox, true))
        list.add(Model(R.drawable.ic_horses, true))
        list.add(Model(R.drawable.ic_ireland, true))
        list.add(Model(R.drawable.ic_kingfisher, true))
        list.add(Model(R.drawable.ic_owl, true))
        list.add(Model(R.drawable.ic_parrots, true))
        list.add(Model(R.drawable.ic_penguins, true))
        list.add(Model(R.drawable.ic_pile, true))
        list.add(Model(R.drawable.ic_sea, true))
        list.add(Model(R.drawable.ic_zebras, true))

    }

    private fun initAdapter() {
        adapter = ImageAdapter(list,this::clickListener)
        binding.recyclerview.adapter = adapter
    }

    private fun clickListener(imageModel: Model) {
        imageModel.select = !imageModel.select
        if (imageModel.select) {
            listSelect.add(imageModel)
        } else {
            listSelect.remove(imageModel)
        }

    }

    private fun imageSend() {
        binding.btnSend.setOnClickListener {
            val intent = Intent(this, SelectActivity::class.java)
            intent.putExtra("key", listSelect)
            startActivity(intent)
        }

    }

}