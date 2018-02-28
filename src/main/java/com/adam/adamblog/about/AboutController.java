package com.adam.adamblog.about;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author adam
 * 创建于 2018-02-28 13:39.
 * 处理"关于"相关路径的控制器。
 */
@Controller
@RequestMapping(value = "/about")
public class AboutController {

    @RequestMapping(value = "")
    public String about() {
        return "redirect:/about/profile";
    }

    @RequestMapping(value = "/profile")
    public String viewProfile() {
        return "about/Profile";
    }

}
