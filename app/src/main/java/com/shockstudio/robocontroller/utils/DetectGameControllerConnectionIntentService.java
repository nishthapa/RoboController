package com.shockstudio.robocontroller.utils;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import android.view.InputDevice;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.shockstudio.robocontroller.ui.joystick.JoystickControllerFragment;

import java.util.ArrayList;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class DetectGameControllerConnectionIntentService extends IntentService
{

    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_DETECT_GAME_CONTROLLER_CONNECTION = "com.shockstudio.robocontroller.utils.action.DETECT_GAME_CONTROLLER_CONNECTION";
    //private static final String ACTION_FOO = "com.shockstudio.robocontroller.utils.action.FOO";
    //private static final String ACTION_BAZ = "com.shockstudio.robocontroller.utils.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "com.shockstudio.robocontroller.utils.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.shockstudio.robocontroller.utils.extra.PARAM2";
    //ArrayList<Integer> gameControllerDeviceIds;
    //int[] deviceIds;
    ConnectedDevice cd = new ConnectedDevice();
    //boolean game_controller_found = false;

    public DetectGameControllerConnectionIntentService()
    {
        super("DetectGameControllerConnectionIntentService");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionDetectGameControllerConnection(Context context, String param1, String param2)
    {
        Intent intent = new Intent(context, DetectGameControllerConnectionIntentService.class);
        intent.setAction(ACTION_DETECT_GAME_CONTROLLER_CONNECTION);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }


    //USER CODE:
    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        Log.i("start service", "SERVICE STARTED!");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        cd.setGameControllerDeviceIds(getGameControllerIds()) ;
    }

    @Override
    public void onDestroy()
    {
        cd.setDeviceIds(null);
        cd.setGame_controller_found(false);
        cd.setGameControllerDeviceIds(null);
        //gameControllerDeviceIds = null;
        //deviceIds = null;
        //game_controller_found = false;
        Log.i("CONTROLLER DETECTION", "Controller Connection Detection service STOPPED");
        //Toast.makeText(DetectGameControllerConnectionIntentService.this, "service destroyed", Toast.LENGTH_LONG).show();
        super.onDestroy();
    }

    public ArrayList<Integer> getGameControllerIds()
    {
        ArrayList<Integer> gameControllerDeviceIds = new ArrayList<Integer>();
        //while (!cd.game_controller_found)
        while(cd.isGame_controller_found() == false)
        {
            Log.i("CONTROLLER DETECTION", "Controller Connection Detection service STARTED");
            SystemClock.sleep(1000);
            int[] deviceIds = InputDevice.getDeviceIds();
            for (int deviceId : deviceIds)
            {
                InputDevice dev = InputDevice.getDevice(deviceId);
                int sources = dev.getSources();
                // Verify that the device has gamepad buttons, control sticks, or both.
                if (((sources & InputDevice.SOURCE_GAMEPAD) == InputDevice.SOURCE_GAMEPAD) || ((sources & InputDevice.SOURCE_JOYSTICK) == InputDevice.SOURCE_JOYSTICK))
                {
                    // This device is a game controller. Store its device ID.
                    if (!gameControllerDeviceIds.contains(deviceId))
                    {
                        gameControllerDeviceIds.add(deviceId);
                        cd.setGame_controller_found(true);
                    }
                }
            }
        }
        Toast.makeText(DetectGameControllerConnectionIntentService.this, "Gamepad Detected, switching to Joystick Mode", Toast.LENGTH_LONG).show();
        //TODO: set object device IDs in .utils.ConnectedDevice Class
        //cd.setGameControllerDeviceIds(gameControllerDeviceIds);

        return gameControllerDeviceIds;
    }



    /*
    @Override
    protected void onHandleIntent(Intent intent)
    {
        if (intent != null)
        {
            final String action = intent.getAction();
            if (ACTION_DETECT_GAME_CONTROLLER_CONNECTION.equals(action))
            {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionFoo(param1, param2);
            }
        }
    }
    */
    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2)
    {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2)
    {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }
}