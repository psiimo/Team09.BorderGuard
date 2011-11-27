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


@Entity
@RooToString
@RooEntity
public abstract class Piirivalve {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    	
	@Size(max=500)
	@NotNull
    private String kommentaar;
    
    @Size(max=32)
    @NotNull
    private String avaja;
    
    @NotNull
    @DateTimeFormat(style="M-")
    private Date avatud;
        
    @Size(max=32)
    @NotNull
    private String muutja;
    
    @NotNull
    @DateTimeFormat(style="M-")
    private Date muudetud;
        
    @Size(max=32)
    @NotNull
    private String sulgeja;
    
    @NotNull
    @DateTimeFormat(style="M-")
    private Date suletud;

        
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
		throw new SecurityException("Removing of bears is prohibited!");	
	}
}
