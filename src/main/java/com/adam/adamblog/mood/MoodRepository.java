package com.adam.adamblog.mood;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author adam
 * 创建于 2018-02-28 14:34.
 * 心情仓库。
 */
@Repository
public class MoodRepository {

    private final Map<String,Mood> moodMap = new ConcurrentHashMap<>();

    public void init() {
        addMood(new Mood("Frank Adam","Adam's Blog项目正式启动","基于Spring Boot和Material Design的个人博客站Adam's Blog项目正式启动。",
                true, "/images/nature.jpg",
                true, "/", "Adam's Blog"));
        addMood(new Mood("Google Inc.","发现Microsoft Edge重大安全漏洞", "我们的研究团队最近刚刚发现Microsoft Edge浏览器中存在的一项重要安全漏洞，目前微软方面尚未给出解决方案，我们推荐更快更安全的全新Chrome浏览器。",
                false, "",
                false, "", ""));
        addMood(new Mood("Nadella","再见，Windows Phone！", "今天，我们怀着无比沉痛的心情，向各位热爱微软手机业务的同志们郑重宣告，因发展停滞，Windows Phone业务正式停止。",
                true, "/images/default_mood.jpg",
                false, "", ""));
        System.out.println("Mood repository init complete");
    }

    public Mood addMood(Mood newMood) {
        String uniqueId = UUID.randomUUID().toString();
        newMood.setMoodId(uniqueId);
        return moodMap.put(uniqueId, newMood);
    }

    public Mood dropMood(Mood mood) throws MoodNotFoundException{
        if(!exists(mood.getMoodId())) {
            throw new MoodNotFoundException("Mood id ["+mood.getMoodId()+"] cannot be found " +
                    "while trying to drop.");
        }
        return moodMap.remove(mood.getMoodId());
    }

    public Mood updateMood(Mood mood) throws MoodNotFoundException {
        if(!exists(mood.getMoodId())){
            throw new MoodNotFoundException("Mood id ["+mood.getMoodId()+"] cannot be found " +
                    "while trying to update.");
        }
        return moodMap.put(mood.getMoodId(), mood);
    }

    public List<Mood> findAll() {
        return new ArrayList<>(moodMap.values());
    }

    public Boolean exists(String moodId) {
        return moodMap.containsKey(moodId);
    }

}
