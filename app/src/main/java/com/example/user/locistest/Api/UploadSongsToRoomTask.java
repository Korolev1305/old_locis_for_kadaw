package com.example.user.locistest.Api;

import android.os.AsyncTask;

import com.example.user.locistest.SearchUsersActivity;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by ewigkeit on 19.04.17.
 */

public class UploadSongsToRoomTask extends AsyncTask {
    SearchUsersActivity activity;
    String token;

    @Override
    protected Object doInBackground(Object[] params) {
        activity = (SearchUsersActivity) params [0];
        try {
            URL url = new URL("http://locis.lod-misis.ru/user/songs/upload");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization","Basic "+ token);
            connection.connect();
            int responseCode = connection.getResponseCode();
            InputStream is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            System.out.println(responseCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);

    }
}
