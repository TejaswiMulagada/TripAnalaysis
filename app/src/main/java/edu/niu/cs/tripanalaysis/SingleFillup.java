/*****************************************************************************
 CSCI 522
 Progammer:Tejaswi Mulagada
 Date Due:	05/07/2015
 Purpose:	This is the activity to enter user single fillup details on a road trip
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
import android.widget.Switch;
import android.widget.Toast;


public class SingleFillup extends ActionBarActivity View.onClickListener {

    EditText miles,amount,gas;
    Button Save,clear,cancel;

   @Override
    protected void onCreate(Bundle savedInstanceState) {

       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_single_fillup);


       miles = (EditText) findViewById(R.id.editText2);
       amount = (EditText) findViewById(R.id.editText3);
       gas = (EditText) findViewById(R.id.editText);
       Save = (Button) findViewById(R.id.button);
       clear = (Button) findViewById(R.id.button2);
       cancel = (Button) findViewById(R.id.button3);
       Save.setOnClickListener(this);
   }
                @Override
                public void onClick(View v) {

                    String g,m,a;
                    Double b,c,d;
                    switch(v.getId())
                    {
                    case R.id.Sa:
                    {
                        if( (miles.getText().toString().equals("")) || (gas.getText().toString().equals("")) || (amount.getText().toString().equals("")))
                        {
                            Toast.makeText(getApplicationContext(),"Enter Some value in fields",Toast.LENGTH_LONG).show();
                        }
                        else if ((miles.getText().toString().equals("0")) || (gas.getText().toString().equals("0")) || (amount.getText().toString().equals("0")))
                        {
                            Toast.makeText(getApplicationContext(),"Enter some value except 0 in fields",Toast.LENGTH_LONG).show();
                        }
                        else
                        {

                            String ttlg = getIntent().getExtras().getString("g");
                            String ttlm = getIntent().getExtras().getString("m");
                            String ttlp = getIntent().getExtras().getString("p");
                            double dg = Double.parseDouble(ttlg);
                            double dm = Double.parseDouble(ttlm);
                            double da = Double.parseDouble(ttlp);
                            double sg = Double.parseDouble(gas.getText().toString());
                            double sa = Double.parseDouble(amount.getText().toString());
                            double sm = Double.parseDouble(miles.getText().toString());
                            double finalcost = (sg)*(sa);
                            b = ((dg) + (sg));
                            c = ((dm) + (sm));
                            d = ((da) + (sa));
                            Intent returnmenu = new Intent();
                            returnmenu.putExtra("g", b);
                            returnmenu.putExtra("m", c);
                            returnmenu.putExtra("p",d);
                            setResult(RESULT_OK, returnmenu);
                            finish();
                            break;

                        }


                }
            });

            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i;
                    i = new Intent(v.getContext(), MainActivity.class);
                    startActivity(i);
                }
            });
            clear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    miles.setText("");
                    amount.setText("");
                    gas.setText("");

                }
            });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_single_fillup, menu);
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
