package com.shubhammm.loginsignup;

/**
 * Created by Shubhamm Arora on 30-09-2017.
 */

public class ShowDataItems {
    private String Image_URL,Image_Title;  //name which is in Database Fields

    public ShowDataItems(String image_URL, String image_title) {
        Image_URL = image_URL;
        Image_Title = image_title;
    }

    public ShowDataItems()
    {
        //Empty Constructor
    }

    public String getImage_URL() {
        return Image_URL;
    }

    public void setImage_URL(String image_URL) {
        Image_URL = image_URL;
    }

    public String getImage_Title() {
        return Image_Title;
    }

    public void setImage_Title(String title) {
        Image_Title = title;

    }


}



