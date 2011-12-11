package itcollege.team09.helpers;

import itcollege.team09.entities.AdminYksus;
import itcollege.team09.entities.AdminYksuseLiik;
import itcollege.team09.entities.Vaeosa;
import itcollege.team09.entities.VaeosaAlluvus;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
    			"SELECT o FROM VaeosaAlluvus o WHERE o.vaeosa = :vaeosa", VaeosaAlluvus.class);
            q.setParameter("vaeosa", v);		
		
		return q.getResultList();
	}
	
	public static List<Vaeosa> getVaeosaAlluvadVaeosad(Vaeosa v){
		TypedQuery<Vaeosa> q = entityManager().createQuery(
    			"SELECT o.alamvaeosa FROM VaeosaAlluvus o WHERE o.vaeosa = :vaeosa", Vaeosa.class);
            q.setParameter("vaeosa", v);		
		
		return q.getResultList();
	}
	
	public static List<AdminYksuseLiik> getAdminYksuseLiigiAlluvad(AdminYksuseLiik a){
		TypedQuery<AdminYksuseLiik> q = entityManager().createQuery(
    			"SELECT o.alamyksus FROM VoimalikAlluvus o WHERE o.yksuseliik = :adminYksuseLiik", AdminYksuseLiik.class);
            q.setParameter("adminYksuseLiik", a);		
		
		return q.getResultList();
	}
	
	public static List<AdminYksus> getAdminYksuseAlluvad(AdminYksus a){
		TypedQuery<AdminYksus> q = entityManager().createQuery(
    			"SELECT o.alamadminyksus FROM AdminAlluvus o WHERE o.adminyksus = :adminYksus", AdminYksus.class);
            q.setParameter("adminYksus", a);		
		
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
