package com.guild.user.mobileapplications;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class guildTaskList extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String taskName;
    String taskDescription;
    String taskCurrency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guild_task_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        LinearLayout taskLayout = (LinearLayout) findViewById(R.id.layout_tasks);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void openAddTask(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(guildTaskList.this);
        builder.setTitle("Add Task");
        builder.setMessage("To add a task fill in the fields below, then click 'Yes'.");
        builder.setIcon(R.drawable.ic_menu_slideshow);
        LinearLayout taskLayout2 = new LinearLayout(guildTaskList.this); //Creates a "Container" to store each input box in.
        taskLayout2.setOrientation(LinearLayout.VERTICAL);

        final EditText input = new EditText(guildTaskList.this);        //Creates an input field.
        input.setHint("Task Name...");                                          //Sets the ghost text.
        taskLayout2.addView(input);                                              //Displays the input field by adding it to the layout.

        final EditText input2 = new EditText(guildTaskList.this);
        input2.setHint("Task Description...");
        taskLayout2.addView(input2);

        final EditText input3 = new EditText(guildTaskList.this);   //Integer (Currency)
        input3.setHint("How much will this task be worth?...");
        taskLayout2.addView(input3);

        final ImageView input4 = new ImageView(guildTaskList.this);
        taskLayout2.addView(input4);

        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                taskName = input.getText().toString();  //Store the variables in local to be used to create the actual tasks.
                taskDescription = input2.getText().toString();
                taskCurrency = input3.getText().toString();
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

    public void addTask() {
        //Put code here to add the task to the taskList screen using the variables from before.
        LinearLayout taskLayout = (LinearLayout) findViewById(R.id.layout_tasks);

        final ImageView img = new ImageView(guildTaskList.this);
        img.setImageResource(R.drawable.gui_box);
        img.setScaleX(1.f);
        img.setScaleY(1.f);
        taskLayout.addView(img);

        TextView currentTaskName = new TextView(guildTaskList.this); //Creates an input field.
        currentTaskName.setHint("Task Name...");
        currentTaskName.setText("Name: " + taskName);
        currentTaskName.setX(img.getX() + 250);
        currentTaskName.setY(img.getY() - 700);
        taskLayout.addView(currentTaskName);

        TextView currentTaskDesc = new TextView(guildTaskList.this); //Creates an input field.
        currentTaskDesc.setHint("Task Description...");
        currentTaskDesc.setText("Description: " + taskDescription);
        currentTaskDesc.setX(currentTaskName.getX());
        currentTaskDesc.setY(currentTaskName.getY() + 50);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(650, 250);
        currentTaskDesc.setLayoutParams(p);
        taskLayout.addView(currentTaskDesc);

        TextView currentTaskCost = new TextView(guildTaskList.this); //Creates an input field.
        currentTaskCost.setHint("Task Cost...");
        currentTaskCost.setText("Cost: " + taskCurrency);
        currentTaskCost.setX(currentTaskDesc.getX());
        currentTaskCost.setY(currentTaskDesc.getY() + 50);
        taskLayout.addView(currentTaskCost);
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
        getMenuInflater().inflate(R.menu.guild_task_list, menu);
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
