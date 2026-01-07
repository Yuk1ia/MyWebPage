package com.github.Yuk1ia.MyWebPage.controller;
import com.github.Yuk1ia.MyWebPage.service.LinkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class LinkController {
    private final LinkService linkService;
    // 构造器
    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("/links")
    public String Listlinks(Model model){
        model.addAttribute("links", linkService.findAllLinks());
        return "links/list";
    }

}