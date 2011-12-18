package itcollege.team09.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import itcollege.team09.entities.AdminYksus;
import itcollege.team09.entities.AdminYksuseLiik;
import itcollege.team09.helpers.Helper;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RooWebScaffold(path = "adminyksuses", formBackingObject = AdminYksus.class)
@RequestMapping("/adminyksuses")
@Controller
public class AdminYksusController {
	
/*    @RequestMapping(method = RequestMethod.PUT)
    public String update(@Valid AdminYksus adminYksus, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("adminYksus", adminYksus);
            addDateTimeFormatPatterns(uiModel);
            return "adminyksuses/update";
        }
        uiModel.asMap().clear();
        adminYksus.merge();
        return "redirect:/adminyksuses/" + encodeUrlPathSegment(adminYksus.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("adminYksus", AdminYksus.findAdminYksus(id));
        uiModel.addAttribute("alluvadAdminYksused", Helper.getAdminYksuseAlluvad(AdminYksus.findAdminYksus(id)));
        addDateTimeFormatPatterns(uiModel);
        return "adminyksuses/update";
    }*/
}
