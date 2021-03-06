package com.example.wendi.utspraktikummobileprograming;

/**
 * Created by arif1 on 10/26/2016.
 */

import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SessionManager {

    SharedPreferences pref;

    Editor editor;

    Context _context;

    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "UTS";

    private static final String IS_LOGIN = "IsLoggedIn";

    public static final String KEY_NAMA = "nama";

    public static final String KEY_NIM = "nim";

    // Constructor
    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }
    public void createLoginSession(String nama, String nim){
        editor.putBoolean(IS_LOGIN, true);

        editor.putString(KEY_NAMA, nama);

        editor.putString(KEY_NIM, nim);

        editor.commit();
    }

    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();

        user.put(KEY_NAMA, pref.getString(KEY_NAMA, null));

        user.put(KEY_NIM, pref.getString(KEY_NIM, null));


        return user;
    }

    public void checkLogin(){

        if(!this.isLoggedIn()){

            Intent i = new Intent(_context, com.wendi.utspraktikummobpro.LoginActivity.class);

            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            _context.startActivity(i);
        }

    }

    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }

    public void logoutUser(){

        editor.clear();
        editor.commit();

        Intent i = new Intent(_context, com.arief.utspraktikummobpro.LoginActivity.class);

        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        _context.startActivity(i);
    }
}




