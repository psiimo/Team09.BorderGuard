package itcollege.team09.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import itcollege.team09.entities.AdminAlluvus;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RooWebScaffold(path = "adminalluvuses", formBackingObject = AdminAlluvus.class)
@RequestMapping("/adminalluvuses")
@Controller
public class AdminAlluvusController {
	
    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid AdminAlluvus adminAlluvus, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
    	if(adminAlluvus.getAlates().after(adminAlluvus.getKuni())) {
            uiModel.addAttribute("adminAlluvus", adminAlluvus);
            addDateTimeFormatPatterns(uiModel);
            bindingResult.addError(new FieldError("adminAlluvus", "kuni", "Begin date must not be later than end date"));
            return "adminalluvuses/create";
    	}
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("adminAlluvus", adminAlluvus);
            addDateTimeFormatPatterns(uiModel);
            return "adminalluvuses/create";
        }
        uiModel.asMap().clear();
        adminAlluvus.persist();
        return "redirect:/adminalluvuses/" + encodeUrlPathSegment(adminAlluvus.getId().toString(), httpServletRequest);
    }
    
}
