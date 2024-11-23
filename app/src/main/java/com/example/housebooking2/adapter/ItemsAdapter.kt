package com.example.housebooking2.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.housebooking2.activity.DetailActivity
import com.example.housebooking2.databinding.ViewholderItemBinding
import com.example.housebooking2.model.ItemDomain

class ItemsAdapter(private val items: ArrayList<ItemDomain>) :
    RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {
    private lateinit var context: Context
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding =
            ViewholderItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        with(holder.binding) {
            name.text = item.title
            price.text = "$${item.price}"
            bed.text = item.bed.toString()
            bath.text = item.bath.toString()
//            pic.setImageResource(context.resources.getIdentifier(item.pickPath, "drawable", context.packageName))
            val drawableResourceId = holder.itemView.resources.getIdentifier(
                item.pickPath, "drawable", holder.itemView.context.packageName
            )

            Glide.with(context).load(drawableResourceId).into(pic)

            holder.itemView.setOnClickListener {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("property", item)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(val binding: ViewholderItemBinding) : RecyclerView.ViewHolder(binding.root)
}