// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package itcollege.team09.web;

import itcollege.team09.entities.AdminAlluvus;
import itcollege.team09.entities.AdminYksus;
import java.io.UnsupportedEncodingException;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import org.joda.time.format.DateTimeFormat;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect AdminAlluvusController_Roo_Controller {
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String AdminAlluvusController.createForm(Model uiModel) {
        uiModel.addAttribute("adminAlluvus", new AdminAlluvus());
        addDateTimeFormatPatterns(uiModel);
        return "adminalluvuses/create";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String AdminAlluvusController.show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("adminalluvus", AdminAlluvus.findAdminAlluvus(id));
        uiModel.addAttribute("itemId", id);
        return "adminalluvuses/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String AdminAlluvusController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            uiModel.addAttribute("adminalluvuses", AdminAlluvus.findAdminAlluvusEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) AdminAlluvus.countAdminAlluvuses() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("adminalluvuses", AdminAlluvus.findAllAdminAlluvuses());
        }
        addDateTimeFormatPatterns(uiModel);
        return "adminalluvuses/list";
    }
    
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String AdminAlluvusController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("adminAlluvus", AdminAlluvus.findAdminAlluvus(id));
        addDateTimeFormatPatterns(uiModel);
        return "adminalluvuses/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String AdminAlluvusController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        AdminAlluvus.findAdminAlluvus(id).remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/adminalluvuses";
    }
    
    @ModelAttribute("adminalluvuses")
    public Collection<AdminAlluvus> AdminAlluvusController.populateAdminAlluvuses() {
        return AdminAlluvus.findAllAdminAlluvuses();
    }
    
    @ModelAttribute("adminyksuses")
    public Collection<AdminYksus> AdminAlluvusController.populateAdminYksuses() {
        return AdminYksus.findAllAdminYksuses();
    }
    
    void AdminAlluvusController.addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("adminAlluvus_alates_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("adminAlluvus_kuni_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }
    
    String AdminAlluvusController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
