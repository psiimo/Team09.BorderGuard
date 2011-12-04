package itcollege.team09.helpers;

import itcollege.team09.entities.AdminYksus;
import itcollege.team09.entities.Vaeosa;
import itcollege.team09.entities.VaeosaAlluvus;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.roo.addon.javabean.RooJavaBean;

@Configurable
@RooJavaBean
public class Helper {

	@PersistenceContext 
	EntityManager entityManager;	
    public static final EntityManager entityManager() {
        EntityManager em = new Helper().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected");
        return em;
    }
	
	public Helper() {}
	
	public static List<AdminYksus> getAdminnid(){
		return entityManager().createQuery("SELECT o FROM AdminYksus o", AdminYksus.class).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public static List<VaeosaAlluvus> getVaeosaAlluvad(Vaeosa v){
    	Query q = entityManager().createQuery(
    			"SELECT o FROM VaeosaAlluvus o WHERE o.vaeosa = :vaeosa");
            q.setParameter("vaeosa", v);		
		
		return q.getResultList();
	}
	
/*
	@SuppressWarnings("unchecked")
	public static List<Bear> PuurisOlevadKarud(Long id) {
		if (id == null) return null;	
		Query q = entityManager().createQuery(
				"SELECT o FROM Bear o WHERE cage = :cage");
		q.setParameter("cage", Cage.findCage(id));
        return q.getResultList();
    }
 */
}
