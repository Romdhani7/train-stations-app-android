package com.example.tp4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listv= findViewById(R.id.listview);
        registerForContextMenu(listv);
        gares Sejnane = new gares("Sejnane","Bizerte","sejnane");
        gares Sened = new gares("Sened","Gafsa","sened");
        gares sfax = new gares("Sfax","Sfax","sfax");
        gares sidi_abid = new gares("Sidi Abid","Tunisie","sidiabid");
        gares sidi_bou_ali = new gares("Sidi Bou Ali","sousse","sidibouali");
        gares Sidi_bou_Rouis = new gares("Sidi Bou Rouis","Tunisie","sidibourouis");
        gares Sidi_Mtir  = new gares("Sidi Mtir","Nabeul","sidimtir");
        gares [] gareslist={Sejnane, Sened ,sfax ,sidi_abid,sidi_bou_ali,Sidi_bou_Rouis,Sidi_Mtir};
        String[] Name={"Sejnane","Sened","Sfax","Sidi Abid","Sidi Bou Ali","Sidi Bou Rouis","Sidi Mtir"};
        String[]garespalce={"Bizerte","Gafsa","Sfax","Tunisie","sousse","Tunisie","Nabeul"};
        int xmlfile =R.layout.custom_row;
        customAdapter adapter= new customAdapter(MainActivity.this,xmlfile,gareslist);
        listv.setAdapter(adapter);
        listv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(MainActivity.this,GareActivity.class);
                intent.putExtra("garesname",Name[i]);
                intent.putExtra("garesplace",garespalce[i]);
                startActivity(intent);

            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.stw)
        {
         Intent intent=new Intent(Intent.ACTION_VIEW);
         intent.setData(Uri.parse("http://wwww.sncft.com.tn/"));
         startActivity(intent);
        }
        else if (item.getItemId()==R.id.GA)
        {
            Intent intent=new Intent(MainActivity.this,GareActivity.class);
            startActivity(intent);
        }
        return super.onContextItemSelected(item);
    }
}