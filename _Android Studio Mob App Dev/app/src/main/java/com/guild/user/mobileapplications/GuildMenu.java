package com.guild.user.mobileapplications;

import android.content.DialogInterface;
import android.os.Bundle;
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
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

public class GuildMenu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public MainActivity userProfile;
    public int guildListIndex= 0;
    //public GuildClass tempGuild;
    //public GuildClass[] guildList = new GuildClass[20];
    public String tempGuildName;
    public boolean tempFamilyMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guild_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

    public void GoToTaskActivity(View v)
    {
        Intent i = new Intent(this, guildTaskList.class);
        startActivity(i);
    }

    public void GoToRewardActivity(View v)
    {
        Intent i = new Intent(this, guildRewardList.class);
        startActivity(i);
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

        if (id == R.id.nav_manage_guilds) {
            // Handle the camera action
        } else if (id == R.id.nav_about) {
            Intent i = new Intent(this, AboutMenu.class);
            startActivity(i);
        } else if (id == R.id.nav_settings) {
            Intent i = new Intent(this, SettingsMenu.class);
            startActivity(i);
        } else if (id == R.id.nav_logout) {

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void openAddGuild(View v)
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(GuildMenu.this);
        builder.setTitle("Add Guild");
        builder.setMessage("To add a guild fill in the fields below, then click 'Add'.");
        builder.setIcon(R.drawable.ic_menu_slideshow);
        final LinearLayout guildLayout2 = new LinearLayout(GuildMenu.this); //Creates a "Container" to store each input box in.
        guildLayout2.setOrientation(LinearLayout.VERTICAL);

        final EditText input = new EditText(GuildMenu.this);        //Creates an input field.
        input.setHint("Guild Name...");                                          //Sets the ghost text.
        guildLayout2.addView(input);                                              //Displays the input field by adding it to the layout.

        final Switch input2 = new Switch(GuildMenu.this);
        input2.setHint("Family Mode...");
        guildLayout2.addView(input2);


        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //guildList[guildListIndex]= new GuildClass();
                //guildList[guildListIndex].setGuildName(input.getText().toString());
                //tempGuild.setFamilyMode(input2.isChecked());
                tempGuildName=input.getText().toString();
                tempFamilyMode=input2.isChecked();
                dialog.dismiss();
                addGuild();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });

        builder.setView(guildLayout2);                    //Add the LinearLayout with all the fields stored to the view so we can actually see it.

        AlertDialog alert = builder.create();
        alert.show();
    }
    public void addGuild() {

        //Put code here to add guilds to the Guild menu screen using the variables from before.
        LinearLayout guildLayout = (LinearLayout) findViewById(R.id.layout_guilds);

        final ImageView img = new ImageView(GuildMenu.this);
        img.setImageResource(R.drawable.gui_box);
        img.setScaleX(1.f);
        img.setScaleY(1.f);
        guildLayout.addView(img);

        TextView currentGuildName = new TextView(GuildMenu.this); //Creates an input field.
        currentGuildName.setHint("Guild Name...");
        currentGuildName.setText("Name: " + tempGuildName);//guildList[guildListIndex].getGuildName());
        currentGuildName.setX(img.getX() + 250);
        currentGuildName.setY(img.getY() - 700);
        guildLayout.addView(currentGuildName);

        TextView currentGuildFamilyMode = new TextView(GuildMenu.this); //Creates an input field.
        currentGuildFamilyMode.setHint("Family Mode...");
        currentGuildFamilyMode.setText("Family Mode: "+ tempFamilyMode);//guildList[guildListIndex].getFamilyMode());
        currentGuildFamilyMode.setX(currentGuildName.getX());
        currentGuildFamilyMode.setY(currentGuildName.getY() + 50);
        guildLayout.addView(currentGuildFamilyMode);

        //guildList[guildListIndex].setGuildID(guildListIndex);
        //guildList[guildListIndex].addUser(userProfile);
        //guildList[guildListIndex].updateFamilyMode();
        //guildListIndex++;
    }

}
