package com.example.projectchat.utilities;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefernceManager {
    private  final SharedPreferences sharedPreferences;

    public  PrefernceManager(Context context) {
        sharedPreferences = context.getSharedPreferences(Constants.KEY_PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    public void pitBoolean(String key, Boolean value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
    }
}
