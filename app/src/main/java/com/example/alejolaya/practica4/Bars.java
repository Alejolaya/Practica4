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

public class Bars extends AppCompatActivity {
ArrayAdapter<String>AdapBar;
    ListView ListBar;
    int selected;
    private ListaBars[] datosBares=new ListaBars[]{
            new ListaBars(R.drawable.prueba,"BAR1","ver"),
            new ListaBars(R.drawable.prueba,"BAR2","ver"),
            new ListaBars(R.drawable.prueba,"BAR2","ver")

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bars);
        AdapBar adapBar =new AdapBar(this,datosBares);
        ListBar=(ListView) findViewById(R.id.ListBars);
        ListBar.setAdapter(adapBar);
        ListBar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selected=(int) parent.getItemIdAtPosition(position);
                switch (selected) {
                    case 0:
                        Toast.makeText(Bars.this, "BAR1", Toast.LENGTH_SHORT).show();
                        //startActivity(new Intent(getApplicationContext(), hotel1.class));
                        break;
                    case 1:
                        Toast.makeText(Bars.this, "BAR2", Toast.LENGTH_SHORT).show();
                        //startActivity(new Intent(getApplicationContext(), hotel2.class));
                        break;
                    case 2:
                        Toast.makeText(Bars.this, "BAR3", Toast.LENGTH_SHORT).show();
                        //startActivity(new Intent(getApplicationContext(), hotel3.class));
                        break;
                }
            }
        });
    }
    public class AdapBar extends ArrayAdapter{
        public AdapBar(Context context, ListaBars[] datosBares) {
            super(context,R.layout.layaout_bars, datosBares);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater infbar = LayoutInflater.from(getContext());
            View itemBar = infbar.inflate(R.layout.layaout_bars, null);

            TextView nombreBar = (TextView) itemBar.findViewById(R.id.tvMenuItemBars);
            nombreBar.setText(datosBares[position].getTituloBars());

            TextView infoBar = (TextView) itemBar.findViewById(R.id.tvSubItemBars);
            infoBar.setText(datosBares[position].getSubTituloBars());

            ImageView imagen = (ImageView) itemBar.findViewById(R.id.imagenBars);
            imagen.setImageResource(datosBares[position].getIdImagenBars());


            return itemBar;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bars, menu);
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
