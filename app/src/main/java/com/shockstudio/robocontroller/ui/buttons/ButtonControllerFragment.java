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
import com.shockstudio.robocontroller.databinding.FragmentButtonCtrlBinding;

public class ButtonControllerFragment extends Fragment
{
    ImageButton forward_button;
    ImageButton reverse_button;
    ImageButton left_button;
    ImageButton right_button;
    TextView message_text;

    private FragmentButtonCtrlBinding binding;

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
                    return true;
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    forward_button.setImageResource(R.drawable.forward_unclicked);
                    Log.i("Msg", "Button RELEASED");
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
                    return true;
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    reverse_button.setImageResource(R.drawable.reverse_unclicked);
                    Log.i("Msg", "Button RELEASED");
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
                    return true;
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    left_button.setImageResource(R.drawable.left_unclicked);
                    Log.i("Msg", "Button RELEASED");
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
                    return true;
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    right_button.setImageResource(R.drawable.right_unclicked);
                    Log.i("Msg", "Button RELEASED");
                    return true;
                }
                else
                    return false;
            }
        });

        //final TextView textView = binding.textHome;
        buttonControllerViewModel.getText().observe(getViewLifecycleOwner(), message_text::setText);
        return root;
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