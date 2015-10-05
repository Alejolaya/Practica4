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
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView;


public class Hoteles extends AppCompatActivity {
    ArrayAdapter<String> Adaphotel;
    ListView listHotel;
    int selected;
    private ListaHoteles[] datoshoteles=new ListaHoteles[]{
                    new ListaHoteles(R.drawable.smartbarranquilla1,"Hotel1","ver"),
                    new ListaHoteles(R.drawable.smarthotel1,"Hotel2","ver"),
                    new ListaHoteles(R.drawable.prueba2,"Hotel3","ver")


            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoteles);
        Adaphotel adaphotel= new Adaphotel(this,datoshoteles);
        listHotel=(ListView) findViewById(R.id.ListHoteles);
        listHotel.setAdapter(adaphotel);
        listHotel.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this, String.valueOf(parent.getItemIdAtPosition(position)), Toast.LENGTH_LONG).show();
                selected = (int) parent.getItemIdAtPosition(position);
                switch (selected) {
                    case 0:
                        Toast.makeText(Hoteles.this, "Hotel1", Toast.LENGTH_SHORT).show();
                        //startActivity(new Intent(getApplicationContext(), hotel1.class));
                        break;
                    case 1:
                        Toast.makeText(Hoteles.this, "Hotel2", Toast.LENGTH_SHORT).show();
                        //startActivity(new Intent(getApplicationContext(), hotel2.class));
                        break;
                    case 2:
                        Toast.makeText(Hoteles.this, "Hotel3", Toast.LENGTH_SHORT).show();
                        //startActivity(new Intent(getApplicationContext(), hotel3.class));
                        break;
                }
            }
        });
    }
    public class Adaphotel extends ArrayAdapter {
        public Adaphotel(Context context, ListaHoteles[] datoshoteles) {
            super(context, R.layout.layaout_hoteles, datoshoteles);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater2 = LayoutInflater.from(getContext());
            View itemhotel = inflater2.inflate(R.layout.layaout_hoteles, null);

            TextView hotel = (TextView) itemhotel.findViewById(R.id.tvMenuItemHotel);
            hotel.setText(datoshoteles[position].getTitulo());

            TextView info2 = (TextView) itemhotel.findViewById(R.id.tvSubItemHotel);
            info2.setText(datoshoteles[position].getSubtitulo());

            ImageView imagen = (ImageView) itemhotel.findViewById(R.id.imagenHotel);
            imagen.setImageResource(datoshoteles[position].getIdImagen());


            return itemhotel;
        }

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
