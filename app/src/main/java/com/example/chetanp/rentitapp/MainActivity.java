package com.example.chetanp.rentitapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.chetanp.rentitapp.Fragment.AddToCart_frag;
import com.example.chetanp.rentitapp.Fragment.AboutUs_frag;
import com.example.chetanp.rentitapp.Fragment.FavouriteAddsFragment;
import com.example.chetanp.rentitapp.Fragment.HomeMain_frag;
import com.example.chetanp.rentitapp.Fragment.InvoiceFragment;
import com.example.chetanp.rentitapp.Fragment.MyAddsFragment;
import com.example.chetanp.rentitapp.Fragment.MyBookings;
import com.example.chetanp.rentitapp.Fragment.MyRented;
import com.example.chetanp.rentitapp.Fragment.PostAddFragment;
import com.example.chetanp.rentitapp.Fragment.ProfileFragment;
import com.example.chetanp.rentitapp.Fragment.SettingFragment;
import com.example.chetanp.rentitapp.Fragment.Help_frag;
import com.example.chetanp.rentitapp.Fragment.Notification_frag;
import com.example.chetanp.rentitapp.Fragment.TermsAndConditions_frag;
import com.example.chetanp.rentitapp.UserInterface.LoginActivity;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private  Toolbar toolbar;
    BasicComponentsReuse basicComponentsReuse_obj=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar work
        toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        basicComponentsReuse_obj=new BasicComponentsReuse();
        //home fragment replace work
        onNavigationItemCode_method(new HomeMain_frag(),"RentIt");
        //Drawer Layout work
        DrawerLayout drawer =findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        //Navigation Items work
        NavigationView navigationView =findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }//end of onCreate method

    @Override
    public void onBackPressed() {
        DrawerLayout drawer =findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
            drawer.closeDrawer(GravityCompat.START);
         else
             super.onBackPressed();
    }//end of onBackPressed method

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mainoptionmenu, menu);
        return true;
    }//end of onCreate Options Menu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_notification:
                onNavigationItemCode_method(new Notification_frag(),"Notifications");
                break;
            case R.id.action_addCart:
                onNavigationItemCode_method(new AddToCart_frag(),"Add to Cart");
                break;
            case R.id.action_about_us:
                onNavigationItemCode_method(new AboutUs_frag(),"About us");
                break;
            case R.id.action_terms_conditions:
                onNavigationItemCode_method(new TermsAndConditions_frag(),"Terms and Condition");
                break;
            case R.id.action_help:
                onNavigationItemCode_method(new Help_frag(),"Help");
                break;
            case R.id.action_login:
                Intent login_intent=new Intent(MainActivity.this, LoginActivity.class);
                basicComponentsReuse_obj.intentmoveAnimateCode_method(MainActivity.this,login_intent);
                break;
        }//end of switch case
        return super.onOptionsItemSelected(item);
    }//end of onOptinsItemSelected method

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // click navigation view item work.
        switch (item.getItemId()){
            case R.id.nav_home:
                onNavigationItemCode_method(new HomeMain_frag(),"RentIt");
                break;
            case R.id.nav_profile:
                onNavigationItemCode_method(new ProfileFragment(),"User Profile");
                break;
            case R.id.nav_post_a_add:
                onNavigationItemCode_method(new PostAddFragment(),"Post Add");
                break;
            case R.id.nav_my_adds:
                onNavigationItemCode_method(new MyAddsFragment(),"My Adds");
                break;
            case R.id.nav_my_rented:
                onNavigationItemCode_method(new MyRented(),"My Rented");
                break;
            case R.id.nav_my_bookings:
                onNavigationItemCode_method(new MyBookings(),"My Bookings");
                break;
            case R.id.nav_favourite_adds:
                onNavigationItemCode_method(new FavouriteAddsFragment(),"Favourite Adds");
                break;
            case R.id.nav_invoice:
                onNavigationItemCode_method(new InvoiceFragment(),"Invoice");
                break;
            case R.id.nav_setting:
                onNavigationItemCode_method(new SettingFragment(),"Setting");
                break;
            case R.id.nav_rate_us:
                rateUs_method();
                break;
            case R.id.nav_logout:
                logout_method();
                break;
        }//end of switch case

        //drawer layout close with new Item selected and open.
        DrawerLayout drawer =findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }//end of onNavigationItem Selected method

    public void onNavigationItemCode_method(android.support.v4.app.Fragment fragment, String rentIt){
        getSupportFragmentManager().beginTransaction().add(R.id.main_frame,fragment).commitAllowingStateLoss();
        toolbar.setTitle(rentIt);
    }//end of onNavigation Item code method

    private void rateUs_method() {

    }//end of rateUs method

    private void logout_method() {
        //show dilog box before logout work
    }//end of logout method


}//end of mainoptionmenu class