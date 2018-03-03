/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.proyecto2.crud_escenarios.bean;

import edu.proyecto2.crud_escenarios.data.Deporte;
import edu.proyecto2.crud_escenarios.data.DeporteJpaController;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jose
 */
@ManagedBean
@ViewScoped
public class DeporteBean {
    List<Deporte> deportes= new ArrayList<Deporte>();
    private EntityManagerFactory emf;
    public DeporteBean() {
    }

    public List<Deporte> getDeportes() {
         emf=Persistence.createEntityManagerFactory("CRUD_EscenariosPU");
         DeporteJpaController ctrl=new DeporteJpaController(emf);
         deportes=ctrl.findDeporteEntities();
         return deportes;
         
    }

    public void setDeportes(List<Deporte> deportes) {
        this.deportes = deportes;
    }
    
    
}
