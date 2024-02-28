package com.example.ramadancalendar.view_model

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationListener
import android.location.LocationManager
import androidx.core.app.ActivityCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ramadancalendar.model.Location

class HomeViewModel(private val context: Context) {

    private val _currentLocation = MutableLiveData<Location>()
    val currentLocation: LiveData<Location> = _currentLocation

    private val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

    fun fetchLocation() {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(context as Activity, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)
            return
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0L, 0f, locationListener)
    }

    private val locationListener = object : LocationListener {
        override fun onLocationChanged(location: android.location.Location) {
            _currentLocation.postValue(Location(location.latitude, location.longitude))
            locationManager.removeUpdates(this)
        }
    }
}
