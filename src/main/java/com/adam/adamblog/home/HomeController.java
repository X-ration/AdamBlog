package com.adam.adamblog.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author adam
 * 创建于 2018-02-23 20:17.
 * 处理根路径的控制器。
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String gotoIndexPage() {
        return "index";
    }

}
