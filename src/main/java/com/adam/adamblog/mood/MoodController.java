package com.adam.adamblog.mood;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author adam
 * 创建于 2018-02-28 13:29.
 * 处理心情相关路径的控制器。
 */
@Controller
@RequestMapping(value = "/mood")
public class MoodController {

    @RequestMapping(value = "")
    public String viewMoods() {
        return "mood/ViewMoods";
    }

    @RequestMapping(value = "/newmood")
    public String newMood() {
        return "mood/NewMood";
    }

}
