package com.javapuppy.springmvc;

import com.javapuppy.springmvc.dao.NpcDAO;
import com.javapuppy.entity.Npc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/npc")
public class NpcController {
    // Inject the NPC DAO bean
    @Autowired
    private NpcDAO npcDAO;

    @RequestMapping("/list")
    public String listNpcs(Model theModel) {
        // Get NPCs from DAO
        List<Npc> npcList = npcDAO.getNpcs();

        // Add the list of NPCs to the model
        theModel.addAttribute("npcs", npcList);

        // Return the name of the view
        return "list-npcs";
    }
}
