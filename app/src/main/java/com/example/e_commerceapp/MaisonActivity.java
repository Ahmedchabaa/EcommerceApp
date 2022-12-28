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

public class MaisonActivity extends AppCompatActivity {

    GridView list2;
    String[] a=new String[]{"Fauteuil","Table et Chaises","Corbeille à Courrier","Lampe Bureau"};
    int[] imag={R.drawable.fauteuil,R.drawable.table,R.drawable.corbeille,R.drawable.lampe};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maison);
        list2=findViewById(R.id.gridmaison);
        Intent b=getIntent();
        GridAdapter s=new GridAdapter(this,a,imag);
        list2.setAdapter(s);
        list2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ShowDialog(i);
            }
        });
    }
    private void ShowDialog(int pos) {
        Dialog dialog = new Dialog(MaisonActivity.this);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog);
        ImageView img=dialog.findViewById(R.id.img);
        TextView name=dialog.findViewById(R.id.name);
        TextView prix=dialog.findViewById(R.id.prix);
        Button achet=dialog.findViewById(R.id.achet);
        Button annul=dialog.findViewById(R.id.annul);

        if (pos==0) {
            name.setText("Intex Fauteuil gonflable avec chaise longue");
            prix.setText("175.00 TND");
            img.setImageResource(R.drawable.fauteuil);
        }
        else if (pos==1){
            name.setText("Pack Table Avec 4 Chaises pour café,Restaurant et Cuisine");
            prix.setText("749.00 TND");
            img.setImageResource(R.drawable.table);
        }
        else if (pos==2){
            name.setText("Corbeille à Courrier - Métal - Superposable - 3 Étages - Noir -");
            prix.setText("38.00 TND");
            img.setImageResource(R.drawable.corbeille);
        }
        else if (pos==3){
            name.setText("Lampe bureau - Architecte - Réglable - Moderne - Métal - Noir");
            prix.setText("69.00 TND");
            img.setImageResource(R.drawable.lampe);
        }
        achet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MaisonActivity.this, "Commande enregistrée", Toast.LENGTH_SHORT).show();
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
                Intent a=new Intent(MaisonActivity.this,MainActivity.class);
                startActivity(a);
                break;
            case R.id.item1:
                Intent b=new Intent(MaisonActivity.this,InformatiqueActivity.class);
                startActivity(b);
                break;
            case R.id.item2:
                Intent c=new Intent(MaisonActivity.this,MaisonActivity.class);
                startActivity(c);
                break;
            case R.id.item3:
                Intent d=new Intent(MaisonActivity.this,ModeActivity.class);
                startActivity(d);
                break;
            case R.id.item4:
                Intent e=new Intent(MaisonActivity.this,SportActivity.class);
                startActivity(e);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}