package itcollege.team09.web;

import itcollege.team09.entities.AdminYksus;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "adminyksuses", formBackingObject = AdminYksus.class)
@RequestMapping("/adminyksuses")
@Controller
public class AdminYksusController {
}
