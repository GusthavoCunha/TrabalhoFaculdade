package com.example.appsavelocation;

public class Localizacao {

    private int id;
    private String nome;
    private double latitude, longitude;

    public Localizacao(){

    }

    public Localizacao( String nome, double latitude, double longitude){

        this.setNome(nome);
        this.setLatitude(latitude);
        this.setLongitude(longitude);

    }


    public Localizacao(int id, String nome, double latitude, double longitude){

        this.setId(id);
        this.setNome(nome);
        this.setLatitude(latitude);
        this.setLongitude(longitude);


    }


    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }



    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}


