package com.adam.adamblog.mood;

import com.adam.adamblog.util.LocalDateTimeFormatter;

import java.time.LocalDateTime;

/**
 * @author adam
 * 创建于 2018-02-28 14:29.
 * 心情对象实体类。
 */
public class Mood {

    private String moodId;
    private String userName;
    private String content;
    private Boolean hasImage;
    private String imageUrl;
    private Boolean hasLink;
    private String linkUrl;
    private String linkDescription;
    private LocalDateTime createdAt;

    public Mood(String userName, String content, Boolean hasImage, String imageUrl, Boolean hasLink, String linkUrl, String linkDescription, LocalDateTime createdAt) {
        this.userName = userName;
        this.content = content;
        this.hasImage = hasImage;
        this.imageUrl = imageUrl;
        this.hasLink = hasLink;
        this.linkUrl = linkUrl;
        this.linkDescription = linkDescription;
        this.createdAt = createdAt;
    }

    public Mood() {
        this.userName = "";
        this.content = "";
        this.hasImage = false;
        this.imageUrl = "";
        this.hasLink = false;
        this.linkUrl = "";
        this.linkDescription = "";
        this.createdAt = null;
    }

    @Override
    public String toString() {
        return "[Mood]User:" + userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMoodId() {
        return moodId;
    }

    public void setMoodId(String moodId) {
        this.moodId = moodId;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedAtFormatted() {
        return LocalDateTimeFormatter.formatFull(createdAt);
    }
}
