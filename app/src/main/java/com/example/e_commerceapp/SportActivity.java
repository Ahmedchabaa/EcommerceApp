package com.example.e_commerceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SportActivity extends AppCompatActivity {

    GridView list1;
    String[] a=new String[]{"Tapis YOGA","Ceinture musculation","Banc multigym","Gants sportifs"};
    int[] imag={R.drawable.tapis,R.drawable.ceinture,R.drawable.banc,R.drawable.gant};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport);
        list1=findViewById(R.id.gridsport);
        Intent b=getIntent();
        GridAdapter s=new GridAdapter(this,a,imag);
        list1.setAdapter(s);
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ShowDialog(i);
            }
        });
    }
    private void ShowDialog(int pos) {
        Dialog dialog = new Dialog(SportActivity.this);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog);
        ImageView img=dialog.findViewById(R.id.img);
        TextView name=dialog.findViewById(R.id.name);
        TextView prix=dialog.findViewById(R.id.prix);
        Button achet=dialog.findViewById(R.id.achet);
        Button annul=dialog.findViewById(R.id.annul);

        if (pos==0) {
            name.setText("OKPRO Tapis de Yoga de 1.5cm- Bleu");
            prix.setText("75.00 TND");
            img.setImageResource(R.drawable.tapis);
        }
        else if (pos==1){
            name.setText("Ceinture musculation en néoprène");
            prix.setText("37.00 TND");
            img.setImageResource(R.drawable.ceinture);
        }
        else if (pos==2){
            name.setText("Banc multigym");
            prix.setText("269.00 TND");
            img.setImageResource(R.drawable.banc);
        }
        else if (pos==3){
            name.setText("Zmt Pro Gants de musculation 5.0 - Violet & Noir");
            prix.setText("44.00 TND");
            img.setImageResource(R.drawable.gant);
        }
        achet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SportActivity.this, "Commande enregistrée", Toast.LENGTH_SHORT).show();
            }
        });
        annul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item0:
                Intent a=new Intent(SportActivity.this,MainActivity.class);
                startActivity(a);
                break;
            case R.id.item1:
                Intent b=new Intent(SportActivity.this,InformatiqueActivity.class);
                startActivity(b);
                break;
            case R.id.item2:
                Intent c=new Intent(SportActivity.this,MaisonActivity.class);
                startActivity(c);
                break;
            case R.id.item3:
                Intent d=new Intent(SportActivity.this,ModeActivity.class);
                startActivity(d);
                break;
            case R.id.item4:
                Intent e=new Intent(SportActivity.this,SportActivity.class);
                startActivity(e);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}