package com.example.tp4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GareActivity extends AppCompatActivity {
    TextView nom, adress;
    private Object GareActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gare);
        nom = findViewById(R.id.garespecfique);
        adress = findViewById(R.id.placespecifique);
        Intent intent = getIntent();
        if (intent != null) {
            String nomg = intent.getStringExtra("garesname");
            String adresseg = intent.getStringExtra("garesplace");
            nom.setText("nom de gares :" + nomg);
            adress.setText("Adresse de gares :" + adresseg);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.activity_gare,menu);
        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.dt)
        {
          Intent i=new Intent(Intent.ACTION_DELETE,Uri.parse("activity" +GareActivity));
          startActivity(i);
        }
        else if  (item.getItemId()==R.id.ap)
        {
        Intent i = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:713344444"));
        startActivity(i);
        }
        return true ;
    }
}