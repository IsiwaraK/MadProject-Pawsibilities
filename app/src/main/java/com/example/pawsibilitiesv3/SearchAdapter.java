package com.example.pawsibilitiesv3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class SearchAdapter extends FirebaseRecyclerAdapter<MainModel,SearchAdapter.myViewHolder> {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public SearchAdapter(@NonNull @NotNull FirebaseRecyclerOptions<MainModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull @NotNull myViewHolder holder,final int position, @NonNull @NotNull MainModel model) {
        holder.name.setText(model.getName());
        holder.mobile.setText(model.getMobile());
        holder.email.setText(model.getEmail());
        holder.province.setText(model.getProvince());

        Glide.with(holder.img.getContext())
                .load(model.getVurl())
                .placeholder(R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img);

    }

    @NonNull
    @NotNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.seach_item,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        CircleImageView img;
        TextView name,mobile,email,province;

        public myViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            img = (CircleImageView)itemView.findViewById(R.id.searchimg1);
            name = (TextView)itemView.findViewById(R.id.searchnametext);
            mobile = (TextView)itemView.findViewById(R.id.searchmobiletext);
            email = (TextView)itemView.findViewById(R.id.searchemailtext);
            province = (TextView)itemView.findViewById(R.id.searchprovincetext);

        }
    }
}
