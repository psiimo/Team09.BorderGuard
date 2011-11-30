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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


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
    protected String avaja;    
    @DateTimeFormat(style="M-")
    protected Date avatud;        
    @Size(max=32)
    protected String muutja;    
    @DateTimeFormat(style="M-")
    protected Date muudetud;        
    @Size(max=32)
    protected String sulgeja;    
    @DateTimeFormat(style="M-")
    protected Date suletud;

        
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
	
	/*
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
	*/
	
	
	@PrePersist	
	public void recordCreated() {	
		String user = GetUser();
		Long date = GetDate();
		
		this.avaja = user;
		this.muutja = user;
		this.sulgeja = user;
		
		this.avatud = new Date(date);
		this.muudetud = new Date(date);
		this.suletud = new Date(9999999999999L);		
	}
	
	@PreUpdate	
	public void recordModified() {	
		this.muutja = GetUser();
		this.muudetud = new Date(GetDate());	
	}	
	
	@PreRemove	
	public void preventRemove() {	
		throw new SecurityException("Removing of bears is prohibited!");	
	}
	
	private String GetUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();
	}	
	
	private Long GetDate() {
		Date now = new Date();
		return now.getTime();
	}
}
