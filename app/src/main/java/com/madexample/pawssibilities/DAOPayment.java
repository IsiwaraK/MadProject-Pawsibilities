package com.madexample.pawssibilities;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class DAOPayment {
    private DatabaseReference databaseReference;
    public DAOPayment()
    {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Payment.class.getSimpleName());
    }
    public Task<Void> add(Payment pay){

        return databaseReference.push().setValue(pay);
    }

    public Task<Void> update (String key, HashMap<String,Object>hashMap)
    {
        return databaseReference.child(key).updateChildren(hashMap);

    }
    public Task<Void> remove (String key)
    {
        return databaseReference.child(key).removeValue();
    }
}

