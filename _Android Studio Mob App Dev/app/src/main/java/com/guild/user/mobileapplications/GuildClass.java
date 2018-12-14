package com.guild.user.mobileapplications;

public class GuildClass {

    public int guildID;
    public String guildName;
    public boolean familyMode;
    public int userIndex=0;

    public UserClass[] users = new UserClass[userIndex];


    public void setGuildID(int guildID) {
        this.guildID = guildID;
    }

    public void setGuildName(String guildName) {
        this.guildName = guildName;
    }

    public void setFamilyMode(boolean familyMode) {
        this.familyMode = familyMode;
    }

    public int getGuildID() {
        return guildID;
    }

    public String getGuildName() {
        return guildName;
    }

    public boolean getFamilyMode() {
        return familyMode;
    }


    public void addUser(MainActivity newUser){

        if (familyMode=true)
            addTaskGiver(this.users[this.userIndex]);

        this.users[this.userIndex].setUserID(newUser.getUserID());
        this.users[this.userIndex].setUserNickname(newUser.getUserNickname());
        this.users[this.userIndex].setUserImage(newUser.getUserImage());
        this.userIndex++;
    }



    public void addTaskGiver(UserClass newTaskGiver){
        newTaskGiver.makeTaskGiver();
    }




    public void updateFamilyMode(){
        if (familyMode=true) {
            for (int i = 0; i <= this.userIndex; i++) {
                addTaskGiver(this.users[i]);
            }
        }
        else{
            addTaskGiver(this.users[0]);
        }
    }

}
