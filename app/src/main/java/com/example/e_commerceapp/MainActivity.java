package com.example.e_commerceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    GridView gril;
    String[] x = new String[]{"Informatique","Maison et Bureaux","La Mode","Sport"};
    int[] image = {R.drawable.informatique,R.drawable.maison,R.drawable.lamode,R.drawable.sports};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gril = findViewById(R.id.grille);
        GridAdapter s = new GridAdapter(this, x,image);
        gril.setAdapter(s);
        gril.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println(i);
                switch (i){
                    case 0:
                        Intent a=new Intent(MainActivity.this,InformatiqueActivity.class);
                        startActivity(a);
                        break;
                    case 1:
                        Intent b=new Intent(MainActivity.this,MaisonActivity.class);
                        startActivity(b);
                        break;
                    case 2:
                        Intent c=new Intent(MainActivity.this,ModeActivity.class);
                        startActivity(c);
                        break;
                    case 3:
                        Intent d=new Intent(MainActivity.this,SportActivity.class);
                        startActivity(d);
                        break;
                }
            }
        });
    }
}