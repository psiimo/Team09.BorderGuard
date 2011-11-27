package itcollege.team09.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

@Entity
@RooToString
@RooEntity
public class AmetVaeosas extends Piirivalve {
	
	private String amet;
	
	 @NotNull
	 @DateTimeFormat(style="M-")
	 private Date alates;
	    
	 @NotNull
	 @DateTimeFormat(style="M-")
	 private Date kuni;

	
	 
	public String getAmet() {
		return amet;
	}
	public void setAmet(String amet) {
		this.amet = amet;
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
}
