package com.example.android_final;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import com.bhaptics.bhapticsmanger.BhapticsModule;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.android_final.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final int BLUETOOTH_PERMISSION_CODE = 112;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_afficher, R.id.navigation_ajouter, R.id.navigation_appareil, R.id.navigation_compte)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);


        connexion_bhaptic();


    }


    public void connexion_bhaptic() {

        BluetoothAdapter BA;
        BA = BluetoothAdapter.getDefaultAdapter();

        Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        startActivityForResult(turnOn, 0);


      //  checkPermission(Manifest.permission.BLUETOOTH, BLUETOOTH_PERMISSION_CODE);

        BhapticsModule.initialize(getApplicationContext());

    }

/*    public void checkPermission(String permission, int requestCode){

        if (ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_DENIED)
        {
            ActivityCompat.requestPermissions(this, new String []{permission}, requestCode);
        }
        else
        {
            Toast.makeText(this, "Permission Accordee", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==BLUETOOTH_PERMISSION_CODE){
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Bluetooth ok", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "Bluetooth non ok", Toast.LENGTH_LONG).show();

            }
        }
    }


*/
}