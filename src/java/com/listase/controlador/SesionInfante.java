/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.controlador;

import com.listase.modelo.Infante;
import com.listase.modelo.ListaSE;
import com.listase.modelo.Nodo;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;

/**
 *
 * @author carloaiza
 */
@Named(value = "sesionInfante")
@SessionScoped
public class SesionInfante implements Serializable {
    private ListaSE listaInfantes;
    private Infante infante;
    private String alInicio="1";
    private boolean deshabilitarFormulario=true;
    private Nodo ayudante;
    
    /**
     * Creates a new instance of SesionInfante
     */
    public SesionInfante() {        
    }
    
    @PostConstruct
    private void inicializar()
    {
        listaInfantes = new ListaSE();
        
        //LLenado de la bds
        listaInfantes.adicionarNodo(new Infante("Carlitos",(short) 1, (byte)2));
        listaInfantes.adicionarNodo(new Infante("Juanita",(short) 2, (byte)3));
        listaInfantes.adicionarNodo(new Infante("Martina",(short) 3, (byte)1));
        listaInfantes.adicionarNodoAlInicio(new Infante("Mariana",(short) 4, (byte)5));
        ayudante = listaInfantes.getCabeza();
        infante = ayudante.getDato();
        
    }

    public boolean isDeshabilitarFormulario() {
        return deshabilitarFormulario;
    }

    public void setDeshabilitarFormulario(boolean deshabilitarFormulario) {
        this.deshabilitarFormulario = deshabilitarFormulario;
    }

  
    
    

    public String getAlInicio() {
        return alInicio;
    }

    public void setAlInicio(String alInicio) {
        this.alInicio = alInicio;
    }
    
    public ListaSE getListaInfantes() {
        return listaInfantes;
    }

    public void setListaInfantes(ListaSE listaInfantes) {
        this.listaInfantes = listaInfantes;
    }

    public Infante getInfante() {
        return infante;
    }

    public void setInfante(Infante infante) {
        this.infante = infante;
    }
    
    
    
    public void guardarInfante()
    {
        infante.setCodigo((short)(listaInfantes.contarNodos()+1));
        if(alInicio.compareTo("1")==0)
        {
            listaInfantes.adicionarNodoAlInicio(infante);
        }
        else
        {
            listaInfantes.adicionarNodo(infante);
        }        
        deshabilitarFormulario=true;
        
    }
    
    public void habilitarFormulario()
    {
        deshabilitarFormulario=false;
        infante = new Infante();
    }
    
    public void irSiguiente()
    {
        if(ayudante.getSiguiente()!=null)
        {
            ayudante = ayudante.getSiguiente();
            infante = ayudante.getDato();
        }
        
    }
    
}
