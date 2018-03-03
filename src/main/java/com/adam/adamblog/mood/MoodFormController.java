package com.adam.adamblog.mood;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author adam
 * 创建于 2018-03-03 13:13.
 * 从MoodController中抽离出来单独处理Mood表单提交的控制器,避免重复提交ModelAttribute。
 */
@Controller
@RequestMapping(value = "/mood")
public class MoodFormController {

    @ModelAttribute
    public MoodForm getMoodForm() {
        MoodForm moodForm = new MoodForm();
        System.out.println(moodForm);
        return moodForm;
    }

    @RequestMapping(value = "/newmood", method = RequestMethod.GET)
    public String newMood() {
        return "mood/NewMood";
    }

}
