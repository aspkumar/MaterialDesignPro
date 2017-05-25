package com.example.prasannakumara.materialdesign;

/**
 * Created by PrasannakumarA on 5/10/2017.
 */

public class ComponetsNameModel {

    String displayName;
    String clickName;


    public ComponetsNameModel(String displayName, String clickName) {
        this.displayName = displayName;
        this.clickName = clickName;
    }


    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getClickName() {
        return clickName;
    }

    public void setClickName(String clickName) {
        this.clickName = clickName;
    }


}
