package com.Alvarocampos.Proyecto07.Ejercicio05;

enum Sexo {

    //Valores
    M("Male"),
    F("Female");

    private final String texto;
    private Sexo(String texto){
        this.texto=texto;
    }
    public String getTexto(){
        return this.texto;
    }
}
