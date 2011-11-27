package itcollege.team09.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import itcollege.team09.entities.VoimalikAlluvus;
import java.util.Collection;

@Entity
@RooToString
@RooEntity
public class AdminYksuseLiik extends Piirivalve {

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

	@OneToMany(mappedBy = "adminYksuseLiik")
	private Collection<VoimalikAlluvus> voimalikAlluvus;

	@OneToMany(mappedBy = "adminYksuseLiik_1")
	private Collection<VoimalikAlluvus> voimalikAlluvus_1;
    

	
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
	public Collection<VoimalikAlluvus> getVoimalikAlluvus() {
	    return voimalikAlluvus;
	}
	public void setVoimalikAlluvus(Collection<VoimalikAlluvus> param) {
	    this.voimalikAlluvus = param;
	}
	public Collection<VoimalikAlluvus> getVoimalikAlluvus_1() {
	    return voimalikAlluvus_1;
	}
	public void setVoimalikAlluvus_1(Collection<VoimalikAlluvus> param) {
	    this.voimalikAlluvus_1 = param;
	}
}
