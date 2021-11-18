package com.example.mimapa;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mimapa.databinding.ActivityMapsBinding;

import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private Marker markerPrueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap;

            // Add a marker in Sydney and move the camera
            LatLng Cusco = new LatLng(-13.5170887, -71.9785356);
            mMap.addMarker(new MarkerOptions().position(Cusco).title("Marker in Cusco").snippet("Cusco. Ombligo del mundo"));
            //mMap.moveCamera(CameraUpdateFactory.newLatLng(Cusco));

            //agregar un recurso o icono diferente para el marcador del mapa
            LatLng ica = new LatLng(-14.338611, -75.648333);
            mMap.addMarker(new MarkerOptions().position(ica).title("ICA").snippet("Ciuadad de Ica").icon(BitmapDescriptorFactory.fromResource(R.drawable.markador)));

            //cambiar color de marcador
            LatLng puno = new LatLng(-15, -70);
            mMap.addMarker(new MarkerOptions().position(puno).title("PUNO").snippet("Ciuadad de los andes").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

            //arrastrar marcador
            LatLng arequipa = new LatLng(-16.3988667, -71.5369607);
            mMap.addMarker(new MarkerOptions().position(arequipa).draggable(true).title("AREQUIPA").snippet("Ciuadad de blanca").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

            // marcador para obteer latitud y longitud
            LatLng ayacucho = new LatLng(-14, -74);
            mMap.addMarker(new MarkerOptions().position(ayacucho).title("AYACUCHO").snippet("Ciuadad de Ayacucho").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

            //camara zoom
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ayacucho,7));
            googleMap.setOnMarkerClickListener(this);

        }
        @Override
        public boolean onMarkerClick(@NonNull Marker marker)
        {
            String lat,lng;
            lat=Double.toString(marker.getPosition().latitude);
            lng=Double.toString(marker.getPosition().longitude);

            Toast.makeText(this,lat+","+lng,Toast.LENGTH_LONG).show();
            return false;
        }

    }