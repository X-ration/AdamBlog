package com.adam.adamblog.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author adam
 * 创建于 2018-02-28 13:35.
 * 处理博文相关路径的控制器。
 */
@Controller
@RequestMapping(value = "/blog")
public class BlogController {

    @RequestMapping(value = "")
    public String viewArticles() {
        return "blog/ViewArticles";
    }

    @RequestMapping(value = "/newarticle")
    public String newArticle() {
        return "blog/NewArticle";
    }

}
