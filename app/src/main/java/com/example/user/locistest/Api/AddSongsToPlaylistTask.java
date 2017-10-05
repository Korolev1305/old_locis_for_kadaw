package com.example.user.locistest.Api;

import android.os.AsyncTask;

import com.example.user.locistest.SearchUsersActivity;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by ewigkeit on 19.04.17.
 */

public class AddSongsToPlaylistTask extends AsyncTask{
    SearchUsersActivity activity;
    ArrayList songs;
    int guid;
    String token;

    public AddSongsToPlaylistTask(int guid, String token,ArrayList songs) {
        this.guid = guid;
        this.token = token;
        this.songs=songs;
    }

    @Override
    protected Object doInBackground(Object[] params) {
        activity = (SearchUsersActivity) params[0];
        try {
            URL url = new URL("http://locis.lod-misis.ru/user/songs/"+guid);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization","Basic "+ token);
            connection.connect();
            OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
            wr.write(songs.toString());
            wr.flush();
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
