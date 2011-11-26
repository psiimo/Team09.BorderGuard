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
	private AdminYksuseLiik ylemYksus;

	@ManyToOne
	private AdminYksuseLiik alamYksus;
	
		
	
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
	public AdminYksuseLiik getYlemYksus() {
	    return ylemYksus;
	}
	public void setYlemYksus(AdminYksuseLiik param) {
	    this.ylemYksus = param;
	}
	public AdminYksuseLiik getAlamYksus() {
	    return alamYksus;
	}
	public void setAlamYksus(AdminYksuseLiik param) {
	    this.alamYksus = param;
	}
}
