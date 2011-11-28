package itcollege.team09.entities;

import java.io.Serializable;
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
	private Vaeosa vaeosa_1;
    
    
        
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
	public Vaeosa getVaeosa_1() {
	    return vaeosa_1;
	}
	public void setVaeosa_1(Vaeosa param) {
	    this.vaeosa_1 = param;
	}
}
