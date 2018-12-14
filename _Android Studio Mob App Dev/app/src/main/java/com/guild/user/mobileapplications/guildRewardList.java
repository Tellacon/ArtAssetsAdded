package com.guild.user.mobileapplications;

import android.content.DialogInterface;
import android.content.Intent;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class guildRewardList extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String rewardName;
    String rewardDescription;
    String rewardCurrency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guild_reward_list);
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

    public void openAddTask(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(guildRewardList.this);
        builder.setTitle("Add Reward");
        builder.setMessage("To add a reward fill in the fields below, then click 'Yes'.");
        builder.setIcon(R.drawable.ic_menu_slideshow);
        LinearLayout taskLayout2 = new LinearLayout(guildRewardList.this); //Creates a "Container" to store each input box in.
        taskLayout2.setOrientation(LinearLayout.VERTICAL);

        final EditText input = new EditText(guildRewardList.this);        //Creates an input field.
        input.setHint("Reward Name...");                                          //Sets the ghost text.
        taskLayout2.addView(input);                                              //Displays the input field by adding it to the layout.

        final EditText input2 = new EditText(guildRewardList.this);
        input2.setHint("Reward Description...");
        taskLayout2.addView(input2);

        final EditText input3 = new EditText(guildRewardList.this);   //Integer (Currency)
        input3.setHint("How much will this reward cost?...");
        taskLayout2.addView(input3);

        final ImageView input4 = new ImageView(guildRewardList.this);
        taskLayout2.addView(input4);

        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                rewardName = input.getText().toString();  //Store the variables in local to be used to create the actual tasks.
                rewardDescription = input2.getText().toString();
                rewardCurrency = input3.getText().toString();
                dialog.dismiss();
                addTask();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });

        builder.setView(taskLayout2);                    //Add the LinearLayout with all the fields stored to the view so we can actually see it.

        AlertDialog alert = builder.create();
        alert.show();
    }

    public void openEditTask(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(guildRewardList.this);
        builder.setTitle("Add Reward");
        builder.setMessage("To add a reward fill in the fields below, then click 'Yes'.");
        builder.setIcon(R.drawable.ic_menu_slideshow);
        LinearLayout taskLayout2 = new LinearLayout(guildRewardList.this); //Creates a "Container" to store each input box in.
        taskLayout2.setOrientation(LinearLayout.VERTICAL);

        final EditText input = new EditText(guildRewardList.this);        //Creates an input field.
        input.setHint("Reward Name...");                                          //Sets the ghost text.
        taskLayout2.addView(input);                                              //Displays the input field by adding it to the layout.

        final EditText input2 = new EditText(guildRewardList.this);
        input2.setHint("Reward Description...");
        taskLayout2.addView(input2);

        final EditText input3 = new EditText(guildRewardList.this);   //Integer (Currency)
        input3.setHint("How much will this reward cost?...");
        taskLayout2.addView(input3);

        final ImageView input4 = new ImageView(guildRewardList.this);
        taskLayout2.addView(input4);

        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                rewardName = input.getText().toString();  //Store the variables in local to be used to create the actual tasks.
                rewardDescription = input2.getText().toString();
                rewardCurrency = input3.getText().toString();
                dialog.dismiss();
                //addTask();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });

        builder.setView(taskLayout2);                    //Add the LinearLayout with all the fields stored to the view so we can actually see it.

        AlertDialog alert = builder.create();
        alert.show();
    }

    public void addTask() {
        //Put code here to add the task to the taskList screen using the variables from before.
        final LinearLayout taskLayout = (LinearLayout) findViewById(R.id.layout_tasks);

        final ImageView img = new ImageView(guildRewardList.this);
        img.setImageResource(R.drawable.gui_box);
        img.setScaleX(1.f);
        img.setScaleY(1.f);
        taskLayout.addView(img);

        final TextView currentTaskName = new TextView(guildRewardList.this); //Creates a text field.
        currentTaskName.setText("Name: " + rewardName);
        currentTaskName.setX(img.getX() + 250);
        currentTaskName.setY(img.getY() - 700);
        taskLayout.addView(currentTaskName);

        final TextView  currentTaskDesc = new TextView(guildRewardList.this); //Creates a text field.
        currentTaskDesc.setText("Description: " + rewardDescription);
        currentTaskDesc.setX(currentTaskName.getX());
        currentTaskDesc.setY(currentTaskName.getY() + 50);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(650, 250);
        currentTaskDesc.setLayoutParams(p);
        taskLayout.addView(currentTaskDesc);

        final TextView currentTaskCost = new TextView(guildRewardList.this); //Creates a text field.
        currentTaskCost.setText("Cost: " + rewardCurrency);
        currentTaskCost.setX(currentTaskDesc.getX());
        currentTaskCost.setY(currentTaskDesc.getY() + 50);
        taskLayout.addView(currentTaskCost);

        final Button currentTaskButton = new Button(guildRewardList.this); //Creates a text field.
        currentTaskButton.setText("Remove Reward");
        currentTaskButton.setX(currentTaskCost.getX() - 250);
        currentTaskButton.setY(currentTaskCost.getY());
        currentTaskButton.setWidth(85);
        currentTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RemoveTask(taskLayout, currentTaskName, currentTaskDesc, currentTaskCost, currentTaskButton, img);
            }
        });
        taskLayout.addView(currentTaskButton);

        /*final Button currentTaskEditButton = new Button(guildRewardList.this); //Creates a text field.
        currentTaskEditButton.setText("Edit Reward");
        currentTaskEditButton.setX(currentTaskButton.getX());
        currentTaskEditButton.setY(currentTaskButton.getY());
        currentTaskEditButton.setWidth(64);
        currentTaskEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEditTask(v);
            }
        });
        taskLayout.addView(currentTaskEditButton);*/
    }

   /* public void EditTask(TextView name, TextView desc, TextView cost)
    {
        currentTaskCost = name;
    }*/

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void RemoveTask(LinearLayout lin, TextView a, TextView b, TextView c, Button d, ImageView e)
    {
        lin.removeView(a);
        lin.removeView(b);
        lin.removeView(c);
        lin.removeView(d);
        lin.removeView(e);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.guild_reward_list, menu);
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
}
