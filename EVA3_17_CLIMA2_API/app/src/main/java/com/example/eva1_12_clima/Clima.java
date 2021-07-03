package com.example.eva1_12_clima;

public class Clima {
    private int imagen;
    private double temp;
    private String ciudad;
    private String desc;


    public Clima() {
        this.imagen = R.drawable.sunny;
        this.ciudad = "Tangamandapio";
        this.temp = 27.3;
        this.desc = "Rojo atardecer con crespusculos arrebolados";
    }

    public Clima(int imagen, double temp, String ciudad, String desc) {
        this.imagen = imagen;
        this.ciudad = ciudad;
        this.temp = temp;
        this.desc = desc;
    }



    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
