package itcollege.team09.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import itcollege.team09.entities.VoimalikAlluvus;
import java.util.Collection;
import itcollege.team09.entities.AdminYksus;

@Entity
@RooToString
@RooEntity
public class AdminYksuseLiik extends Piirivalve implements Serializable  {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
    @Size(max=10)
    private String kood;
    
    @NotNull
    @Size(max=100)
	private String nimetus;
    
    @NotNull
    @DateTimeFormat(style="M-")
    private Date alates = new Date();
    
    @NotNull
    @DateTimeFormat(style="M-")
    private Date kuni;

	@OneToMany(mappedBy = "yksuseliik")
	private Collection<VoimalikAlluvus> ylemyksused;

	@OneToMany(mappedBy = "alamyksus")
	private Collection<VoimalikAlluvus> alamyksused;

	@OneToMany(mappedBy = "adminYksuseLiik")
	private Collection<AdminYksus> adminyksused;
    

	
	public String getKood() {
		return kood;
	}
	public void setKood(String kood) {
		this.kood = kood;
	}
	public String getNimetus() {
		return nimetus;
	}
	public void setNimetus(String nimetus) {
		this.nimetus = nimetus;
	}
	public Date getAlates() {
		return alates;
	}
	public void setAlates(Date alates) {
		this.alates = alates;
	}
	public Date getKuni() {
		return kuni;
	}
	public void setKuni(Date kuni) {
		this.kuni = kuni;
	}
	public Collection<VoimalikAlluvus> getYlemyksused() {
	    return ylemyksused;
	}
	public void setYlemyksused(Collection<VoimalikAlluvus> param) {
	    this.ylemyksused = param;
	}
	public Collection<VoimalikAlluvus> getAlamyksused() {
	    return alamyksused;
	}
	public void setAlamyksused(Collection<VoimalikAlluvus> param) {
	    this.alamyksused = param;
	}
	public Collection<AdminYksus> getAdminyksused() {
	    return adminyksused;
	}
	public void setAdminyksused(Collection<AdminYksus> param) {
	    this.adminyksused = param;
	}
	
    public static List<AdminYksuseLiik> findAllAdminYksuseLiiks() {
    	List<AdminYksuseLiik> items =  entityManager().createQuery("SELECT o FROM AdminYksuseLiik o", AdminYksuseLiik.class).getResultList();
    	for (int i = items.size() - 1; i >= 0; i--) 
    	{ 
    		AdminYksuseLiik item = (AdminYksuseLiik) items.get(i);
    	    if (!itcollege.team09.helpers.Helper.IsSurrogateDate(item.getSuletud())){ 
    	    	items.remove(i); 
    	    }    	
    	} 
    	return items;
    }
}
