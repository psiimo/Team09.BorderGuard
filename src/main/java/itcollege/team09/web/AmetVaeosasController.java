package itcollege.team09.web;

import itcollege.team09.entities.AmetVaeosas;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "ametvaeosases", formBackingObject = AmetVaeosas.class)
@RequestMapping("/ametvaeosases")
@Controller
public class AmetVaeosasController {
}
