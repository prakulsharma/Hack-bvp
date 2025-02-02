package com.developer.jatin.hack_bvp;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import static com.developer.jatin.hack_bvp.R.id.center;
import static com.developer.jatin.hack_bvp.R.id.toolbar;

public class MainScreen extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
Toolbar toolbar;

private String url, url2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        
        url = "https://addy1234.github.io/hack-bvp/apply.html";
        url2 = "https://github.com/addy1234/hack-bvp";
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            toolbar.setTitle("Home");
            toolbar.setBackgroundColor(Color.parseColor("#ff420e"));
            Talks talks=new Talks();
            android.app.FragmentManager fragmentManager=getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.app_bar,talks,talks.getTag()).commit();

            // Handle the camea action
        }
        else if (id == R.id.form) {
            toolbar.setTitle("Form");
            toolbar.setBackgroundColor(Color.parseColor("#ff420e"));
            final CustomTabsIntent intent=new CustomTabsIntent.Builder().build();
            intent.launchUrl(MainScreen.this, Uri.parse(url));

        }
        else if (id == R.id.about_us) {
            toolbar.setTitle("About Us");
            toolbar.setBackgroundColor(Color.parseColor("#0084a8"));
            final CustomTabsIntent intent=new CustomTabsIntent.Builder().build();
            intent.launchUrl(MainScreen.this, Uri.parse(url2));

        } else if (id == R.id.up_coming_talks) {
            toolbar.setTitle("Upcoming Talks");
            toolbar.setBackgroundColor(Color.parseColor("#ff420e"));
            UpcompingTalks talks=new UpcompingTalks();
            android.app.FragmentManager fragmentManager=getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.app_bar,talks,talks.getTag()).commit();

        } else if (id == R.id.nav_share) {
            toolbar.setTitle("share");
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "share with friends");
            sendIntent.setType("text/plain");
            startActivity(Intent.createChooser(sendIntent, "share"));
            toolbar.setBackgroundColor(Color.parseColor("#ff420e"));

        }else if (id == R.id.location) {
            toolbar.setTitle("Location");
            Intent i = new Intent();
            i.setClass(MainScreen.this,MapsActivity.class);
            startActivity(i);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
