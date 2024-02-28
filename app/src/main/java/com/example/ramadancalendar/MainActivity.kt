package com.example.ramadancalendar

import android.content.pm.PackageManager
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.ramadancalendar.databinding.ActivityMainBinding
import com.example.ramadancalendar.model.Location
import com.example.ramadancalendar.view_model.HomeViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        init()
    }

    private fun init() {
        homeViewModel = HomeViewModel(this)
        homeViewModel.fetchLocation()
        initObservers()
    }

    private fun initObservers() {
        homeViewModel.currentLocation.observe(this) { locationData ->
            binding.txtView1.text = if (locationData != null) {
                String.format(
                    "Latitude: %.2f, Longitude: %.2f",
                    locationData.latitude,
                    locationData.longitude
                )
            } else {
                "No location found!"
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                homeViewModel.fetchLocation()
            }
        }
    }
}
