package com.example.selectimage


import android.view.LayoutInflater
import com.example.selectimage.databinding.ActivitySelectBinding

class SelectActivity : BaseActivity<ActivitySelectBinding>() {

    private lateinit var adapter: ImageAdapter
    private var images = arrayListOf<Model>()
    override fun inflateViewBinding(inflater: LayoutInflater): ActivitySelectBinding {
        return ActivitySelectBinding.inflate(layoutInflater)
    }

    override fun initView() {
        images = intent.getSerializableExtra("key") as ArrayList<Model>
        adapter = ImageAdapter(images, this::clickListener)
        binding.selectedRecycler.adapter = adapter
    }

    private fun clickListener(imgModel: Model) {
    }

    override fun imageSend() {
    }

    override fun loadImage() {
    }
}