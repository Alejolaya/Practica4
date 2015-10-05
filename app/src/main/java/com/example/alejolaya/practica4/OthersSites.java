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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class OthersSites extends AppCompatActivity {

    ArrayAdapter<String> AdapOthers;
    ListView ListOthers;
    int selected;
    private ListaOthesSites[] datosOthers=new ListaOthesSites[]{
            new ListaOthesSites(R.drawable.prueba2,"Other1","ver"),
            new ListaOthesSites(R.drawable.prueba2,"Other2","ver"),
            new ListaOthesSites(R.drawable.prueba2,"Other3","ver")
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others_sites);
        AdapOthers adapOthers =new AdapOthers(this,datosOthers);
        ListOthers = (ListView)findViewById(R.id.ListOthers);
        ListOthers.setAdapter(adapOthers);
        ListOthers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selected = (int) parent.getItemIdAtPosition(position);
                switch (selected){
                    case 0:
                        Toast.makeText(OthersSites.this, "Other1", Toast.LENGTH_SHORT).show();
                        //startActivity(new Intent(getApplicationContext(), hotel1.class));
                        break;
                    case 1:
                        Toast.makeText(OthersSites.this, "Other2", Toast.LENGTH_SHORT).show();
                        //startActivity(new Intent(getApplicationContext(), hotel2.class));
                        break;
                    case 2:
                        Toast.makeText(OthersSites.this, "Other3", Toast.LENGTH_SHORT).show();
                        //startActivity(new Intent(getApplicationContext(), hotel3.class));
                        break;
                }
            }
        });
    }
    public class AdapOthers extends ArrayAdapter{
        public AdapOthers(Context context, ListaOthesSites[] datosOthers) {
            super(context,R.layout.layaout_others_sites,datosOthers);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater infOthers = LayoutInflater.from(getContext());
            View itemOthers = infOthers.inflate(R.layout.layaout_others_sites, null);

            TextView nameOther = (TextView) itemOthers.findViewById(R.id.tvMenuItemOthers);
            nameOther.setText(datosOthers[position].getTituloOthers());

            TextView info = (TextView) itemOthers.findViewById(R.id.tvSubItemOthers);
            info.setText(datosOthers[position].getSubTituloOthers());

            ImageView imagen = (ImageView) itemOthers.findViewById(R.id.imagenOthers);
            imagen.setImageResource(datosOthers[position].getIdImagenOthers());



            return itemOthers;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_others_sites, menu);
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
