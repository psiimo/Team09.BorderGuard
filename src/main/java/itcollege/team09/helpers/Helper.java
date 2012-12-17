package itcollege.team09.helpers;

import itcollege.team09.entities.AdminYksus;
import itcollege.team09.entities.AdminYksuseLiik;
import itcollege.team09.entities.Vaeosa;
import itcollege.team09.entities.VaeosaAlluvus;
import itcollege.team09.entities.VoimalikAlluvus;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
	
	  /**
     * Vaeosa
     */
	public static List<Vaeosa> getAlluvadVaeosad(Vaeosa v){
		TypedQuery<Vaeosa> q = entityManager().createQuery(
    			"SELECT o.alamvaeosa FROM VaeosaAlluvus o WHERE o.vaeosa = :vaeosa", Vaeosa.class);
            q.setParameter("vaeosa", v);		
		
		return q.getResultList();
	}
	
	public static List<VaeosaAlluvus> getYlemVaeosad(Vaeosa v){
		TypedQuery<VaeosaAlluvus> q = entityManager().createQuery(
    			"SELECT o FROM VaeosaAlluvus o WHERE o.alamvaeosa = :vaeosa", VaeosaAlluvus.class);
            q.setParameter("vaeosa", v);		
		
		return q.getResultList();
	}
		
	/**
	 * AdminYksuse liik
	 */
	public static List<AdminYksuseLiik> getAdminYksuseLiigiAlluvad(AdminYksuseLiik a){
		TypedQuery<AdminYksuseLiik> q = entityManager().createQuery(
    			"SELECT o.alamyksus FROM VoimalikAlluvus o WHERE o.yksuseliik = :adminYksuseLiik", AdminYksuseLiik.class);
            q.setParameter("adminYksuseLiik", a);		
		
		return q.getResultList();
	}
	
	public static List<VoimalikAlluvus> getAdminYksuseLiigiYlemad(AdminYksuseLiik a){
		TypedQuery<VoimalikAlluvus> q = entityManager().createQuery(
    			"SELECT o FROM VoimalikAlluvus o WHERE o.alamyksus = :adminYksuseLiik", VoimalikAlluvus.class);
            q.setParameter("adminYksuseLiik", a);		
		
		return q.getResultList();
	}
	
	/**
	 * Adminyksus
	 */
	public static List<AdminYksus> getAdminYksuseAlluvad(AdminYksus a){
		TypedQuery<AdminYksus> q = entityManager().createQuery(
    			"SELECT o.alamadminyksus FROM AdminAlluvus o WHERE o.adminyksus = :adminYksus", AdminYksus.class);
            q.setParameter("adminYksus", a);		
		
		return q.getResultList();
	}
	
	public static boolean IsSurrogateDate(Date date){
		
		if (date == null) {
			return false;
		}
		SimpleDateFormat simpleDateformatYear = new SimpleDateFormat("yyyy");
		SimpleDateFormat simpleDateformatMonth = new SimpleDateFormat("MM");
		SimpleDateFormat simpleDateformatDay = new SimpleDateFormat("d");
		
		
		String year = simpleDateformatYear.format(date);
		String month = simpleDateformatMonth.format(date);
		String day = simpleDateformatDay.format(date);
		
		// System.out.println("Testing IsSurrogateDate YEAR:" + year + " Month:" + month + " Day:" +day);
		if(year.equals("9999") && month.equals("12") && day.equals("31")){		
			return true;
		}else{
			return false;
		}
		
	}
}
