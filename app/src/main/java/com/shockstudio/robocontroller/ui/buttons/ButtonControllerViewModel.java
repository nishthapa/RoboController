package com.shockstudio.robocontroller.ui.buttons;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.shockstudio.robocontroller.Message_String_Getter_Setter;

public class ButtonControllerViewModel extends ViewModel
{
    Message_String_Getter_Setter mstr = new Message_String_Getter_Setter();

    private final MutableLiveData<String> mText;

    public ButtonControllerViewModel()
    {
        /*
        int forward_throttle = mstr.getForward_throttle();
        int reverse_throttle = mstr.getReverse_throttle();
        int left_throttle = mstr.getLeft_throttle();
        int right_throttle = mstr.getRight_throttle();
        int power_value = mstr.getPower_value();


        mstr.setForwardThrottle();
        mstr.setReverse_throttle();
        mstr.setLeft_throttle();
        mstr.setRight_throttle();
        mstr.setPower_value();
         */
        mText = new MutableLiveData<>();
        //mText.setValue("This is Button Controller fragment");
    }

    public LiveData<String> getText()
    {
        return mText;
    }
}