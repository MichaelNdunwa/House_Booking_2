package com.example.housebooking2.activity

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.housebooking2.R
import com.example.housebooking2.databinding.ActivityDetailBinding
import com.example.housebooking2.model.ItemDomain

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var property: ItemDomain

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        getBundles()
        setVariables()

    }

    private fun setVariables() {
        binding.backButton.setOnClickListener { finish() }
        val drawableResourceId = resources.getIdentifier(property.pickPath, "drawable", packageName)
        Glide.with(this@DetailActivity).load(drawableResourceId).into(binding.roomPicture)

        binding.title.text = "${property.title}, in ${property.address}"
        binding.type.text = property.type
        binding.price.text = "$${property.price}"
        binding.bed.text = "${property.bed} bedroom"
        binding.bath.text = "${property.bath} bathroom"
        binding.garage.text = if (property.isGarage) "Car Garage" else "No Car Garage"
        binding.size.text = "${property.size} m2"
        binding.description.text = property.description

    }

    private fun getBundles() {
        property = intent.getSerializableExtra("property") as ItemDomain

    }
}