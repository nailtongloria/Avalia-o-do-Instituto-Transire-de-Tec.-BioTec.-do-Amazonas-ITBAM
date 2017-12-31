/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.LojaDao;
import dao.ProdutoDao;
import javax.ejb.EJB;
import modelo.Loja;
import modelo.Produto;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author nailton viana gloria
 */

public class ProdutoBeanTest {

    //alguns testes realizados com o junit para a classe ProdutoBean.

    @EJB
    private ProdutoDao produtoDao ;
    @EJB
    private LojaDao lojaDao ;

    private Produto produto = new Produto();

    public ProdutoBeanTest() {
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of init method, of class ProdutoBean.
     */
    @Test
    public void testInit() {
    }

    /**
     * Test of carregarProdutos method, of class ProdutoBean.
     */
    @Test
    public void testCarregarProdutos() {

        for (Produto produto : produtoDao.listarProdutos()) {
            System.out.println("produtos  " + produto.getNome());
        }

    }

    
    @Test
    public void testPesquisarProduto() {
        for (Produto produto : produtoDao.getProdutos("camisa")) {
            System.out.println("produtos  " + produto.getNome());
        }
    }

    
    @Test
    public void testSalvarProduto() {
        produto.setNome("camisa social");
        produtoDao.inserir(produto);

    }

    @Test
    public void testCarregarLojas() {
        for (Loja l : lojaDao.listarProdutos()) {
            System.out.println(" lojas " + l.getNome());
        }
    }

}
