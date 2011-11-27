package itcollege.team09.entities;

import javax.persistence.Entity;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import itcollege.team09.entities.AdminYksus;
import javax.persistence.ManyToOne;

@Entity
@RooToString
@RooEntity
public class AdminAlluvus extends Piirivalve  {

	@ManyToOne
	private AdminYksus adminYksus;
	@ManyToOne
	private AdminYksus adminYksus_1;
	
	

	public AdminYksus getAdminYksus() {
	    return adminYksus;
	}
	public void setAdminYksus(AdminYksus param) {
	    this.adminYksus = param;
	}
	public AdminYksus getAdminYksus_1() {
	    return adminYksus_1;
	}
	public void setAdminYksus_1(AdminYksus param) {
	    this.adminYksus_1 = param;
	}
}
