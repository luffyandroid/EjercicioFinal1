package com.example.didact.ejerciciofinal1;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by DIDACT on 16/02/2018.
 */

public class Reserva implements Parcelable{

    String nombre;
    int nPersona;
    String dia;
    String hora;
    String observacion;

    public static final Parcelable.Creator<Reserva> CREATOR = new Parcelable.Creator<Reserva>(){
        public Reserva createFromParcel(Parcel in) {return new Reserva(in);
        }

        public Reserva[] newArray(int size){return new Reserva[size];
        }

    };

    public Reserva(String nombre, int nPersona, String dia, String hora, String observacion) {
        this.nombre = nombre;
        this.nPersona = nPersona;
        this.dia = dia;
        this.hora = hora;
        this.observacion = observacion;
    }

    public Reserva(Parcel p){
        readFromParcel(p);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getnPersona() {
        return nPersona;
    }

    public void setnPersona(int nPersona) {
        this.nPersona = nPersona;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nombre);
        dest.writeInt(this.nPersona);
        dest.writeString(this.dia);
        dest.writeString(this.hora);
        dest.writeString(this.observacion);
    }

    private void readFromParcel (Parcel p){
        this.nombre = p.readString();
        this.nPersona = p.readInt();
        this.dia = p.readString();
        this.hora = p.readString();
        this.observacion = p.readString();
    }
}
