package com.shockstudio.robocontroller.ui.joystick;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.shockstudio.robocontroller.databinding.FragmentJoystickCtrlBinding;

public class JoystickControllerFragment extends Fragment
{

    private FragmentJoystickCtrlBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        JoystickControllerViewModel joystickControllerViewModel =
                new ViewModelProvider(this).get(JoystickControllerViewModel.class);

        binding = FragmentJoystickCtrlBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGallery;
        joystickControllerViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        binding = null;
    }
}