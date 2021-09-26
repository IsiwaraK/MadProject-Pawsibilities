package com.madone.forumone;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private Context context;
    ArrayList<Postsub> list = new ArrayList<>();
    public RVAdapter(Context ctx)
    {
        this.context = ctx;
    }
    public void setItems(ArrayList<Postsub> post)
    {
        list.addAll(post);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view =  LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false);
        return new PostsubVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {
        Postsub e = null;
        this.onBindViewHolder(holder,position,e);
    }

    public void onBindViewHolder( @NonNull  RecyclerView.ViewHolder holder, int position, Postsub e)
    {
        PostsubVH vh = (PostsubVH) holder;
        Postsub post = e==null? list.get(position):e;
        vh.txt_name.setText(post.getTitle());
        vh.txt_position.setText(post.getDescription());
        vh.txt_option.setOnClickListener(v->
        {
            PopupMenu popupMenu = new PopupMenu(context, vh.txt_option);
            popupMenu.inflate(R.menu.option_menu);
            popupMenu.setOnMenuItemClickListener(item ->
                    {
                        switch (item.getItemId())
                        {
                            case R.id.menu_edit:
                                Intent intent = new Intent(context, MainActivity2.class);
                                intent.putExtra("EDIT", post);
                                context.startActivity(intent);
                                break;

                            case R.id.menu_remove:
                                DAOpostsub dao =new DAOpostsub();
                                dao.remove(post.getKey()).addOnSuccessListener(suc ->
                                {
                                    Toast.makeText(context, "deleted", Toast.LENGTH_SHORT).show();
                                    notifyItemRemoved(position);
                                    list.remove(post);

                                }).addOnFailureListener(er ->
                                {
                                    Toast.makeText(context, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                                });
                                break;
                        }
                        return false;
                    });

            popupMenu.show();

        });
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }
}