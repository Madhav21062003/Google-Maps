package com.madhavsolanki.googlemaps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.madhavsolanki.googlemaps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mMap: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the Support Fragment and get notified when the map is ready to be used
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val sydney = LatLng(27.83333000, 78.16667000)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Aligarh"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.d("MenuItemClicked", "Item clicked: ${item.title}")
        return when (item.itemId) {
            R.id.normalMap -> {
                Log.d("MapType", "Normal Map selected.")
                mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
                true
            }
            R.id.hybridMap -> {
                Log.d("MapType", "Hybrid Map selected.")
                mMap.mapType = GoogleMap.MAP_TYPE_HYBRID
                true
            }
            R.id.satelliteMap -> {
                Log.d("MapType", "Satellite Map selected.")
                mMap.mapType = GoogleMap.MAP_TYPE_SATELLITE
                true
            }
            R.id.terrainMap -> {
                Log.d("MapType", "Terrain Map selected.")
                mMap.mapType = GoogleMap.MAP_TYPE_TERRAIN
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}


