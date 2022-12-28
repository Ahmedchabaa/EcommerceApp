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

public class InformatiqueActivity extends AppCompatActivity {

    GridView list1;
    String[] a=new String[]{"Imprimante","Souris","Ordinateur","Casque"};
    int[] imag={R.drawable.imprimente,R.drawable.souris,R.drawable.pc,R.drawable.casque};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informatique);
        list1=findViewById(R.id.gridinfo);
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
        Dialog dialog = new Dialog(InformatiqueActivity.this);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog);
        ImageView img=dialog.findViewById(R.id.img);
        TextView name=dialog.findViewById(R.id.name);
        TextView prix=dialog.findViewById(R.id.prix);
        Button achet=dialog.findViewById(R.id.achet);
        Button annul=dialog.findViewById(R.id.annul);

        if (pos==0) {
            name.setText("Hp Imprimante Smart Tank 516 Multifonction - Wifi Garantie 1An");
            prix.setText("519.00 TND");
            img.setImageResource(R.drawable.imprimente);
        }
        else if (pos==1){
            name.setText("Msi Souris gamer - msi clutch gm11 - Blanc");
            prix.setText("49.00 TND");
            img.setImageResource(R.drawable.souris);
        }
        else if (pos==2){
            name.setText("Hp PC PORTABLE HP15-dw3000nk Core i3 - 11GEN - 4GB - 1TB - Natural Silver - Win10 - Garantie: 1 an");
            prix.setText("1.099.00 TND");
            img.setImageResource(R.drawable.pc);
        }
        else if (pos==3){
            name.setText("Jbl Casque Quantum 100 - Noir");
            prix.setText("129.00 TND");
            img.setImageResource(R.drawable.casque);
        }
        achet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(InformatiqueActivity.this, "Commande enregistrée", Toast.LENGTH_SHORT).show();
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
                Intent a=new Intent(InformatiqueActivity.this,MainActivity.class);
                startActivity(a);
                break;
            case R.id.item1:
                Intent b=new Intent(InformatiqueActivity.this,InformatiqueActivity.class);
                startActivity(b);
                break;
            case R.id.item2:
                Intent c=new Intent(InformatiqueActivity.this,MaisonActivity.class);
                startActivity(c);
                break;
            case R.id.item3:
                Intent d=new Intent(InformatiqueActivity.this,ModeActivity.class);
                startActivity(d);
                break;
            case R.id.item4:
                Intent e=new Intent(InformatiqueActivity.this,SportActivity.class);
                startActivity(e);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}