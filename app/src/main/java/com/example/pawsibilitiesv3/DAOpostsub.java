package com.madone.forumone;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import java.util.HashMap;

public class DAOpostsub {

    private  DatabaseReference databaseReference;
    public DAOpostsub()
    {
        FirebaseDatabase db  =FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Postsub.class.getSimpleName());
    }
    public Task<Void> add(Postsub post)
    {
        return databaseReference.push().setValue(post);
    }
    public Task<Void> update(String key, HashMap<String,Object> hashMap)
    {
        return databaseReference.child(key).updateChildren(hashMap);
    }

    public Task<Void> remove(String key)
    {
        return databaseReference.child(key).removeValue();
    }


    public Query get(String key)
    {
        if (key == null)
        {
             return databaseReference.orderByKey().limitToFirst(8);
        }
        return databaseReference.orderByKey().startAfter(key).limitToFirst(8);
    }

    public Query get()
    {
        return databaseReference;
    }

}
