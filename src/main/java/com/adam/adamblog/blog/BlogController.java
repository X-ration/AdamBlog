package com.adam.adamblog.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author adam
 * 创建于 2018-02-28 13:35.
 * 处理博文相关路径的控制器。
 */
@Controller
@RequestMapping(value = "/blog")
public class BlogController {

    private ArticleRepository repository;

    @Autowired
    public BlogController(ArticleRepository repository) {
        this.repository = repository;
        repository.init();
    }

    @RequestMapping(value = "")
    public ModelAndView viewArticles() {
        ModelAndView modelAndView = new ModelAndView("blog/ViewArticles");
        modelAndView.addObject("articles",repository.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/newarticle")
    public String newArticle() {
        return "blog/NewArticle";
    }

    @RequestMapping(value = "/article/{articleId}", method = RequestMethod.GET)
    public ModelAndView viewArticle(@PathVariable String articleId) {
        ModelAndView modelAndView = new ModelAndView("blog/ViewArticle");
        modelAndView.addObject("article",repository.findById(articleId));
        return modelAndView;
    }

}
