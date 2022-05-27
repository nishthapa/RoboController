package com.shockstudio.robocontroller.ui.sensor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.shockstudio.robocontroller.databinding.FragmentSensorCtrlBinding;

public class SensorControllerFragment extends Fragment
{

    private FragmentSensorCtrlBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        SensorControllerViewModel sensorControllerViewModel =
                new ViewModelProvider(this).get(SensorControllerViewModel.class);

        binding = FragmentSensorCtrlBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSlideshow;
        sensorControllerViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        binding = null;
    }
}