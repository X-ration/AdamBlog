package com.adam.adamblog.mood;

/**
 * @author adam
 * 创建于 2018-02-28 14:29.
 * 心情对象实体类。
 */
public class Mood {

    private String moodId;
    private String userName;
    private String title;
    private String content;
    private Boolean hasImage;
    private String imageUrl;
    private Boolean hasLink;
    private String linkUrl;
    private String linkDescription;

    public Mood(String userName, String title, String content, Boolean hasImage, String imageUrl, Boolean hasLink, String linkUrl, String linkDescription) {
        this.userName = userName;
        this.title = title;
        this.content = content;
        this.hasImage = hasImage;
        this.imageUrl = imageUrl;
        this.hasLink = hasLink;
        this.linkUrl = linkUrl;
        this.linkDescription = linkDescription;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
