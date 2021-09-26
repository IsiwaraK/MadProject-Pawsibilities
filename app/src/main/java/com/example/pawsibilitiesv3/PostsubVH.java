package com.madone.forumone;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostsubVH extends RecyclerView.ViewHolder {

    public TextView txt_name, txt_position, txt_option;

    public PostsubVH(@NonNull  View itemView)
    {
        super(itemView);
        txt_name = itemView.findViewById(R.id.txt_name);
        txt_position = itemView.findViewById(R.id.txt_position);
        txt_option = itemView.findViewById(R.id.txt_option);
    }
}
