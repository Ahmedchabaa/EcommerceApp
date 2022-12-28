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

public class ModeActivity extends AppCompatActivity {

    GridView list3;
    String[] a=new String[]{"Sweat","Shoas","Manteau","Funky"};
    int[] imag={R.drawable.sweat,R.drawable.shoas,R.drawable.mateau,R.drawable.funky};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);
        list3=findViewById(R.id.gridmode);
        Intent b=getIntent();
        GridAdapter s=new GridAdapter(this,a,imag);
        list3.setAdapter(s);
        list3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ShowDialog(i);
            }
        });
    }
    private void ShowDialog(int pos) {
        Dialog dialog = new Dialog(ModeActivity.this);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog);
        ImageView img=dialog.findViewById(R.id.img);
        TextView name=dialog.findViewById(R.id.name);
        TextView prix=dialog.findViewById(R.id.prix);
        Button achet=dialog.findViewById(R.id.achet);
        Button annul=dialog.findViewById(R.id.annul);

        if (pos==0) {
            name.setText("Sweat à Capuche - Noir - Hunter X Hunter");
            prix.setText("38.00 TND");
            img.setImageResource(R.drawable.sweat);
        }
        else if (pos==1){
            name.setText("CH LES ETOILES Espadrille - Gris - Rose - femme");
            prix.setText("43.00 TND");
            img.setImageResource(R.drawable.shoas);
        }
        else if (pos==2){
            name.setText("Etre exclusif parka - Femme - 3226 H22 - NOIR - faux daim");
            prix.setText("288.00 TND");
            img.setImageResource(R.drawable.mateau);
        }
        else if (pos==3){
            name.setText("Funky Mules Dame - Beige 44589");
            prix.setText("27.00 TND");
            img.setImageResource(R.drawable.funky);
        }
        achet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ModeActivity.this, "Commande enregistrée", Toast.LENGTH_SHORT).show();
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
                Intent a=new Intent(ModeActivity.this,MainActivity.class);
                startActivity(a);
                break;
            case R.id.item1:
                Intent b=new Intent(ModeActivity.this,InformatiqueActivity.class);
                startActivity(b);
                break;
            case R.id.item2:
                Intent c=new Intent(ModeActivity.this,MaisonActivity.class);
                startActivity(c);
                break;
            case R.id.item3:
                Intent d=new Intent(ModeActivity.this,ModeActivity.class);
                startActivity(d);
                break;
            case R.id.item4:
                Intent e=new Intent(ModeActivity.this,SportActivity.class);
                startActivity(e);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}