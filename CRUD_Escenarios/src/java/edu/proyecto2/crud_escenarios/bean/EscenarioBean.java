/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.proyecto2.crud_escenarios.bean;

import edu.proyecto2.crud_escenarios.data.EspacioDeportivo;
import edu.proyecto2.crud_escenarios.data.EspacioDeportivoJpaController;
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
enum estados{ CDU,Diamante}
@ManagedBean
@ViewScoped
public class EscenarioBean {

    private List<EspacioDeportivo> list=new ArrayList();
    
    private EntityManagerFactory emf;
    private List<String> estado= new ArrayList();
    
    
    
    public EscenarioBean() {
    }

    public List<String>  getEstado() {
       estados aux[]=estados.values();
       for(int i=0;i<aux.length;i++){
           estado.add(aux[i].name());
       }
       return estado;
    }

    
    public List<EspacioDeportivo> getList() {
        emf=Persistence.createEntityManagerFactory("CRUD_EscenariosPU");
        EspacioDeportivoJpaController ctrl= new EspacioDeportivoJpaController(emf);
        list = ctrl.findEspacioDeportivoEntities();

        
        return list;
    }

    public void setList(List<EspacioDeportivo> list) {
        this.list = list;
    }
    public String create(){
        return "create";
    }
    
    
}
