package com.example.sasha.smarthcs;

import com.google.gson.annotations.SerializedName;

public class POST_GSV {

   @SerializedName
  ("login") private String login;
   public POST_GSV(String login){
       super();
       this.login=login;

    }

}
