/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.LojaDao;
import dao.ProdutoDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import modelo.Loja;
import modelo.Produto;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author nailton viana gloria
 */
@ManagedBean(name = "produtoBean")
@SessionScoped
public class ProdutoBean implements Serializable {

    private Produto produto = new Produto();
    private Loja loja = new Loja();
    @EJB
    private ProdutoDao produtoDao;
    @EJB
    private LojaDao lojaDao;

    private List<Loja> itenslojas = new ArrayList<Loja>();
    private List<Produto>produtos= new ArrayList<Produto>();

    
    @PostConstruct
    public void init(){
        carregarLojas();
       
      
    }
    public ProdutoBean() {
    }

    public void carregarProdutos(){
        this.produtos=produtoDao.listarProdutos();
    }
    
    public void pesquisarProduto(){
        this.produtos=produtoDao.getProdutos(produto.getNome());
    }
      
    public String salvarProduto() {
        try {
            produto.setLoja(loja);
            produtoDao.inserir(produto);
            produto = new Produto();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Operação Realizada com Sucesso", null));

        } catch (ConstraintViolationException ex) {
            for (ConstraintViolation c : ex.getConstraintViolations()) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN,
                                "Falha na Operação", null));
            }
        }
         return "ProdutoCadastradoSucesso? faces-redirect=true";
    }

    public StreamedContent getImagemDinamica() {
        String strid = FacesContext.getCurrentInstance().getExternalContext()
                .getRequestParameterMap().get("id_imagem");
        if (strid != null) {
            Long id = Long.parseLong(strid);
            Produto obj = produtoDao.localizar(id);
            return obj.getImagem();
        }
        return new DefaultStreamedContent();
    }

    public void enviarFoto(FileUploadEvent event) {
        try {

            byte[] foto = IOUtils.toByteArray(event.getFile().getInputstream());
            System.out.println("FOTO: " + foto);
            produto.setFoto(foto);

        } catch (Exception e) {

        }
    }
    
    
    public String excluir(Produto produto) {

        System.out.println("excluida  " + produto);

        produtoDao.excluir(produto);

        return "ProdutoExcluidoSucesso? faces-redirect=true";

    }
    
     public String alterar(Produto p) {
        produtoDao.alterar(p);
        this.produto = new Produto();
      
        return "ProdutoAlteradoSucesso? faces-redirect=true";
    }
    public void carregarLojas(){
        this.itenslojas=lojaDao.listarProdutos();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public ProdutoDao getProdutoDao() {
        return produtoDao;
    }

    public void setProdutoDao(ProdutoDao produtoDao) {
        this.produtoDao = produtoDao;
    }

    public LojaDao getLojaDao() {
        return lojaDao;
    }

    public void setLojaDao(LojaDao lojaDao) {
        this.lojaDao = lojaDao;
    }

    public List<Loja> getItenslojas() {
        return itenslojas;
    }

    public void setItenslojas(List<Loja> itenslojas) {
        this.itenslojas = itenslojas;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
    

}
