package itcollege.team09.web;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import itcollege.team09.entities.AdminYksuseLiik;
import itcollege.team09.entities.VoimalikAlluvus;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RooWebScaffold(path = "voimalikalluvuses", formBackingObject = VoimalikAlluvus.class)
@RequestMapping("/voimalikalluvuses")
@Controller
public class VoimalikAlluvusController {

	//see controller peab loomiseks saama ylemusyksuse liigi id,
	//et see liik oleks ylemusena automaatselt ma:a:ratud
    @RequestMapping(params = "form", method = RequestMethod.GET)
                            //liigiID saadab siia klass 
                            //Riigi_admin_yksuse_liikController create-meetodist
    public String createForm(@RequestParam(required = false) Long liigiID, Model uiModel) {
    	VoimalikAlluvus va = new VoimalikAlluvus();
    	if(liigiID != null){
    		va.setYksuseliik(AdminYksuseLiik.findAdminYksuseLiik(liigiID));
    		//seda ion vaja <c:out..>va:a:rtuseks, et kuvada olemasolevaid alluvusi
    		AdminYksuseLiik valitudLiik = AdminYksuseLiik.findAdminYksuseLiik(liigiID);
    		uiModel.addAttribute("valitudLiik", valitudLiik);
    		//alluvate kuvamiseks redaktoris
            uiModel.addAttribute("voimalikudAlluvad", annaV6imalikualluvuseList(valitudLiik));
    		//uiModel.addAttribute("alluvadAdminYksysed", annaOlOlAlluvad(valitudLiik));
    	}
    	uiModel.addAttribute("voimalik_alluvus", va);
        addDateTimeFormatPatterns(uiModel);
        return "voimalikalluvuses/create";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid VoimalikAlluvus voimalik_alluvus, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("voimalik_alluvus", voimalik_alluvus);
            addDateTimeFormatPatterns(uiModel);
            return "voimalikalluvuses/create";
        }
        uiModel.asMap().clear();
        voimalik_alluvus.persist();
        Long vaIDEE = voimalik_alluvus.getYksuseliik().getId();
        //seda attributi kasutada saab 
        //klassi AdminYksuseLiigiRedaktor meetodi createForm parameetrina!!!
        uiModel.addAttribute("liigiID", vaIDEE);                                       
        //liigiID ilmub aadressireale 
        return "redirect:/adminyksuseliigiredaktor/index?liigiID=" + encodeUrlPathSegment(voimalik_alluvus.getYksuseliik().getId().toString(), httpServletRequest);
        	
    }
    
/*    
    //admin.liigi olemasolevad alluvad
    //@ModelAttribute("JubaOlemasOlevadAlluvad")
    List<Riigi_admin_yksuse_liik > annaOlOlAlluvad(Riigi_admin_yksuse_liik valitudLiik ){
    	OlemasOlevadAlluvad ooaall = OlemasOlevadAlluvad.findAlluvadForAdminLiik(valitudLiik);
    	List<Riigi_admin_yksuse_liik> ololAlluvad = ooaall.getLiikItems();
    	return ololAlluvad;
    }
 */   
    public List<VoimalikAlluvus> annaV6imalikualluvuseList(AdminYksuseLiik ylemLiik){
    	VoimalikAlluvus v6i = null;
    	List<VoimalikAlluvus> vaList = new ArrayList<VoimalikAlluvus>();
		for(VoimalikAlluvus va : VoimalikAlluvus.findAllVoimalikAlluvuses()){
    		if(va.getYksuseliik()== ylemLiik){
    			//Ć¤ra nĆ¤ita suletud alluvaid
    			//eilse kuup saamine
    			Calendar rightNow = Calendar.getInstance();
    	     	rightNow.add(Calendar.DATE, +1);
    	     	Date homme = rightNow.getTime();
    			if(!(va.getSuletud().before(homme))){
    			   v6i = va;
    			   vaList.add(v6i);
    			}
    		}
    	}
		return vaList;
    }
    
}
