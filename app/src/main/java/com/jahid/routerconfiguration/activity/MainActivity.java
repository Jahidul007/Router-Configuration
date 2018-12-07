package com.jahid.routerconfiguration.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jahid.routerconfiguration.R;
import com.jahid.routerconfiguration.adapter.MyAdapter;
import com.jahid.routerconfiguration.model.ListItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final String IPADDRESS_PATTERN =
                "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";


        recyclerView = (RecyclerView) findViewById(R.id.list_id);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        final EditText editText = (EditText) findViewById(R.id.router_address);
        Button button = (Button) findViewById(R.id.go_button);
        //   layoutManager.scrollToPositionWithOffset(position, 0);
        //   editText.setFocusableInTouchMode(true);
        //   editText.requestFocus();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String address = editText.getText().toString();
                if (address.isEmpty() || !address.matches(IPADDRESS_PATTERN)) {
                    Toast.makeText(MainActivity.this, "You have not entered valid IP Address", Toast.LENGTH_SHORT).show();
                    editText.setText("");
                } else {
                    Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                    intent.putExtra("address", address);
                    startActivity(intent);
                    editText.setText("");
                }
            }
        });

        listItems = new ArrayList<>();

        ListItem item1 = new ListItem("Toto Link", "192.168.0.1");
        ListItem item2 = new ListItem("Natis Link", "123.121.121.3");
        ListItem item3 = new ListItem("Xiaomi Link", "123.121.121.4");
        ListItem item4 = new ListItem("Xiaomi Link", "123.121.121.4");
        ListItem item5 = new ListItem("Xiaomi Link", "123.121.121.4");
        ListItem item6 = new ListItem("Xiaomi Link", "123.121.121.4");
        ListItem item7 = new ListItem("Xiaomi Link", "123.121.121.4");
        ListItem item8 = new ListItem("Xiaomi Link", "123.121.121.4");
        ListItem item9 = new ListItem("Xiaomi Link", "123.121.121.4");
        ListItem item10 = new ListItem("Xiaomi Link", "123.121.121.4");
        ListItem item11 = new ListItem("Xiaomi Link", "123.121.121.4");
        ListItem item12 = new ListItem("Tp Link", "www.google.com");

        listItems.add(item1);
        listItems.add(item2);
        listItems.add(item3);
        listItems.add(item3);
        listItems.add(item4);
        listItems.add(item5);
        listItems.add(item6);
        listItems.add(item7);
        listItems.add(item8);
        listItems.add(item9);
        listItems.add(item10);
        listItems.add(item11);
        listItems.add(item12);

      /*String routerName[] = {"Tp Link", "Toto"};
        String routerAddress[] = {"147.121.122.12", "141.123.11.11"};
        for (int i = 0; i < 10; i++) {

            ListItem item = new ListItem(
                    "Item" + (i + 1),
                    "Description"
            );


            listItems.add(item);
        }*/


        adapter = new MyAdapter(this, listItems);
        recyclerView.setAdapter(adapter);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
