package itcollege.team09.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import itcollege.team09.entities.AdminYksuseLiik;
import javax.persistence.ManyToOne;

@Entity
@RooToString
@RooEntity
public class VoimalikAlluvus extends Piirivalve implements Serializable {
	   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull 
    @DateTimeFormat(style="M-")
    private Date alates;
    
    @NotNull
    @DateTimeFormat(style="M-")
    private Date kuni;

	@ManyToOne
	private AdminYksuseLiik yksuseliik;

	@ManyToOne
	private AdminYksuseLiik alamyksus;
    
    
    
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
	public AdminYksuseLiik getYksuseliik() {
	    return yksuseliik;
	}
	public void setYksuseliik(AdminYksuseLiik param) {
	    this.yksuseliik = param;
	}
	public AdminYksuseLiik getAlamyksus() {
	    return alamyksus;
	}
	public void setAlamyksus(AdminYksuseLiik param) {
	    this.alamyksus = param;
	}
	
    
    public static List<VoimalikAlluvus> findAllVoimalikAlluvuses() {
    	List<VoimalikAlluvus> items = entityManager().createQuery("SELECT o FROM VoimalikAlluvus o", VoimalikAlluvus.class).getResultList();
    	for (int i = items.size() - 1; i >= 0; i--) 
    	{ 
    		VoimalikAlluvus item = (VoimalikAlluvus) items.get(i);
    	    if (!itcollege.team09.helpers.Helper.IsSurrogateDate(item.getSuletud())){ 
    	    	items.remove(i); 
    	    }    	
    	} 
    	return items;
    }
    
}
