package com.example.menufy.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.widget.CompoundButton;
import android.widget.Switch;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.menufy.Fragments.AlertsFragment;
import com.example.menufy.Fragments.EmailFragment;
import com.example.menufy.Fragments.InfoFragment;
import com.example.menufy.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements  CompoundButton.OnCheckedChangeListener{


    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Switch aSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolbar();
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView=(NavigationView)findViewById(R.id.navview);

        setFragmentByDefault();



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                boolean fragmentTransaction = false;
                Fragment fragment = null;

                switch (item.getItemId()){
                    case R.id.menu_mail:
                        fragment = new EmailFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_alert:
                        fragment = new AlertsFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_info:
                        fragment = new InfoFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_opcion_1:

                        break;
                }

                if (fragmentTransaction){
                    changeFragment(fragment, item);
                    drawerLayout.closeDrawers();
                }

                return true;
            }
        });

        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
            }
            @Override
            public void onDrawerOpened(View drawerView) {
                Toast.makeText(MainActivity.this, "Abierto", Toast.LENGTH_SHORT).show();
             }
             @Override
            public void onDrawerClosed(View drawerView) {
                Toast.makeText(MainActivity.this, "Cerrado", Toast.LENGTH_SHORT).show();
             }
             @Override
            public void onDrawerStateChanged(int newState) {

            }
        });


        //aSwitch = (Switch) navigationView.getMenu().findItem(R.id.switchOption).getActionView();
        //aSwitch.setOnCheckedChangeListener(this);

    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_burguer);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setFragmentByDefault() {
        changeFragment(new EmailFragment(), navigationView.getMenu().getItem(0));
    }


    private void changeFragment(Fragment fragment, MenuItem item) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();
        item.setChecked(true);
        getSupportActionBar().setTitle(item.getTitle());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
              // abrir el menu lateral
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
        }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked)
            Toast.makeText(MainActivity.this, "The option is checked", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this, "The option is unchecked", Toast.LENGTH_SHORT).show();
    }
}