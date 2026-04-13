package com.example.smartfilemanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.smartfilemanager.databinding.ActivityMainBinding
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupStorageChart()
        setupFileList()
        setupFab()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Smart File Manager"
    }

    private fun setupStorageChart() {
        val entries = ArrayList<PieEntry>()
        entries.add(PieEntry(40f, "Used"))
        entries.add(PieEntry(60f, "Free"))

        val dataSet = PieDataSet(entries, "Storage")
        dataSet.colors = ColorTemplate.MATERIAL_COLORS.toList()
        dataSet.valueTextSize = 12f

        val data = PieData(dataSet)
        binding.storageChart.data = data
        binding.storageChart.description.isEnabled = false
        binding.storageChart.centerText = "Storage"
        binding.storageChart.animateY(1000)
        binding.storageChart.invalidate()
    }

    private fun setupFileList() {
        // RecyclerView setup would go here
    }

    private fun setupFab() {
        binding.fab.setOnClickListener {
            // FAB action
        }
    }
}
