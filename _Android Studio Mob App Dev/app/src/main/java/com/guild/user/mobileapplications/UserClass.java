package com.guild.user.mobileapplications;

import android.media.Image;

public class UserClass {

    private int userID;
    private String userNickname;
    public Image userImage;
    public boolean isTaskGiver = false;

    //these will later store the information in the SQL
    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public void setUserImage(Image userImage) {
        this.userImage = userImage;
    }


    //getters for when we need them
    public int getUserID() {
        return userID;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public Image getUserImage() {
        return userImage;
    }



    public void makeTaskGiver(){
        this.isTaskGiver=true;
    }


}
