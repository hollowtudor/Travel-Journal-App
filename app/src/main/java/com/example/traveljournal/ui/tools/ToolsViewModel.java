package com.example.traveljournal.ui.tools;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ToolsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ToolsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("We specialize in tours anywhere in the world but we are always expanding and enhancing our wide range of offers, as well as adding new and exciting tours of Germany, Italy, Eastern Europe, Japan and so on.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}