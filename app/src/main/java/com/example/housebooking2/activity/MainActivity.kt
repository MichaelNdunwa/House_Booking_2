package com.example.housebooking2.activity

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.housebooking2.R
import com.example.housebooking2.adapter.ItemsAdapter
import com.example.housebooking2.databinding.ActivityMainBinding
import com.example.housebooking2.model.ItemDomain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        binding.navigationBar.setItemSelected(R.id.home)
        initList()
    }

    private fun initList() {
        val items = arrayListOf(
            ItemDomain(
                "Apartment",
                "Royal Apartment",
                "LostAngles LA",
                "item_1",
                1500,
                2,
                3,
                350,
                true,
                4.5,
                "This 2 bed / 1 bath home boasts an enormous, open-living, accented by striking architectural features and high-end finishes. Feel inspired by open sight lines that embrace the outdoors, crowned by stunning coffered ceilings."
            ),
            ItemDomain(
                "Apartment",
                "Royal Apartment",
                "LostAngles LA",
                "item_2",
                1500,
                2,
                3,
                350,
                false,
                4.5,
                "This 2 bed / 1 bath home boasts an enormous, open-living, accented by striking architectural features and high-end finishes. Feel inspired by open sight lines that embrace the outdoors, crowned by stunning coffered ceilings."
            ),
            ItemDomain(
                "Apartment",
                "Royal Apartment",
                "LostAngles LA",
                "item_3",
                1500,
                2,
                3,
                350,
                true,
                4.5,
                "This 2 bed / 1 bath home boasts an enormous, open-living, accented by striking architectural features and high-end finishes. Feel inspired by open sight lines that embrace the outdoors, crowned by stunning coffered ceilings."
            ),
            ItemDomain(
                "Apartment",
                "Royal Apartment",
                "LostAngles LA",
                "item_4",
                1500,
                2,
                3,
                350,
                true,
                4.5,
                "This 2 bed / 1 bath home boasts an enormous, open-living, accented by striking architectural features and high-end finishes. Feel inspired by open sight lines that embrace the outdoors, crowned by stunning coffered ceilings."
            )
        )
        val adapter = ItemsAdapter(items)
        binding.recommendedView.adapter = adapter
        binding.recommendedView.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)

    }
}