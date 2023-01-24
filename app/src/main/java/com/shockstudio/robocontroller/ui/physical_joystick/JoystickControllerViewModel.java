package com.shockstudio.robocontroller.ui.physical_joystick;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class JoystickControllerViewModel extends ViewModel
{

    private final MutableLiveData<String> mText;

    public JoystickControllerViewModel()
    {
        mText = new MutableLiveData<>();
        mText.setValue("This is Joystick Controller fragment");
    }

    public LiveData<String> getText()
    {
        return mText;
    }
}