package com.example.android_final.ui.afficher;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AfficherViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public AfficherViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}