package com.shockstudio.robocontroller;

public class Message_String_Getter_Setter
{
    int power_value, forward_throttle, reverse_throttle, left_throttle, right_throttle;
    String power_value_str, forward_throttle_str, reverse_throttle_str, left_throttle_str, right_throttle_str;
    String message = "f" + forward_throttle + "b" + reverse_throttle + "l" + left_throttle + "r" + right_throttle;

    public void setForwardThrottle(int forward_throttle)
    {
        this.forward_throttle = forward_throttle;
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
}
