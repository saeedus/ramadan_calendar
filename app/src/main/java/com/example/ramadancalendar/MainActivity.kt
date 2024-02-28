package com.example.ramadancalendar

import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.example.ramadancalendar.databinding.ActivityMainBinding
import com.example.ramadancalendar.model.Location
import com.example.ramadancalendar.view_model.HomeViewModel
import java.util.Locale


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

        fetchLocation()
        initObservers()
    }

    private fun initObservers() {
        homeViewModel.currentLocation.observe(this) { locationData ->

            if (locationData != null) {
                binding.tvLocation.text = getAddressFromLocation(locationData.latitude, locationData.longitude)

                binding.clRoot.background = AppCompatResources.getDrawable(this, R.color.teal_200)

                binding.progressCircular.isVisible = false
                binding.tvLocation.isVisible = true
            }
        }
    }

    private fun getAddressFromLocation(latitude: Double, longitude: Double): String? {
        val geocoder = Geocoder(this, Locale.getDefault())
        val addresses: List<Address>? = try {
            geocoder.getFromLocation(latitude, longitude, 1)
        } catch (e: Exception) {
            null
        }
        return addresses?.firstOrNull()?.getAddressLine(0)
    }


    private fun fetchLocation() {
        binding.progressCircular.isVisible = true
        binding.tvLocation.isVisible = false
        homeViewModel.fetchLocation()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                fetchLocation()
            }
        }
    }
}
