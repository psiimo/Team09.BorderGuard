package itcollege.team09.web;

import itcollege.team09.entities.AdminYksuseLiik;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "adminyksuseliiks", formBackingObject = AdminYksuseLiik.class)
@RequestMapping("/adminyksuseliiks")
@Controller
public class AdminYksuseLiikController {
}
