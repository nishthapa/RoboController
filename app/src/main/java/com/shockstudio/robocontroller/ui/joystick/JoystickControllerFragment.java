package com.shockstudio.robocontroller.ui.joystick;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.shockstudio.robocontroller.Message_String_Getter_Setter;
import com.shockstudio.robocontroller.databinding.FragmentJoystickCtrlBinding;

import io.github.controlwear.virtual.joystick.android.JoystickView;

public class JoystickControllerFragment extends Fragment
{
    JoystickView left_joystick, right_joystick;
    TextView message_text;
    int left_joystick_angle = 0, left_joystick_strength = 0, right_joystick_angle = 0, right_joystick_strength = 0;
    //int left_joystick_forward_throttle = 1000, left_joystick_reverse_throttle = 1000, left_joystick_left_throttle = 1000, right_throttle = 1000;
    private FragmentJoystickCtrlBinding binding;
    Message_String_Getter_Setter mstr = new Message_String_Getter_Setter();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        JoystickControllerViewModel joystickControllerViewModel = new ViewModelProvider(this).get(JoystickControllerViewModel.class);
        binding = FragmentJoystickCtrlBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        message_text = binding.messageText;
        left_joystick = binding.leftJoystick;
        right_joystick = binding.rightJoystick;

        //left joystick initialization
        left_joystick.setOnMoveListener(new JoystickView.OnMoveListener()
        {
            @Override
            public void onMove(int angle, int strength)
            {
                left_joystick_angle = angle;
                left_joystick_strength = strength;
                //if(left_joystick_angle < 90)
                //{

                //}
                setValues();
                //Log.i("Msg", "ANGLE: " + left_joystick_angle + "\tSTRENGTH: " + left_joystick_strength);
                // do whatever you want
            }
        });

        //right joystick initialization
        right_joystick.setOnMoveListener(new JoystickView.OnMoveListener()
        {
            @Override
            public void onMove(int angle, int strength)
            {
                right_joystick_angle = angle;
                right_joystick_strength = strength;
                //if(left_joystick_angle < 90)
                //{

                //}
                setValues();
                //Log.i("Msg", "ANGLE: " + right_joystick_angle + "\tSTRENGTH: " + right_joystick_strength);
                // do whatever you want
            }
        });



        return root;
    }


    public void setValues()
    {
        mstr.setLeft_joystick_angle(left_joystick_angle);
        mstr.setLeft_joystick_strength(left_joystick_strength);
        mstr.setRight_joystick_angle(right_joystick_angle);
        mstr.setRight_joystick_strength(right_joystick_strength);

        //Log.d("Forward Throttle", String.valueOf(forward_throttle));
        message_text.setText(mstr.getFinalMessage());
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        binding = null;
    }
}