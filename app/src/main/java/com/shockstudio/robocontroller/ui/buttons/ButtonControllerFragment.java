package com.shockstudio.robocontroller.ui.buttons;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.shockstudio.robocontroller.R;
import com.shockstudio.robocontroller.Message_String_Getter_Setter;
import com.shockstudio.robocontroller.databinding.FragmentButtonCtrlBinding;

public class ButtonControllerFragment extends Fragment
{
    ImageButton forward_button;
    ImageButton reverse_button;
    ImageButton left_button;
    ImageButton right_button;
    TextView message_text;
    int forward_throttle = 1000, reverse_throttle = 1000, left_throttle = 1000, right_throttle = 1000;

    private FragmentButtonCtrlBinding binding;
    Message_String_Getter_Setter mstr = new Message_String_Getter_Setter();

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        ButtonControllerViewModel buttonControllerViewModel = new ViewModelProvider(this).get(ButtonControllerViewModel.class);
        binding = FragmentButtonCtrlBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        forward_button = binding.forwardButton;
        reverse_button = binding.reverseButton;
        left_button = binding.leftButton;
        right_button = binding.rightButton;
        message_text = binding.messageText;

        resetUIElements();

        forward_button.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {

                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    forward_button.setImageResource(R.drawable.forward_clicked);
                    Log.i("Msg", "Button PRESSED");
                    forward_throttle = 1500;
                    setValues();
                    mstr.setForwardThrottle(forward_throttle);
                    return true;
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    forward_button.setImageResource(R.drawable.forward_unclicked);
                    Log.i("Msg", "Button RELEASED");
                    forward_throttle = 1000;
                    setValues();
                    mstr.setForwardThrottle(1000);
                    return true;
                }
                else
                return false;
            }
        });

        reverse_button.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {

                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    reverse_button.setImageResource(R.drawable.reverse_clicked);
                    Log.i("Msg", "Button PRESSED");
                    reverse_throttle = 1500;
                    setValues();
                    mstr.setReverse_throttle(1500);
                    return true;
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    reverse_button.setImageResource(R.drawable.reverse_unclicked);
                    Log.i("Msg", "Button RELEASED");
                    reverse_throttle = 1000;
                    setValues();
                    mstr.setReverse_throttle(1000);
                    return true;
                }
                else
                    return false;
            }
        });

        left_button.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {

                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    left_button.setImageResource(R.drawable.left_clicked);
                    Log.i("Msg", "Button PRESSED");
                    left_throttle = 1500;
                    setValues();
                    mstr.setLeft_throttle(1500);
                    return true;
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    left_button.setImageResource(R.drawable.left_unclicked);
                    Log.i("Msg", "Button RELEASED");
                    left_throttle = 1000;
                    setValues();
                    mstr.setLeft_throttle(1000);
                    return true;
                }
                else
                    return false;
            }
        });

        right_button.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    right_button.setImageResource(R.drawable.right_clicked);
                    Log.i("Msg", "Button PRESSED");
                    right_throttle = 1500;
                    setValues();
                    mstr.setRight_throttle(1500);
                    return true;
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    right_button.setImageResource(R.drawable.right_unclicked);
                    Log.i("Msg", "Button RELEASED");
                    right_throttle = 1000;
                    setValues();
                    mstr.setRight_throttle(1000);
                    return true;
                }
                else
                    return false;
            }
        });

        //final TextView textView = binding.textHome;


        //buttonControllerViewModel.getText().observe(getViewLifecycleOwner(), message_text::setText);
        return root;
    }

    public void setValues()
    {
        mstr.setForwardThrottle(forward_throttle);
        mstr.setReverse_throttle(reverse_throttle);
        mstr.setLeft_throttle(left_throttle);
        mstr.setRight_throttle(right_throttle);
        //Log.d("Forward Throttle", String.valueOf(forward_throttle));
        message_text.setText(mstr.getFinalMessage());
    }

    public void resetUIElements()
    {
        forward_button.setImageResource(R.drawable.forward_unclicked);
        reverse_button.setImageResource(R.drawable.reverse_unclicked);
        left_button.setImageResource(R.drawable.left_unclicked);
        right_button.setImageResource(R.drawable.right_unclicked);

    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        binding = null;
    }
}