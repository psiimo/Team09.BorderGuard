package itcollege.team09.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
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
public class VoimalikAlluvus {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull 
    @DateTimeFormat(style="M-")
    private Date alates;
    
    @NotNull
    @DateTimeFormat(style="M-")
    private Date kuni;
    
    @NotNull
    private String kommentaar;
    
    @NotNull
    @Size(max=32)
    private String avaja;
    
    @NotNull
    @DateTimeFormat(style="M-")
    private Date avatud;
    
    @NotNull
    @Size(max=32)
    private String muutja;
    
    @NotNull
    @DateTimeFormat(style="M-")
    private Date muudetud;
    
    @NotNull
    @Size(max=32)
    private String sulgeja;
    
    @NotNull
    @DateTimeFormat(style="M-")
    private Date suletud;
    
    private static final long serialVersionUID = 1L;

	@ManyToOne
	private AdminYksuseLiik ylemYksus;

	@ManyToOne
	private AdminYksuseLiik alamYksus;
	
	
	
	@PrePersist	
	public void recordCreated() {
		setAvaja("Mr X");
		setAvatud(new Date());	
	}
	
	@PreUpdate	
	public void recordModified() {		
		setMuutja("Mr X");		
		setMuudetud(new Date());	
	}	
	
	@PreRemove	
	public void preventRemove() {		
		throw new SecurityException("Eemaldamine keelatud!");	
	}
	
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getKommentaar() {
		return kommentaar;
	}
	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
	}
	public String getAvaja() {
		return avaja;
	}
	public void setAvaja(String avaja) {
		this.avaja = avaja;
	}
	public Date getAvatud() {
		return avatud;
	}
	public void setAvatud(Date avatud) {
		this.avatud = avatud;
	}
	public String getMuutja() {
		return muutja;
	}
	public void setMuutja(String muutja) {
		this.muutja = muutja;
	}
	public Date getMuudetud() {
		return muudetud;
	}
	public void setMuudetud(Date muudetud) {
		this.muudetud = muudetud;
	}
	public String getSulgeja() {
		return sulgeja;
	}
	public void setSulgeja(String sulgeja) {
		this.sulgeja = sulgeja;
	}
	public Date getSuletud() {
		return suletud;
	}
	public void setSuletud(Date suletud) {
		this.suletud = suletud;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
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
