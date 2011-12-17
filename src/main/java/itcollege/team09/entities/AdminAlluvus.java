package itcollege.team09.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import itcollege.team09.entities.AdminYksus;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@RooToString
@RooEntity
public class AdminAlluvus extends Piirivalve implements Serializable {

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
	private AdminYksus adminyksus;
	@ManyToOne
	private AdminYksus alamadminyksus;
	
	

	public AdminYksus getAdminyksus() {
	    return adminyksus;
	}
	public void setAdminyksus(AdminYksus param) {
	    this.adminyksus = param;
	}
	public AdminYksus getAlamadminyksus() {
	    return alamadminyksus;
	}
	public void setAlamadminyksus(AdminYksus param) {
	    this.alamadminyksus = param;
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
	
    public static List<AdminAlluvus> findAllAdminAlluvuses() {
    	List<AdminAlluvus> items = entityManager().createQuery("SELECT o FROM AdminAlluvus o", AdminAlluvus.class).getResultList();
    	for (int i = items.size() - 1; i >= 0; i--) 
    	{ 
    		AdminAlluvus item = (AdminAlluvus) items.get(i);
    	    if (!itcollege.team09.helpers.Helper.IsSurrogateDate(item.getSuletud())){ 
    	    	items.remove(i); 
    	    }    	
    	} 
    	return items;
    }
}
