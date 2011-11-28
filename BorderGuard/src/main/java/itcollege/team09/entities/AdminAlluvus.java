package itcollege.team09.entities;

import java.io.Serializable;
import java.util.Date;

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
	private AdminYksus adminYksus;
	@ManyToOne
	private AdminYksus adminYksus_1;
	
	

	public AdminYksus getAdminYksus() {
	    return adminYksus;
	}
	public void setAdminYksus(AdminYksus param) {
	    this.adminYksus = param;
	}
	public AdminYksus getAdminYksus_1() {
	    return adminYksus_1;
	}
	public void setAdminYksus_1(AdminYksus param) {
	    this.adminYksus_1 = param;
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
}
