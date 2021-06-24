package com.example.appsavelocation;

public class Localizacao {

    private int id;
    private String nome;
    private int latitude, longitude;

    public Localizacao(){

    }

    public Localizacao( String nome, int latitude, int longitude){

        this.setNome(nome);
        this.setLatitude(latitude);
        this.setLongitude(longitude);

    }


    public Localizacao(int id, String nome, int latitude, int longitude){

        this.setId(id);
        this.setNome(nome);
        this.setLatitude(latitude);
        this.setLongitude(longitude);


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

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }
}


