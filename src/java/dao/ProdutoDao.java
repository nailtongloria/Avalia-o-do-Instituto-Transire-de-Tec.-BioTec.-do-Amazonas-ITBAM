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
import modelo.Produto;

/**
 *
 * @author nailton viana gloria
 */
@Stateless
public class ProdutoDao {
    @PersistenceContext(name="DESAFIOITBAMPU")
    private EntityManager em;

    public ProdutoDao() {
    }
   
    public void inserir(Produto p){
        em.persist(p);
    }
    public void  alterar(Produto p){
        em.merge(p);
    }
    
    public List<Produto> listarProdutos(){
        Query query = em.createQuery("select p from Produto p");
        List<Produto> produtos = query.getResultList();
        return produtos;
    }
    
     public List<Produto> getProdutos(String produto) {
         String jpql = "select p from Produto p  WHERE p.nome like :nomeProduto";
        Query query = em.createQuery(jpql);
         query.setParameter("nomeProduto","%"+produto+"%");
         return query.getResultList();
    }
    
    public void excluir(Produto produto){
        Produto p=em.find(Produto.class,produto.getId());
        em.remove(p);
        
    }
    
    public Produto visualizar(Produto p){
        Produto produto = new  Produto();
        produto = em.find(Produto.class,p.getId());
        return produto;
    }
    
    public Produto localizar(Long id){
        return em.find(Produto.class,id);
    }
}
