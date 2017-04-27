/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.Aplicaciones;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mar
 */
@Stateless
public class AplicacionesFacade extends AbstractFacade<Aplicaciones> {

    @PersistenceContext(unitName = "ejemploPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AplicacionesFacade() {
        super(Aplicaciones.class);
    }
    
}
