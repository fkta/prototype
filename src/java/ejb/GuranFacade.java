/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Guran;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author glowo
 */
@Stateless
public class GuranFacade extends AbstractFacade<Guran> {

    @PersistenceContext(unitName = "adminpagePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GuranFacade() {
        super(Guran.class);
    }
    
    public void delete(Guran guran){
        em.remove(em.merge(guran));
    }
    
}
