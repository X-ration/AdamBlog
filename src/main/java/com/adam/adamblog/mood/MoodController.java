package com.adam.adamblog.mood;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.time.LocalDateTime;

/**
 * @author adam
 * 创建于 2018-02-28 13:29.
 * 处理心情相关路径的控制器。
 */
@Controller
@RequestMapping(value = "/mood")
public class MoodController {

    private MoodRepository repository;
    public static final Resource picturesDir = new FileSystemResource("./images/mood/");

    @Autowired
    public MoodController(MoodRepository repository) {
        this.repository = repository;
        this.repository.init();
    }

    @ModelAttribute
    public MoodForm getMoodForm() {
        MoodForm moodForm = new MoodForm();
        System.out.println(moodForm);
        return moodForm;
    }

    @RequestMapping(value = "")
    public ModelAndView viewMoods() {
        ModelAndView modelAndView = new ModelAndView("mood/ViewMoods");
        modelAndView.addObject("moods",repository.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/newmood", method = RequestMethod.GET)
    public String newMood() {
        return "mood/NewMood";
    }

    @RequestMapping(value = "/newmood", params = {"submitMood"}, method = RequestMethod.POST)
    public String publishMood(MoodForm moodForm) throws IOException {

        System.out.println(moodForm);
        Mood mood = new Mood(moodForm.getUserName(),moodForm.getContent(),
                moodForm.getHasImage(),"", moodForm.getHasLink(), moodForm.getLinkUrl(),
                moodForm.getLinkDescription(), LocalDateTime.now());
        repository.addMood(mood);
        System.out.println(mood.getImageUrl());
        return "redirect:";
    }

    @RequestMapping(value = "/newmood", params = {"submitMood_image"}, method = RequestMethod.POST)
    public String publishMood(MoodForm moodForm, @RequestParam MultipartFile chooseImage) throws IOException {
        //记录：MultipartFile参数的名称要与HTML的控件name属性值一致，否则会提示400 Bad Request, file not present
        //upload image
        String filename = chooseImage.getOriginalFilename();
        File tempFile = File.createTempFile("pic",getFileExtension(filename),picturesDir.getFile());
        try (InputStream in = chooseImage.getInputStream();
             OutputStream out = new FileOutputStream(tempFile)) {
            IOUtils.copy(in, out);
        }
        System.out.println(tempFile.getName());
        System.out.println(moodForm);
        Mood mood = new Mood(moodForm.getUserName(),moodForm.getContent(),
                moodForm.getHasImage(),tempFile.getName(), moodForm.getHasLink(),
                moodForm.getLinkUrl(),moodForm.getLinkDescription(), LocalDateTime.now());
        repository.addMood(mood);
        System.out.println(mood.getImageUrl());
        return "redirect:";
    }

    private static String getFileExtension(String name) {
        return name.substring(name.lastIndexOf("."));
    }

}
