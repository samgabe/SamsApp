package com.example.student.oderingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView quantity;
    Button numOfCups;
    TextView price;
    int cups=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quantity= (TextView)findViewById(R.id.quantity);
        numOfCups= (Button)findViewById(R.id.numOfCups);
        price= (TextView)findViewById(R.id.price);
    }
    public void addCups(View view)
    {
        cups = cups + 1;
        String strCups=String.valueOf(cups);
        quantity.setText(strCups + "cups ordered");
        setPrice(view);
    }
    public void setPrice(View view)
    {
        int priceInt = 20 * cups;
        String strPrice = String.valueOf(priceInt);
        price.setText("The price is shs."+strPrice);
    }
    public void removeCups(View view)
    {
        if(cups >= 1){
            cups = cups -1;
            String strCups = String.valueOf(cups);
            quantity.setText("The cost is shs." + strCups);
            setPrice(view);
        }
        else{
            Toast.makeText(this,
                    "You must order atleast 1 cup", Toast.LENGTH_SHORT).show();
        }

    }
    public void feedback(View view)
    {
        Toast.makeText(this,
                "Thank you customer",Toast.LENGTH_SHORT).show();
    }
    public void openMessage(View view)
    {
        Intent intent = new Intent(this,Message.class);
        startActivity(intent);
    }
}
