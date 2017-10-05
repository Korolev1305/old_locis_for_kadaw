package com.example.user.locistest.Adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.user.locistest.Api.SendInvitationTask;
import com.example.user.locistest.FriendInList;
import com.example.user.locistest.R;
import com.example.user.locistest.SongInList;

import java.util.List;

/**
 * Created by ewigkeit on 25.04.17.
 */

public class SongsAdapter extends ArrayAdapter {
    Activity searchSongsActivity;
    int resource;
    List<SongInList> songInLists;
    String token;
    Context context;

    public SongsAdapter(Context context, int resource, List<SongInList> objects,String token){
        super(context, resource, objects);
        this.searchSongsActivity = (Activity) context;
        this.resource = resource;
        songInLists = objects;
        this.token=token;
    }

    public View getView(final int position, View convertView, final ViewGroup parent){
        ViewHolder viewHolder;
        if(convertView==null){
            LayoutInflater inflater = searchSongsActivity.getLayoutInflater();
            convertView = inflater.inflate(R.layout.item_song, null);
            viewHolder = new ViewHolder();

            viewHolder.nameTextView = (TextView) convertView.findViewById(R.id.tv_song);
            final SongInList selectedSong = songInLists.get(position);
            viewHolder.nameTextView.setText(selectedSong.name);
            viewHolder.durationTextView = (TextView) convertView.findViewById(R.id.tv_duration);
            viewHolder.durationTextView.setText(selectedSong.duration);
            final ImageButton startPauseButton = (ImageButton) convertView.findViewById(R.id.ib_startPause);
            startPauseButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    if (selectedSong.startStop=="Start") startPauseButton.setBackground(Drawable.createFromPath("@android:drawable/ic_media_pause"));
                    else startPauseButton.setBackground(Drawable.createFromPath("@android:drawable/ic_media_play"));

                }

            });
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }


        return convertView;

    }
    class ViewHolder{
        TextView nameTextView;
        TextView durationTextView;

    }

}