package com.example.bloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

        //import com.example.bottomnavigationdemo.databinding.ActivityMainBinding;
public class drawer extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener {
            private DrawerLayout drawerLayout;
            private FloatingActionButton fab;
            private BottomNavigationView BottomNavigationView;
            FragmentManager fragmentManager ;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_drawer);
                BottomNavigationView = findViewById(R.id.bottomNavigationView);
                fab = findViewById(R.id.fab);
                drawerLayout = findViewById(R.id.drawer_layout);
                NavigationView navigationView = findViewById(R.id.nav_view);
                navigationView.setNavigationItemSelectedListener(this);
                Toolbar toolbar = findViewById(R.id.toolbar); //Ignore red line errors
                setSupportActionBar(toolbar);
                ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav,
                        R.string.close_nav);
                drawerLayout.addDrawerListener(toggle);
                toggle.syncState();
                if (savedInstanceState == null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                    navigationView.setCheckedItem(R.id.nav_home);
                }

                BottomNavigationView.setBackground(null);
                BottomNavigationView.setOnItemSelectedListener(item -> {
                    int itemId = item.getItemId();

                    if (itemId == R.id.home) {
                        replaceFragment(new FragmentHome());
                    } else if (itemId == R.id.shorts) {
                        replaceFragment(new ShortsFragment());
                    } else if (itemId == R.id.subscriptions) {
                        replaceFragment(new SubFragment());
                    } else if (itemId == R.id.library) {
                        replaceFragment(new LibraryFragment());
                    }

                    return false;
                });

                fragmentManager = getSupportFragmentManager();
                replaceFragment(new FragmentHome());
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_SEND);
                        intent.putExtra(Intent.EXTRA_TEXT,"hello developpers");
                        intent.setType("text/plain");

                        if(intent.resolveActivity(getPackageManager()) !=null){
                            startActivity(intent);
                        }
                    }
                });


            }

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.nav_home) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                } else if (item.getItemId() == R.id.nav_settings) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsFragment()).commit();
                } else if (item.getItemId() == R.id.nav_share) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ShareFragment()).commit();
                } else if (item.getItemId() == R.id.nav_about) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutFragment()).commit();
                } else if (item.getItemId() == R.id.nav_logout) {
                    TextView x = findViewById(R.id.nav_logout);
                    x.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent(getApplicationContext(), LoginTabFragment.class);
                            startActivity(i);
                        }
                    });
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }

            @Override
            public void onBackPressed() {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    super.onBackPressed();
                }
            }



            private void replaceFragment(Fragment fragment) {

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
/*
            private void showBottomDialog() {

                final Dialog dialog = new Dialog(this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.bottomsheetlayout);

                LinearLayout videoLayout = dialog.findViewById(R.id.layoutVideo);
                LinearLayout shortsLayout = dialog.findViewById(R.id.layoutShorts);
                LinearLayout liveLayout = dialog.findViewById(R.id.layoutLive);
                ImageView cancelButton = dialog.findViewById(R.id.cancelButton);

                videoLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dialog.dismiss();
                        Toast.makeText(drawer.this, "Upload a Video is clicked", Toast.LENGTH_SHORT).show();

                    }
                });

                shortsLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dialog.dismiss();
                        Toast.makeText(drawer.this, "Create a short is Clicked", Toast.LENGTH_SHORT).show();

                    }
                });

                liveLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dialog.dismiss();
                        Toast.makeText(drawer.this, "Go live is Clicked", Toast.LENGTH_SHORT).show();

                    }
                });

                cancelButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                dialog.getWindow().setGravity(Gravity.BOTTOM);

            }

*/
        }