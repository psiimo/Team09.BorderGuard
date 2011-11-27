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
    private Vaeosa vaeosa1;	  
    
    @ManyToOne		
    private Vaeosa vaeosa2;
	
		

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
	public Vaeosa getVaeosa1() {
		return vaeosa1;
	}
	public void setVaeosa1(Vaeosa vaeosa1) {
		this.vaeosa1 = vaeosa1;
	}
	public Vaeosa getVaeosa2() {
		return vaeosa2;
	}
	public void setVaeosa2(Vaeosa vaeosa2) {
		this.vaeosa2 = vaeosa2;
	}
}
