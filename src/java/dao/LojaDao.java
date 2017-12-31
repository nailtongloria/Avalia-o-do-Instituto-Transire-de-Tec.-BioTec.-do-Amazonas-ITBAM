/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Loja;

/**
 *
 * @author nailton viana gloria
 */
@Stateless
public class LojaDao {
    @PersistenceContext(name="DESAFIOITBAMPU")
    private EntityManager em;

    public LojaDao() {
    }
    
    public List<Loja> listarProdutos(){
        Query query = em.createQuery("select l from Loja l");
        List<Loja> lojas= query.getResultList();
        return lojas;
    }
}
