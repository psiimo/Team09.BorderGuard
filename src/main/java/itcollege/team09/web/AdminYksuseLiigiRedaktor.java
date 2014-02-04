package itcollege.team09.web;

import itcollege.team09.entities.AdminYksuseLiik;
import itcollege.team09.entities.VoimalikAlluvus;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.format.DateTimeFormat;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

@RequestMapping("/adminyksuseliigiredaktor/**")
@Controller
public class AdminYksuseLiigiRedaktor {

	//kui pealehel ollaks esimest korda
    @RequestMapping
    public String index(@RequestParam(required = false) Long liigiID,Model uiModel) {
    	//kui siia formi tullakse esimest korda
       createForm(liigiID,uiModel);
        return "adminyksuseliigiredaktor/index";
    } 
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String createForm(@ModelAttribute("liigiID") Long liigiID, Model uiModel) {
    	                                    //"liigiID" saadab siia 
    	                                    //Voimalik_alluvusController
    	                                    //meetodist 'public String create(..)'
    	
    	
    	if(liigiID != null){//kui siia formi tullakse alluvaid loomast
    		//na:ita samu andmeid uuesti
    		
    		AdminYksuseLiik alluvategaLiik = AdminYksuseLiik.findAdminYksuseLiik(liigiID);
    		AdminYksuseLiik u = new AdminYksuseLiik();
     		u = alluvategaLiik; //see ta:idab textboxid endiste andmetega
    		
    		uiModel.addAttribute("tagasiLiik", u);
    		uiModel.addAttribute("alluvategaLiik", alluvategaLiik);
    		
    		//seda ion vaja <c:out..>va:a:rtuseks, et kuvada olemasolevaid alluvusi
    		AdminYksuseLiik valitudLiik = AdminYksuseLiik.findAdminYksuseLiik(liigiID);
    		uiModel.addAttribute("valitudLiik", valitudLiik);
    		//uiModel.addAttribute("voimalikudAlluvad", annaV6imalikualluvuseList(valitudLiik));
    		
    	}
        uiModel.addAttribute("riigi_admin_yksuse_liik", new AdminYksuseLiik());
        addDateTimeFormatPatterns(uiModel);
        return "adminyksuseliigiredaktor/index";
    }
    
 
    void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("riigi_admin_yksuse_liik_avatud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("riigi_admin_yksuse_liik_muudetud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("riigi_admin_yksuse_liik_suletud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("riigi_admin_yksuse_liik_alates_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("riigi_admin_yksuse_liik_kuni_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }
    
    String encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        }
        catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }

    //seda kasutatakse Allub: va:lja dropboxi jaoks
    @ModelAttribute("riigi_admin_yksuse_liiks_piiks")
    public Collection<AdminYksuseLiik> populateRiigi_admin_yksuse_liiks() {
        return AdminYksuseLiik.findAllAdminYksuseLiiks();
    }
    
    public List<VoimalikAlluvus> annaV6imalikualluvuseList(AdminYksuseLiik ylemLiik){
    	VoimalikAlluvus v6i = null;
    	List<VoimalikAlluvus> vaList = new ArrayList<VoimalikAlluvus>();
		for(VoimalikAlluvus va : VoimalikAlluvus.findAllVoimalikAlluvuses()){
    		if(va.getYksuseliik()== ylemLiik){
    			v6i = va;
    			vaList.add(v6i);
    		}
    	}
		return vaList;
    }
/*  //admin.liigi olemasolevad alluvad
    //@ModelAttribute("JubaOlemasOlevadAlluvad")
    List<AdminYksuseLiik> annaOlOlAlluvad(AdminYksuseLiik valitudLiik ){
    	OlemasOlevadAlluvad ooaall = OlemasOlevadAlluvad.findAlluvadForAdminLiik(valitudLiik);
    	List<AdminYksuseLiik> ololAlluvad = ooaall.getLiikItems();
    	return ololAlluvad;
    }*/
}
