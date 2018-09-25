package com.example.sanketpatel.floatingactionbutton;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
                 FloatingActionButton fab,fab1,fab2;
                 boolean isOpen=false;
                 boolean isClose=false;
                 Animation fabopen,fabclose,fabforward,fabbackward;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);

        fabopen= AnimationUtils.loadAnimation(this,R.anim.fab_open);
        fabclose= AnimationUtils.loadAnimation(this,R.anim.fab_close);



        fabforward= AnimationUtils.loadAnimation(this,R.anim.rotoate_forward);
        fabbackward= AnimationUtils.loadAnimation(this,R.anim.rotoate_backward);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              animateFab();
            }
        });
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"FIrst fab button",Toast.LENGTH_SHORT).show();
            }
        });

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Second fab button",Toast.LENGTH_SHORT).show();

            }
        });
    }


    private void animateFab()
    {
        if(isOpen)
        {
            fab.startAnimation(fabforward);
            fab1.startAnimation(fabclose);
            fab2.startAnimation(fabclose);
            fab1.setClickable(false);
            fab2.setClickable(false);
            isOpen=false;

        }

        else{
            fab.startAnimation(fabbackward);
            fab1.startAnimation(fabopen);
            fab2.startAnimation(fabopen);
            fab1.setClickable(true);
            fab2.setClickable(true);
            isOpen=true;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
