package com.shubhammm.loginsignup;

/**
 * Created by Shubhamm Arora on 27-09-2018.
 */

public class post_firebase {



    private String title;
    private String desc;
    private String image;

    public post_firebase(){

    }

    public post_firebase(String title, String desc, String image) {
        this.title = title;
        this.desc = desc;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDesc() {

        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    public String getImage() {

        return image;

    }

    public void setImage(String image)
    {
        this.image = image;
    }


}
