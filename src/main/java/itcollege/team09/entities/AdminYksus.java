package itcollege.team09.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import itcollege.team09.entities.AdminYksuseLiik;
import javax.persistence.ManyToOne;

@Entity
@RooToString
@RooEntity
public class AdminYksus extends Piirivalve implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
    
    
	@OneToMany(mappedBy = "adminYksus")
	private Collection<Vaeosa> vaeosad;

	@OneToMany(mappedBy = "adminyksus")
	private Collection<AdminAlluvus> ylemadminyksused;

	@OneToMany(mappedBy = "alamadminyksus")
	private Collection<AdminAlluvus> alamadminyksused;

	@ManyToOne
	private AdminYksuseLiik adminYksuseLiik;

	
	
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
	public Collection<Vaeosa> getVaeosad() {
	    return vaeosad;
	}
	public void setVaeosad(Collection<Vaeosa> param) {
	    this.vaeosad = param;
	}
	public Collection<AdminAlluvus> getYlemadminyksused() {
	    return ylemadminyksused;
	}
	public void setYlemadminyksused(Collection<AdminAlluvus> param) {
	    this.ylemadminyksused = param;
	}
	public Collection<AdminAlluvus> getAlamadminyksused() {
	    return alamadminyksused;
	}
	public void setAlamadminyksused(Collection<AdminAlluvus> param) {
	    this.alamadminyksused = param;
	}
	public AdminYksuseLiik getAdminYksuseLiik() {
	    return adminYksuseLiik;
	}
	public void setAdminYksuseLiik(AdminYksuseLiik param) {
	    this.adminYksuseLiik = param;
	}
}
