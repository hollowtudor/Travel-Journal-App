package com.example.traveljournal.ui.slideshow;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SlideshowViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SlideshowViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("You can contact our advisors at 0755524910 or via email at tudorcojocaru7@yahoo.com");

    }

    public LiveData<String> getText() {
        return mText;
    }
}