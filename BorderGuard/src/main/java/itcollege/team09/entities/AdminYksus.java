package itcollege.team09.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

@Entity
@RooToString
@RooEntity
public class AdminYksus extends Piirivalve {
	
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
	private AdminYksuseLiik adminYksuseLiik;

	@OneToMany(mappedBy = "adminYksus")
	private Collection<Vaeosa> vaeosa;

	
	
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
	public AdminYksuseLiik getAdminYksuseLiik() {
	    return adminYksuseLiik;
	}
	public void setAdminYksuseLiik(AdminYksuseLiik param) {
	    this.adminYksuseLiik = param;
	}
	public Collection<Vaeosa> getVaeosa() {
	    return vaeosa;
	}
	public void setVaeosa(Collection<Vaeosa> param) {
	    this.vaeosa = param;
	}
}
