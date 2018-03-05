package com.adam.adamblog.mood;

import java.time.LocalDateTime;

/**
 * @author adam
 * 创建于 2018-03-01 10:39.
 * 用于从前端注入的心情表单对象。
 */
public class MoodForm {

    private String userName;
    private String content;
    private Boolean hasImage;
    private Boolean hasLink;
    private String linkUrl;
    private String linkDescription;

    @Override
    public String toString() {
        return "[MoodForm]User:" + userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getHasImage() {
        return hasImage;
    }

    public void setHasImage(Boolean hasImage) {
        this.hasImage = hasImage;
    }

    public Boolean getHasLink() {
        return hasLink;
    }

    public void setHasLink(Boolean hasLink) {
        this.hasLink = hasLink;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getLinkDescription() {
        return linkDescription;
    }

    public void setLinkDescription(String linkDescription) {
        this.linkDescription = linkDescription;
    }
}
