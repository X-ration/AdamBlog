package com.adam.adamblog.mood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author adam
 * 创建于 2018-02-28 13:29.
 * 处理心情相关路径的控制器。
 */
@Controller
@RequestMapping(value = "/mood")
public class MoodController {

    private MoodRepository repository;

    @Autowired
    public MoodController(MoodRepository repository) {
        this.repository = repository;
        this.repository.init();
    }

    @RequestMapping(value = "")
    public ModelAndView viewMoods() {
        ModelAndView modelAndView = new ModelAndView("mood/ViewMoods");
        modelAndView.addObject("moods",repository.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/newmood")
    public String newMood() {
        return "mood/NewMood";
    }

}
