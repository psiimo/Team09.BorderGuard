package itcollege.team09.web;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import itcollege.team09.entities.AdminYksuseLiik;
import itcollege.team09.entities.Vaeosa;
import itcollege.team09.entities.VoimalikAlluvus;

import org.joda.time.format.DateTimeFormat;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RooWebScaffold(path = "adminyksuseliiks", formBackingObject = AdminYksuseLiik.class)
@RequestMapping("/adminyksuseliiks")
@Controller
public class AdminYksuseLiikController{
	
	//v6rdlemiseks eemalda-nupu ajutine nimi
  	String realEemalda ="";
  
//  	public static Date parseStr(String s){
//		DateFormat f = new SimpleDateFormat("M-");
//		try {
//			return f.parse(s);
//		} catch (ParseException e) {
//			return null;
//		}
//	}
//    
    
    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid AdminYksuseLiik liik, 
    		                    BindingResult bindingResult, Model uiModel, 
    		                    HttpServletRequest httpServletRequest) {
       
      	Collection<AdminYksuseLiik> coll = AdminYksuseLiik.findAllAdminYksuseLiiks();
      	//List<AdminYksuseLiik> coll = AdminYksuseLiik.findAllAdminYksuseLiiks();
      	boolean liikOnBaasis = false;
      	String liigiId="";
    	String nupunimi = searchButtonName(httpServletRequest);
//    	Date alates = parseStr(httpServletRequest.getParameterValues("alates")[0]);
//    	Date kuni = parseStr(httpServletRequest.getParameterValues("kuni")[0]);
//    	liik.setAlates(new Date());
//    	liik.setKuni(new Date());
    	AdminYksuseLiik lisatavAlluv = new AdminYksuseLiik();
    	
    	if (bindingResult.hasErrors()) {
            uiModel.addAttribute("riigi_admin_yksuse_liik", liik);
            addDateTimeFormatPatterns(uiModel);
            return "redirect:/adminyksuseliigiredaktor/index";
        }
    	
    	//kui siukse nimega liik on baasis olemas ja ta pole suletud, 
    	//siis seda uuesti ei salvestata,
    	//vaid minnakse kohe alluvaid valima
    	String nimetus = httpServletRequest.getParameterValues("nimetus")[0];
    	for(AdminYksuseLiik l : coll){ 
    		if(l.getNimetus().equalsIgnoreCase(nimetus)){
    			if(l.getSuletud().after(new Date())){
    			    uiModel.asMap().clear();
    			    liikOnBaasis = true;
    			    liigiId = l.getId().toString();
    			    lisatavAlluv = l;
    			    lisatavAlluv.recordCreated();
    			}
    		}
    	}	    	
    	
    	//see on uus liik, salvesta baasi
    	if(!liikOnBaasis){
            liik.recordCreated();
            uiModel.asMap().clear();
            liik.persist();
            liigiId = liik.getId().toString();
            lisatavAlluv = liik;
    	}            

     	//kui vajutati lisa-nuppu
    	if(nupunimi.equalsIgnoreCase("lisa")){      
             return "redirect:/voimalikalluvuses"+"?form&liigiID=" + liigiId; 
    	}//kui vajutati salvesta-nuppu
    	else if(nupunimi.equalsIgnoreCase("salvesta") || nupunimi.equalsIgnoreCase("salvesta2")){
    		
    		//kysi riikuestilt valitud ylemusyksuse(dropdown boksist) id baasis
    		String[] bossiIDlist = httpServletRequest.getParameterValues("ylemyksused");
    		String bossiID = bossiIDlist[0];
    		Long bossiLong = Long.valueOf(bossiID);
    		//suhte ylemliik
    		AdminYksuseLiik boss = AdminYksuseLiik.findAdminYksuseLiik(bossiLong);

    	////uus alluvusuhe
    		VoimalikAlluvus v6imalik = new VoimalikAlluvus();
    		//ma:a:ra ylemus
    		v6imalik.setYksuseliik(boss);
    		//ma:a:ra alluv
    		v6imalik.setAlamyksus(lisatavAlluv);
            //kommentaar
    		String komm = httpServletRequest.getParameterValues("kommentaar")[0];
    		v6imalik.setKommentaar(komm);
    		
    		//lisa baasi
    		//uiModel.asMap().clear();
    		v6imalik.persist();
    		
    		return "redirect:/adminyksuseliigiredaktor/index";
    	}//kui vajutati eemalda-nuppu
    	else if(nupunimi.equalsIgnoreCase("lisa")){      
            return "redirect:/voimalikalluvuses"+"?form&liigiID=" + liigiId; 
   	    }
    	else if(nupunimi.equalsIgnoreCase("eemalda")){
    	    //v6imaliku alluvuse id sulgemiseks
    		String vIdstr = this.realEemalda.substring("eemalda".length());
    		Long vId = Long.valueOf(vIdstr);
    		VoimalikAlluvus vaEemaldatav = VoimalikAlluvus.findVoimalikAlluvus(vId);
    		vaEemaldatav.setSuletud(new Date());
    		uiModel.asMap().clear();
    		vaEemaldatav.merge();
    		
    		return "redirect:/adminyksuseliigiredaktor/index?liigiID=" + liigiId;
    	}
    	else
    		return "redirect:/voimalikalluvuses";
        }        		                           
   
    //minu elupa:a:stja, keda ma kolm na:dalat otsisin:
    // http://stackoverflow.com/questions/2025280/have-multiple-submit-buttons-in-a-form-and-determine-which-was-pressed-in-a-cont
    String searchButtonName(final HttpServletRequest request) { 
        String buttonName = ""; 
        @SuppressWarnings("unchecked")
		Map<String, String[]> paramMap = request.getParameterMap(); 
        if (!paramMap.isEmpty()) { 
                for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
                        /* Search for the button name as given in 
                           the 'value' attribute for the input tag */
                        if ("Lisa".equals(entry.getValue()[0]) || 
                        	"Salvesta".equals(entry.getValue()[0]) ||
                        	"Salvesta2".equals(entry.getValue()[0])){ 
                                buttonName = entry.getKey(); 
                                break; 
                        }
                } 
                for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
                    /* Search for the button name as given in 
                       the 'value' attribute for the input tag */
                    if ("Eemalda".equals(entry.getValue()[0])){ 
                    	    this.realEemalda = entry.getKey();
                            buttonName = "eemalda"; 
                            break; 
                    }
            } 
        } 
        return buttonName; 
    } 
  
}
