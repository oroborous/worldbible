package com.javapuppy.springmvc;


import com.javapuppy.springmvc.beans.NPC;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
    @RequestMapping("/")
    public String showHomePage() {
        return "index";
    }

    @RequestMapping("/characterView")
    public String showCharacterViewPage(Model model) {
        NPC npc = new NPC();
        model.addAttribute("viewNpc", npc);
        return "characterView";
    }

    @RequestMapping("/characterEdit")
    public String showCharacterEditPage(Model model) {
        NPC npc = new NPC();
        model.addAttribute("editNpc", npc);
        return "characterEdit";
    }

}
