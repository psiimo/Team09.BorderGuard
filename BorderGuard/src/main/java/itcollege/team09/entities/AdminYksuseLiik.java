package itcollege.team09.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

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
    

/*

	@OneToMany(mappedBy="adminYksuseLiik1")	
	private Set<VaeosaAlluvus> adminYksuseAlluvuses1;	

	@OneToMany(mappedBy="adminYksuseLiik2")	
	private Set<VaeosaAlluvus> adminYksuseAlluvuses2;

	*/

	
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
	/*
	public Set<VaeosaAlluvus> getAdminYksuseAlluvuses1() {
		return adminYksuseAlluvuses1;
	}
	public void setAdminYksuseAlluvuses1(Set<VaeosaAlluvus> adminYksuseAlluvuses1) {
		this.adminYksuseAlluvuses1 = adminYksuseAlluvuses1;
	}
	public Set<VaeosaAlluvus> getAdminYksuseAlluvuses2() {
		return adminYksuseAlluvuses2;
	}
	public void setAdminYksuseAlluvuses2(Set<VaeosaAlluvus> adminYksuseAlluvuses2) {
		this.adminYksuseAlluvuses2 = adminYksuseAlluvuses2;
	}
	*/
}
