package itcollege.team09.entities;

import java.util.Date;

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
public class VaeosaAlluvus extends Piirivalve {
	
    @NotNull
    @DateTimeFormat(style="M-")
    private Date alates;
    
    @NotNull
    @DateTimeFormat(style="M-")
    private Date kuni;
    
	@ManyToOne
	private Vaeosa ylemVaeosa;

	@ManyToOne
	private Vaeosa alamVaeosa;
	
		

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
	public Vaeosa getYlemVaeosa() {
	    return ylemVaeosa;
	}
	public void setYlemVaeosa(Vaeosa param) {
	    this.ylemVaeosa = param;
	}
	public Vaeosa getAlamVaeosa() {
	    return alamVaeosa;
	}
	public void setAlamVaeosa(Vaeosa param) {
	    this.alamVaeosa = param;
	}
}
