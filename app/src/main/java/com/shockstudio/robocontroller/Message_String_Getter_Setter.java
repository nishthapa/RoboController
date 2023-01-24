package com.shockstudio.robocontroller;

import android.util.Log;

public class Message_String_Getter_Setter
{
    int power_value;
    int forward_throttle;
    int reverse_throttle;
    int left_throttle;
    int right_throttle;
    int left_joystick_angle;
    int left_joystick_strength;
    int right_joystick_angle;
    int right_joystick_strength;
    String power_value_str, forward_throttle_str, reverse_throttle_str, left_throttle_str, right_throttle_str;
    String final_message = "f" + forward_throttle + "b" + reverse_throttle + "l" + left_throttle + "r" + right_throttle;

    public int getLeft_joystick_strength()
    {
        return left_joystick_strength;
    }

    public void setLeft_joystick_strength(int left_joystick_strength)
    {
        this.left_joystick_strength = left_joystick_strength;
    }

    public int getRight_joystick_strength()
    {
        return right_joystick_strength;
    }

    public void setRight_joystick_strength(int right_joystick_strength)
    {
        this.right_joystick_strength = right_joystick_strength;
    }

    public int getLeft_joystick_angle()
    {
        return left_joystick_angle;
    }

    public void setLeft_joystick_angle(int left_joystick_angle)
    {
        this.left_joystick_angle = left_joystick_angle;
    }

    public int getRight_joystick_angle()
    {
        return right_joystick_angle;
    }

    public void setRight_joystick_angle(int right_joystick_angle)
    {
        this.right_joystick_angle = right_joystick_angle;
    }

    public void setForwardThrottle(int forward_throttle)
    {
        this.forward_throttle = forward_throttle;
        Log.i("Getter Setter", String.valueOf(forward_throttle));
    }

    public void setReverse_throttle(int reverse_throttle)
    {
        this.reverse_throttle = reverse_throttle;
    }

    public void setLeft_throttle(int left_throttle)
    {
        this.left_throttle = left_throttle;
    }

    public void setRight_throttle(int right_throttle)
    {
        this.right_throttle = right_throttle;
    }

    public void setPower_value(int power_value)
    {
        this.power_value = power_value;
    }

    public void setFinalMessage(String final_message)
    {
        this.final_message = final_message;
    }

    public int getForward_throttle()
    {
        return forward_throttle;
    }

    public int getReverse_throttle()
    {
        return reverse_throttle;
    }

    public int getLeft_throttle()
    {
        return left_throttle;
    }

    public int getRight_throttle()
    {
        return right_throttle;
    }

    public int getPower_value()
    {
        return power_value;
    }

    public String getFinalMessage()
    {
        if(forward_throttle != 0 && reverse_throttle != 0 && left_throttle != 0 && right_throttle != 0)
            final_message = "f" + forward_throttle + "b" + reverse_throttle + "l" + left_throttle + "r" + right_throttle;
        else
            final_message = "LEFT_JS_ANGLE: " + left_joystick_angle + ", RIGHT_JS_ANGLE: " + right_joystick_angle +
                    "\nLEFT_JS_STRENGTH: " + left_joystick_strength + ", RIGHT_JS_STRENGTH = " + right_joystick_strength;
        return final_message;
    }
}
