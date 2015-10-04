package com.example.alejolaya.practica4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView;


public class Hoteles extends AppCompatActivity {
    ArrayAdapter<String> Adaphoteles;
    ListView listMenu;
    int selected;
    private ListaMenu[] datoshoteles=
            new ListaMenu[]{
                    new ListaMenu(R.drawable.smartbarranquilla1,"History","ver"),
                    new ListaMenu(R.drawable.smarthotel1,"Hotels","ver"),
                    new ListaMenu(R.drawable.prueba2,"Bars","ver"),
                    new ListaMenu(R.drawable.prueba2,"Tourist places","ver")

            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoteles);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hoteles, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id==R.id.item_salir){
            finish();
        }
        if (id== R.id.item_acercade){
            Intent i=new Intent(this, AboutThis.class);
            startActivity(i);
            Toast.makeText(this, "PDM 2015-2", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
