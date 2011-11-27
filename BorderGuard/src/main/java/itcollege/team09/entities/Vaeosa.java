package itcollege.team09.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import itcollege.team09.entities.VaeosaAlluvus;

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

	@OneToMany(mappedBy="vaeosa1")	
	private Set<VaeosaAlluvus> vaeosaAlluvuses1;	
		
	@OneToMany(mappedBy="vaeosa2")	
	private Set<VaeosaAlluvus> vaeosaAlluvuses2;
	
	
	
	
	
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
	public Set<VaeosaAlluvus> getVaeosaAlluvuses1() {
		return vaeosaAlluvuses1;
	}
	public void setVaeosaAlluvuses1(Set<VaeosaAlluvus> vaeosaAlluvuses1) {
		this.vaeosaAlluvuses1 = vaeosaAlluvuses1;
	}
	public Set<VaeosaAlluvus> getVaeosaAlluvuses2() {
		return vaeosaAlluvuses2;
	}
	public void setVaeosaAlluvuses2(Set<VaeosaAlluvus> vaeosaAlluvuses2) {
		this.vaeosaAlluvuses2 = vaeosaAlluvuses2;
	}
}
