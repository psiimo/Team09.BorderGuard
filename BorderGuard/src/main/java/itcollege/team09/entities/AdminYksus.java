package itcollege.team09.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class AdminYksus {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @Size(max=10)
    private String kood;
    
    @NotNull
    @Size(max=100)
	private String nimetus;
	
	@NotNull
    private String kommentaar;
    
    @NotNull
    @DateTimeFormat(style="M-")
    private Date alates;
    
    @NotNull
    @DateTimeFormat(style="M-")
    private Date kuni;
    
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
	private AdminYksuseLiik adminYksuseLiik;

	@OneToMany(mappedBy = "adminYksus")
	private Collection<Vaeosa> vaeosa;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public String getKommentaar() {
		return kommentaar;
	}
	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
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
