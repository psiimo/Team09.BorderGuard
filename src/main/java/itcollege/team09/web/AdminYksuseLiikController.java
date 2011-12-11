package itcollege.team09.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import itcollege.team09.entities.AdminYksuseLiik;
import itcollege.team09.entities.Vaeosa;
import itcollege.team09.helpers.Helper;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RooWebScaffold(path = "adminyksuseliiks", formBackingObject = AdminYksuseLiik.class)
@RequestMapping("/adminyksuseliiks")
@Controller
public class AdminYksuseLiikController {
	
    @RequestMapping(method = RequestMethod.PUT)
    public String update(@Valid AdminYksuseLiik adminYksuseLiik, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("adminYksuseLiik", adminYksuseLiik);
            addDateTimeFormatPatterns(uiModel);
            return "adminyksuseliiks/update";
        }
        uiModel.asMap().clear();
        adminYksuseLiik.merge();
        return "redirect:/adminyksuseliiks/" + encodeUrlPathSegment(adminYksuseLiik.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("adminYksuseLiik", AdminYksuseLiik.findAdminYksuseLiik(id));
        uiModel.addAttribute("voimalikudAlluvused", Helper.getAdminYksuseLiigiAlluvad(AdminYksuseLiik.findAdminYksuseLiik(id)));
        uiModel.addAttribute("voimalikudYlemad", Helper.getAdminYksuseLiigiYlemad(AdminYksuseLiik.findAdminYksuseLiik(id)));
        addDateTimeFormatPatterns(uiModel);
        return "adminyksuseliiks/update";
    }
}
