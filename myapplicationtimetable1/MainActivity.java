package com.example.myapplicationtimetable1;

import android.os.Bundle;

//import com.example.myapplicationtimetable1.ui.log.Update;
import com.example.myapplicationtimetable1.ui.log.Par;
import com.example.myapplicationtimetable1.ui.log.Update;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplicationtimetable1.databinding.ActivityMainBinding;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////Код ///////////
////////////////////////////////////////////////////////////////////////////////////

        System.out.println("Старт");
        //Update.deleteOld();

        Update.getWebsite();
        //System.out.println("ИКБО-27-20\t");
        Par p = new Par();
        String s= "ИКБО-27-20";

//        try {
//            System.out.println("try ");
//            System.out.println(p.find(s));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////        ///////////
////////////////////////////////////////////////////////////////////////////////////
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

}