package itcollege.team09.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import itcollege.team09.entities.Vaeosa;
import itcollege.team09.helpers.Helper;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RooWebScaffold(path = "vaeosas", formBackingObject = Vaeosa.class)
@RequestMapping("/vaeosas")
@Controller
public class VaeosaController {
	
		
    @RequestMapping(method = RequestMethod.PUT)
    public String update(@Valid Vaeosa vaeosa, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("vaeosa", vaeosa);
            addDateTimeFormatPatterns(uiModel);
            return "vaeosas/update";
        }
        uiModel.asMap().clear();
        vaeosa.merge();
        return "redirect:/vaeosas/" + encodeUrlPathSegment(vaeosa.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("vaeosa", Vaeosa.findVaeosa(id));
        uiModel.addAttribute("alamvaeosad", Helper.getVaeosaAlluvadVaeosad(Vaeosa.findVaeosa(id)));
        addDateTimeFormatPatterns(uiModel);
        return "vaeosas/update";
    }  
    
    @RequestMapping(value = "/{id}", params = "popup", method = RequestMethod.GET)
    public String updatePopup(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("vaeosa", Vaeosa.findVaeosa(id));
        addDateTimeFormatPatterns(uiModel);
        return "vaeosas/popup";
    }     
}
