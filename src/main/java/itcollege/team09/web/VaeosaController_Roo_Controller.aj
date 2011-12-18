// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package itcollege.team09.web;

import itcollege.team09.entities.AdminYksus;
import itcollege.team09.entities.Vaeosa;
import itcollege.team09.entities.VaeosaAlluvus;
import java.io.UnsupportedEncodingException;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.joda.time.format.DateTimeFormat;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect VaeosaController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST)
    public String VaeosaController.create(@Valid Vaeosa vaeosa, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("vaeosa", vaeosa);
            addDateTimeFormatPatterns(uiModel);
            return "vaeosas/create";
        }
        uiModel.asMap().clear();
        vaeosa.persist();
        return "redirect:/vaeosas/" + encodeUrlPathSegment(vaeosa.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String VaeosaController.createForm(Model uiModel) {
        uiModel.addAttribute("vaeosa", new Vaeosa());
        addDateTimeFormatPatterns(uiModel);
        return "vaeosas/create";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String VaeosaController.show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("vaeosa", Vaeosa.findVaeosa(id));
        uiModel.addAttribute("itemId", id);
        return "vaeosas/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String VaeosaController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            uiModel.addAttribute("vaeosas", Vaeosa.findVaeosaEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) Vaeosa.countVaeosas() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("vaeosas", Vaeosa.findAllVaeosas());
        }
        addDateTimeFormatPatterns(uiModel);
        return "vaeosas/list";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String VaeosaController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Vaeosa.findVaeosa(id).remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/vaeosas";
    }
    
    @ModelAttribute("adminyksuses")
    public Collection<AdminYksus> VaeosaController.populateAdminYksuses() {
        return AdminYksus.findAllAdminYksuses();
    }
    
    @ModelAttribute("vaeosas")
    public Collection<Vaeosa> VaeosaController.populateVaeosas() {
        return Vaeosa.findAllVaeosas();
    }
    
    @ModelAttribute("vaeosaalluvuses")
    public Collection<VaeosaAlluvus> VaeosaController.populateVaeosaAlluvuses() {
        return VaeosaAlluvus.findAllVaeosaAlluvuses();
    }
    
    void VaeosaController.addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("vaeosa_suletud_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("vaeosa_alates_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("vaeosa_kuni_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }
    
    String VaeosaController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
    
}
