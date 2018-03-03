package com.adam.adamblog.blog;

import com.adam.adamblog.util.CreateArrayList;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author adam
 * 创建于 2018-03-02 21:24.
 * 文章仓库。
 */
@Repository
public class ArticleRepository {

    private final Map<String, Article> articleMap = new ConcurrentHashMap<>();

    public void init() {
        addArticle(new Article("Frank Adam","Adam's Blog正式开通！",
                "基于Spring Boot和Material Design的个人博客站Adam's Blog正式开通。",
                CreateArrayList.withStringValues("Para.1 balabalalabalaba",
                        "Para.2 balabalablabalbablabal"),
                true,"nature.jpg",
                true,"/", "点击进入Adam's Blog!",
                LocalDateTime.parse("2017-09-12T12:45:09")));
        addArticle(new Article("IT之家","Windows 7依然是第一游戏操作系统！吃鸡玩家立大功",
                "IT之家3月3日消息 Windows桌面操作系统历经多个版本的迭代升级，终于在Windows 10上",
                CreateArrayList.withStringValues("IT之家3月3日消息 Windows桌面操作系统历经多个版本的迭代升级，终于在Windows 10上完成了微软声称的大一统，虽然Windows 10这个平台有着很大的发展潜力，但是诸多游戏玩家，仍然表示不买账，根据Steam的数据表示，截止到2018年2月份，Windows 7（64bit）依然是游戏玩家使用最多的操作系统，占比高达68.5%。Windwos 10（64bit）排名第二，占比25.41%，较上个月提升了2.71%。Windows XP用户已经基本消失殆尽，目前份额只有0.21%。",
                        "外媒softpedia称，这一切很可能是《绝地求生》发布之后，大量玩家涌入Steam造成的。此前Windows 10是Steam的主流，但伴随着《绝地求生》上线之后，Windwos 7的上升趋势愈演愈烈。",
                        "看来，在游戏玩家眼里，还是Windows 7比较好用，各位小伙伴，你们升级Windows 10了吗？"),
                true,"20180303_1.jpg",
                false,"", "",
                LocalDateTime.now()));
        addArticle(new Article("IT之家","亚马逊Alexa全球性“罢工",
                "IT之家3月3日消息 根据外媒AppleInsider报道，2018年3月2日，亚马逊旗下的Alex",
                CreateArrayList.withStringValues("IT之家3月3日消息  根据外媒AppleInsider报道，2018年3月2日，亚马逊旗下的Alexa智能音箱出现了全球性的罢工，对于用户的任何指令都没有反应，此次受到影响的用户还包括亚马逊Echo智能音箱使用者，以及市面上大量植入了Alexa的第三方硬件产品。",
                        "目前，亚马逊公司对于此次Alexa智能音箱的瘫痪并没有做出解释，据业内人士猜测，此次故障和Alexa所使用的亚马逊云计算平台有关，亚马逊位于美国弗吉尼亚州北部的一个数据中心和云计算服务，可能出现了停摆。",
                        "据称，用户会听到Alexa内置的道歉声，另外智能音箱上也会有红色指示灯闪烁，表明服务出现了中断。到美国时间3月2日的下午，Alexa开始在部分地区恢复服务。",
                        "在全球语音助手市场，亚马逊Alexa有着强大的优势，同时亚马逊还在和家电厂商进行合作，用来进一步扩大市场。"),
                true,"20180303_2.jpg",
                false,"", "",
                LocalDateTime.now()));
    }

    public Article addArticle(Article newArticle) {
        String uniqueId = UUID.randomUUID().toString();
        newArticle.setArticleId(uniqueId);
        return articleMap.put(uniqueId, newArticle);
    }

    public Article dropArticle(Article article) throws ArticleNotFoundException{
        if(!exists(article.getArticleId())) {
            throw new ArticleNotFoundException("Article id ["+article.getArticleId()+"] cannot be found " +
                    "while trying to drop.");
        }
        return articleMap.remove(article.getArticleId());
    }

    public Article updateArticle(Article article) throws ArticleNotFoundException {
        if(!exists(article.getArticleId())){
            throw new ArticleNotFoundException("Article id ["+article.getArticleId()+"] cannot be found " +
                    "while trying to update.");
        }
        return articleMap.put(article.getArticleId(), article);
    }

    public List<Article> findAll() {
        ArrayList<Article> arrayList = new ArrayList<>(articleMap.values());
        arrayList.sort(Comparator.comparing(Article::getCreatedAt).reversed());
        return arrayList;
    }
    public Article findById(String uniqueId) {
        return articleMap.get(uniqueId);
    }
    public Boolean exists(String moodId) {
        return articleMap.containsKey(moodId);
    }

}
