package itcollege.team09.entities;

import javax.persistence.Entity;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import itcollege.team09.entities.AdminYksus;
import javax.persistence.ManyToOne;

@Entity
@RooToString
@RooEntity
public class AdminAlluvus extends Piirivalve {
	
    @ManyToOne
	private AdminYksus ylemAdminYksus;

	@ManyToOne
	private AdminYksus alamAdminYksus;

	
	public AdminAlluvus() {
		
	}	
	public AdminYksus getYlemAdminYksus() {
	    return ylemAdminYksus;
	}
	public void setYlemAdminYksus(AdminYksus param) {
	    this.ylemAdminYksus = param;
	}
	public AdminYksus getAlamAdminYksus() {
	    return alamAdminYksus;
	}
	public void setAlamAdminYksus(AdminYksus param) {
	    this.alamAdminYksus = param;
	}
}
