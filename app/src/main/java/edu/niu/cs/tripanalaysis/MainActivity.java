/*****************************************************************************
 CSCI 522
 Progammer:Tejaswi Mulagada
 Date Due:	05/07/2015
 Purpose:  This application is to fill caluculate and analyse the elements like gas,miles,cost based on his travel
 ******************************************************************************/
package edu.niu.cs.tripanalaysis;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    EditText totalmile,totalgallons,totalprice;
    Button menu;
    TextView avggas, avgamount;
    String ttlg,ttlm,ttlp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        avggas = (TextView)findViewById(R.id.textView16);
        avgamount = (TextView)findViewById(R.id.textView15);
        totalgallons = (EditText)findViewById(R.id.editText4);
        totalmile = (EditText)findViewById(R.id.editText5);
        totalprice = (EditText)findViewById(R.id.editText6);
        menu = (Button)findViewById(R.id.button3);

        totalgallons.setText(ttlg);

        totalmile.setText(ttlm);

        totalprice.setText(ttlp);

        //double ttlcost = getIntent().getDoubleExtra();

            menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i;
                    i = new Intent(v.getContext(), SingleFillup.class);
                    startActivity(i);

                }
            });
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
