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
	private AdminYksuseLiik adminYksuseLiik1;

	@ManyToOne
	private AdminYksuseLiik adminYksuseLiik2;

	
	
	
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
	public AdminYksuseLiik getAdminYksuseLiik1() {
		return adminYksuseLiik1;
	}
	public void setAdminYksuseLiik1(AdminYksuseLiik adminYksuseLiik1) {
		this.adminYksuseLiik1 = adminYksuseLiik1;
	}
	public AdminYksuseLiik getAdminYksuseLiik2() {
		return adminYksuseLiik2;
	}
	public void setAdminYksuseLiik2(AdminYksuseLiik adminYksuseLiik2) {
		this.adminYksuseLiik2 = adminYksuseLiik2;
	}
}
