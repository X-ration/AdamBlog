package com.adam.adamblog.blog;

import com.adam.adamblog.util.StringUtil;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.plaf.SeparatorUI;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @author adam
 * 创建于 2018-02-28 13:35.
 * 处理博文相关路径的控制器。
 */
@Controller
@RequestMapping(value = "/blog")
public class BlogController {

    private ArticleRepository repository;
    private static final Resource picturesDir = new FileSystemResource("/home/adam/document/images/blog/article/");

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

    @ModelAttribute
    public ArticleForm getArticleFormObject() {
        return new ArticleForm();
    }

    @RequestMapping(value = "/newarticle", method = RequestMethod.GET)
    public String newArticle() {
        return "blog/NewArticle";
    }

    @RequestMapping(value = "/newarticle", params = "submitArticle", method = RequestMethod.POST)
    public String newArticle(ArticleForm articleForm) {
        System.out.println(articleForm.getContentParagraphs());
        Article article = new Article(articleForm.getAuthor(),articleForm.getTitle(),
                articleForm.getArticleAbstract(),articleForm.getContentParagraphs(),
                articleForm.getHasImage(),"",
                articleForm.getHasLink(),articleForm.getLinkUrl(), StringUtil.getOrCreate(articleForm.getLinkDescription(),"Additional Link"));
        repository.addArticleNow(article);
        return "redirect:";
    }

    @RequestMapping(value = "/newarticle", params = "submitArticle_image", method = RequestMethod.POST)
    public String newArticle(ArticleForm articleForm, @RequestParam MultipartFile chooseImage) throws IOException{
        String filename = chooseImage.getOriginalFilename();
        File tempFile = File.createTempFile("pic",StringUtil.getFileExtension(filename),picturesDir.getFile());
        try (InputStream in = chooseImage.getInputStream();
             OutputStream out = new FileOutputStream(tempFile)) {
            IOUtils.copy(in, out);
        }
        System.out.println(articleForm.getContentParagraphs());
        Article article = new Article(articleForm.getAuthor(),articleForm.getTitle(),
                articleForm.getArticleAbstract(),articleForm.getContentParagraphs(),
                articleForm.getHasImage(),tempFile.getName(),
                articleForm.getHasLink(),articleForm.getLinkUrl(), StringUtil.getOrCreate(articleForm.getLinkDescription(),"Additional Link"));
        repository.addArticleNow(article);
        return "redirect:";
    }

    @RequestMapping(value = "/article/{articleId}", method = RequestMethod.GET)
    public ModelAndView viewArticle(@PathVariable String articleId) {
        ModelAndView modelAndView = new ModelAndView("blog/ViewArticle");
        modelAndView.addObject("article",repository.findById(articleId));
        return modelAndView;
    }

}
