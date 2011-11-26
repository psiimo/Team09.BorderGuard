package itcollege.team09.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import itcollege.team09.entities.VaeosaAlluvus;
import itcollege.team09.entities.AmetVaeosas;

@Entity
@RooToString
@RooEntity
public class Vaeosa extends Piirivalve {
	
    @NotNull
    @Size(max=10)
    private String kood;
    
    @NotNull
    @Size(max=100)
    private String nimetus;
    
    @NotNull
    @DateTimeFormat(style="M-")
    private Date alates;
    
    @NotNull
    @DateTimeFormat(style="M-")
    private Date kuni;
    
	@ManyToOne
	private AdminYksus adminYksus;

	@OneToMany(mappedBy = "alamVaeosa")
	private Collection<VaeosaAlluvus> vaeosaAlluvused;

	@OneToMany(mappedBy = "vaeosa")
	private Collection<AmetVaeosas> ametidVaeosas;
	
	
	
	public String getKood() {
		return kood;
	}
	public void setKood(String kood) {
		this.kood = kood;
	}
	public String getNimetus() {
		return nimetus;
	}
	public void setNimetus(String nimetus) {
		this.nimetus = nimetus;
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
	public AdminYksus getAdminYksus() {
	    return adminYksus;
	}
	public void setAdminYksus(AdminYksus param) {
	    this.adminYksus = param;
	}
	public Collection<VaeosaAlluvus> getVaeosaAlluvused() {
	    return vaeosaAlluvused;
	}
	public void setVaeosaAlluvused(Collection<VaeosaAlluvus> param) {
	    this.vaeosaAlluvused = param;
	}
	public Collection<AmetVaeosas> getAmetidVaeosas() {
	    return ametidVaeosas;
	}
	public void setAmetidVaeosas(Collection<AmetVaeosas> param) {
	    this.ametidVaeosas = param;
	}
}
