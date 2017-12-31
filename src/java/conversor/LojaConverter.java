/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversor;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import modelo.Loja;

/**
 *
 * @author nailton viana gloria
 */
@Named ("lojaConverter")
@RequestScoped
public class LojaConverter implements Converter {
    
    @Inject
     EntityManager em;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
          Long id=   Long.valueOf(value);
             Loja loja = em.find(Loja.class, id);
            System.out.println("Lojas: " + loja.toString());
             return loja;
       
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
       
          Loja loja=(Loja) value;
        return String.valueOf(loja.getId());
        
    }
    
}
