package com.example.didact.ejerciciofinal1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.didact.ejerciciofinal1.ReservaActivity.EXTRA_RESERVA;

public class ListaReservaActivity extends AppCompatActivity {
    ListView lvReservas;
    ArrayList<Reserva> listaReservas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_reserva);

        cargarDatos();

        lvReservas = (ListView)findViewById(R.id.lvReservas);

        AdaptadorReserva adaptadorReserva=new AdaptadorReserva(this,listaReservas);

        lvReservas.setAdapter(adaptadorReserva);

        lvReservas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Reserva r =((Reserva)parent.getItemAtPosition(position));
                String nombre = r.getNombre();
                String dia = r.getDia();
                String hora = r.getHora();
                int nPersona = r.getnPersona();
                String observacion = r.getObservacion();

                Reserva listaReservaEnviada = new Reserva(nombre, nPersona, dia, hora, observacion);
                Intent i =new Intent(getApplicationContext(),InfoActivity.class);

                i.putExtra(EXTRA_RESERVA, listaReservaEnviada);
                startActivity(i);
            }
        });
    }

    private void cargarDatos(){
        listaReservas.add(new Reserva("Luis",15,"Lunes","13:30","Po eso"));
        listaReservas.add(new Reserva("Pepe",13,"Martes","13:00","Po enga"));
        listaReservas.add(new Reserva("Lola",2,"Viernes","14:30","Po vale"));


    }


}
