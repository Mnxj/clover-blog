package com.clover.common.util;


/**
 * @ClassName: PictureUrl
 * @Description: 图片地址信息
 * @Author: Clover
 * @Date: 2021.04.14
 * Version: 1.0
 */
public enum PictureUrlUtil {
    /**
     * 文章归档
     */
    ARTICLE_FILING("XE8WkJNJ"),
    /**
     * 树洞
     */
    TREE_HOLE("Be8HX4x5"),
    /**
     * 友人帐
     */
    FRIENDS_ACCOUNT("7qai5Lft"),
    /**
     * 文章分类
     */
    ARTICLE_CLASSIFICATION("d8m6m56V"),
    /**
     * 标签分类
     */
    LABEL_CLASSIFICATION("Va8hs8R8"),
    /**
     * 关于我
     */
    ABOUT_ME("TdsGh5DN"),
    /**
     * 更新主题
     */
    UPDATE_THEME("7Bi3UP3N"),
    /**
     * 搜索内容
     */
    SEARCH_CONTEXT("4pivlHo9");
    /**
     *  EnrW7R6Q2e
     */
    String name;

    public String getName() {
        return name;
    }

    PictureUrlUtil(String name) {
        this.name = name;
    }

}
