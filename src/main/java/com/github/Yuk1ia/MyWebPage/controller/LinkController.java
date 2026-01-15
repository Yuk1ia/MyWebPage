package com.github.Yuk1ia.MyWebPage.controller;
import com.github.Yuk1ia.MyWebPage.service.LinkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.github.Yuk1ia.MyWebPage.entity.Link;
import java.util.Arrays;

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

    // 1.Show all Links
    @GetMapping("/admin/links")
    public String adminListLinks(Model model) {
        model.addAttribute("links", linkService.findAllLinks());
        return "admin/links/list";
    }

    // 2. Add new link
    @GetMapping("/admin/links/new")
    public String showCreateForm(Model model) {
        model.addAttribute("link", new Link());
        model.addAttribute("categories", Arrays.asList("工具", "学习", "娱乐", "社交", "其他"));
        return "admin/links/form";
    }

    // 3. Handle add new link request
    @PostMapping("/admin/links")
    public String createLink(@ModelAttribute Link link, RedirectAttributes redirectAttributes) {
        Link savedLink = linkService.save(link);
        redirectAttributes.addFlashAttribute("message", "链接 '" + savedLink.getName() + "' 创建成功！");
        return "redirect:/admin/links";
    }

    // 4. Edit Link
    @GetMapping("/admin/links/{id}/edit")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        // orElseThrow是更安全的做法，这里简化为orElse(null)
        Link link = linkService.findById(id).orElse(null);
        if (link == null) {

            return "redirect:/admin/links";
        }
        model.addAttribute("link", link);
        model.addAttribute("categories", Arrays.asList("工具", "学习", "娱乐", "社交", "其他"));
        return "admin/links/form";
    }

    // 5. Handle Edit Link request
    @PostMapping("/admin/links/{id}")
    public String updateLink(@PathVariable("id") Long id,
                             @ModelAttribute Link link,
                             RedirectAttributes redirectAttributes) {
        link.setId(id); // 确保ID是表单提交的链接ID
        Link updatedLink = linkService.save(link);
        redirectAttributes.addFlashAttribute("message", "链接 '" + updatedLink.getName() + "' 更新成功！");
        return "redirect:/admin/links";
    }

    // 6. Handle Delete link request
    @GetMapping("/admin/links/{id}/delete")
    public String deleteLink(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        linkService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "链接删除成功！");
        return "redirect:/admin/links";
    }

}