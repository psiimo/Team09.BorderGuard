package itcollege.team09.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import itcollege.team09.entities.*;

@RequestMapping("/testdata/**")
@Controller
public class TestDataController {

    @RequestMapping
    public void get(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }

    @RequestMapping(method = RequestMethod.POST, value = "{id}")
    public void post(@PathVariable Long id, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }

    @RequestMapping
    public String index() {
    	
    	if(Vaeosa.countVaeosas() <=0)
    	{
    		Vaeosa v = new Vaeosa();
    		v.setNimetus("Politsei");
    		v.setKood("POL123");
    		v.setAlates(new Date());
    		v.setKuni(new Date());
    		v.setKommentaar("Kommentaar");    		
    		v.persist();
    		
    		Vaeosa v2 = new Vaeosa();
    		v2.setNimetus("Piirivalve");
    		v2.setKood("PIIR123");
    		v2.setAlates(new Date());
    		v2.setKuni(new Date());
    		v2.setKommentaar("Kommentaar");    		
    		v2.persist();
    	}
    	
    	if(AdminYksuseLiik.countAdminYksuseLiiks() <=0)
    	{
    		AdminYksuseLiik al = new AdminYksuseLiik();
    		al.setNimetus("Maakond");
    		al.setKood("EE123");
    		al.setKommentaar("Kommentaar");
    		al.setAlates(new Date());
    		al.setKuni(new Date());  		
    		al.persist();
    		
    		AdminYksuseLiik al2 = new AdminYksuseLiik();
    		al2.setNimetus("Vald");
    		al2.setKood("EE125");
    		al2.setKommentaar("Kommentaar");
    		al2.setAlates(new Date());
    		al2.setKuni(new Date());  		
    		al2.persist();
    	}
    	
    	if(AdminYksus.countAdminYksuses() <=0)
    	{
    		AdminYksus ay = new AdminYksus();
    		ay.setNimetus("Harjumaa");
    		ay.setKood("EE98712");
    		ay.setKommentaar("Kommentaar");
    		ay.setAlates(new Date());
    		ay.setKuni(new Date());  		
    		ay.persist();
    		
    		AdminYksus ay2 = new AdminYksus();
    		ay2.setNimetus("Saue");
    		ay2.setKood("EE45874");
    		ay2.setKommentaar("Kommentaar");
    		ay2.setAlates(new Date());
    		ay2.setKuni(new Date());  		
    		ay2.persist();
    	}

        return "testdata/index";
    }
}
