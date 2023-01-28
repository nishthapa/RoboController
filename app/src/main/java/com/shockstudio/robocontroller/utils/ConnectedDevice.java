package com.shockstudio.robocontroller.utils;

import java.util.ArrayList;

public class ConnectedDevice
{
    int[] deviceIds;
    boolean game_controller_found;
    ArrayList<Integer> gameControllerDeviceIds;

    public ConnectedDevice()
    {
        gameControllerDeviceIds = null;
        deviceIds = null;
        boolean game_controller_found = false;
        //boolean game_controller_found = true;
    }

    public ArrayList<Integer> getGameControllerDeviceIds()
    {
        return gameControllerDeviceIds;
    }

    public void setGameControllerDeviceIds(ArrayList<Integer> gameControllerDeviceIds)
    {
        this.gameControllerDeviceIds = gameControllerDeviceIds;
    }

    public boolean isGame_controller_found()
    {
        return game_controller_found;
    }

    public void setGame_controller_found(boolean game_controller_found)
    {
        this.game_controller_found = game_controller_found;
    }

    public int[] getDeviceIds()
    {
        return deviceIds;
    }

    public void setDeviceIds(int[] deviceIds)
    {
        this.deviceIds = deviceIds;
    }
}
