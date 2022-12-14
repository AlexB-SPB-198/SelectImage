package com.example.selectimage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.selectimage.databinding.ItemBinding

class ImageAdapter(
    private var list: ArrayList<Model>,private var clickListener:(Model)->Unit

) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {
    inner class ImageViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(image: Model) {
            binding.imageItem.setImageResource(image.image)
            itemView.setOnClickListener{
                clickListener(image)
                if (image.select){
                    binding.imageSelect.visibility = View.VISIBLE
                }else{
                    binding.imageSelect.visibility = View.INVISIBLE
                }
            }
            clickListener(image)


        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }
    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.onBind(list[position])
    }
    override fun getItemCount()=list.size



}