package itcollege.team09.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import itcollege.team09.entities.Vaeosa;
import javax.persistence.ManyToOne;

@Entity
@RooToString
@RooEntity
public class VaeosaAlluvus extends Piirivalve implements Serializable  {
	
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
	private Vaeosa vaeosa;

	@ManyToOne
	private Vaeosa alamvaeosa;
    
    
        
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
	public Vaeosa getVaeosa() {
	    return vaeosa;
	}
	public void setVaeosa(Vaeosa param) {
	    this.vaeosa = param;
	}
	public Vaeosa getAlamvaeosa() {
	    return alamvaeosa;
	}
	public void setAlamvaeosa(Vaeosa param) {
	    this.alamvaeosa = param;
	}
	
    
    public static List<VaeosaAlluvus> findAllVaeosaAlluvuses() {
    	List<VaeosaAlluvus> items = entityManager().createQuery("SELECT o FROM VaeosaAlluvus o", VaeosaAlluvus.class).getResultList();
    	for (int i = items.size() - 1; i >= 0; i--) 
    	{ 
    		VaeosaAlluvus item = (VaeosaAlluvus) items.get(i);
    	    if (!itcollege.team09.helpers.Helper.IsSurrogateDate(item.getSuletud())){ 
    	    	items.remove(i); 
    	    }    	
    	} 
    	return items;
    }
}
