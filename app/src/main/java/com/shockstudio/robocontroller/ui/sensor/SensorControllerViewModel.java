package com.shockstudio.robocontroller.ui.sensor;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SensorControllerViewModel extends ViewModel
{

    private final MutableLiveData<String> mText;

    public SensorControllerViewModel()
    {
        mText = new MutableLiveData<>();
        mText.setValue("This is Sensor Controller fragment");
    }

    public LiveData<String> getText()
    {
        return mText;
    }
}