package com.javapuppy.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String showHomePage() {
        return "index";
    }

    @RequestMapping("/searchForm")
    public String showSearchForm() {
        return "searchForm";
    }

    @RequestMapping("/searchResults")
    public String showSearchResults() {
        return "searchResults";
    }

    @RequestMapping("/list")
    public String showList() {
        return "list";
    }
}
