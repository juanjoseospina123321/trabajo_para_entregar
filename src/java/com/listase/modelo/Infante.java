/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.modelo;

import java.io.Serializable;

/**
 *
 * @author carloaiza
 */
public class Infante implements  Serializable{
    private String nombre; //null
    private short codigo; //0
    private byte edad; //0
    private String genero;
    private short conHom;
    private short conMuj;
    
    
    public Infante() {
        this.edad=1;
    }    
    
    public Infante(String nombre, short codigo, byte edad) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.edad = edad;
    }

    
    public Infante(byte edad) {
        this.edad = edad;
    }

    public Infante(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

 
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public short getCodigo() {
        return codigo;
    }

    public void setCodigo(short codigo) {
        this.codigo = codigo;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
       return this.nombre; 
    }
    
    
    
}
