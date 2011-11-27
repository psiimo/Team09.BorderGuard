package itcollege.team09.entities;

import java.util.Date;

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
public class VoimalikAlluvus extends Piirivalve {
	   
    @NotNull 
    @DateTimeFormat(style="M-")
    private Date alates;
    
    @NotNull
    @DateTimeFormat(style="M-")
    private Date kuni;

	@ManyToOne
	private AdminYksuseLiik adminYksuseLiik;

	@ManyToOne
	private AdminYksuseLiik adminYksuseLiik_1;
    
    
    
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
	public AdminYksuseLiik getAdminYksuseLiik() {
	    return adminYksuseLiik;
	}
	public void setAdminYksuseLiik(AdminYksuseLiik param) {
	    this.adminYksuseLiik = param;
	}
	public AdminYksuseLiik getAdminYksuseLiik_1() {
	    return adminYksuseLiik_1;
	}
	public void setAdminYksuseLiik_1(AdminYksuseLiik param) {
	    this.adminYksuseLiik_1 = param;
	}
}
