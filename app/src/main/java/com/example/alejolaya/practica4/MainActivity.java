package com.example.alejolaya.practica4;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> AdapMenu;
    ListView listMenu;
    int selected;
    private ListaMenu[] datosMenu=
            new ListaMenu[]{
                    new ListaMenu(R.drawable.smartbarranquilla1,"History","ver"),
                    new ListaMenu(R.drawable.smarthotel1,"Hotels","ver"),
                    new ListaMenu(R.drawable.prueba2,"Bars","ver"),
                    new ListaMenu(R.drawable.prueba2,"Tourist places","ver"),
                    new ListaMenu(R.drawable.prueba2,"Demo Info","ver")

            };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Adapter AdapMenu = new Adapter(this, datosMenu);
        listMenu = (ListView) findViewById(R.id.MainMenu);
        listMenu.setAdapter(AdapMenu);
        final Intent historia= new Intent(this, historia.class);
        final Intent hoteles= new Intent(this, Hoteles.class);
        final Intent bares= new Intent(this, Bars.class);
        final Intent sitiosturisticos= new Intent(this, OthersSites.class);
        listMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selected = (int) parent.getItemIdAtPosition(position);

                switch (selected) {
                    case 0:
                        startActivity(historia);
                        Toast.makeText(MainActivity.this, "Elemento1", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:

                        startActivity(new Intent(getApplicationContext(), Hoteles.class));
                        Toast.makeText(MainActivity.this, "Hotels", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        startActivity(new Intent(getApplicationContext(), Bars.class));
                        break;
                    case 3:
                        startActivity(new Intent(getApplicationContext(), OthersSites.class));
                        break;
                }
            }
        });

    }

    public class Adapter extends ArrayAdapter{
        public Adapter(Context context, ListaMenu[] datosMenu) {
            super(context, R.layout.layaout_main_menu,datosMenu);

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater= LayoutInflater.from(getContext());
            View Item = inflater.inflate(R.layout.layaout_main_menu, null);

            ImageView ImagenMenu =(ImageView) Item.findViewById(R.id.imagen);
            ImagenMenu.setImageResource(datosMenu[position].getIdImagen());

            TextView ItemMenu = (TextView) Item.findViewById(R.id.tvMenuItem);
            ItemMenu.setText(datosMenu[position].getNameItem());

            TextView SubItemMenu= (TextView) Item.findViewById(R.id.tvSubItem);
            SubItemMenu.setText(datosMenu[position].getSubItem());

            return Item;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if(id==R.id.item_salir){
            finish();
        }
        if (id== R.id.item_acercade){
            Intent  i=new Intent(this, AboutThis.class);
            startActivity(i);
            Toast.makeText(this, "PDM 2015-2", Toast.LENGTH_SHORT).show();
        }
        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }
}
