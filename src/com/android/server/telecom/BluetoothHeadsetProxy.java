/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.android.server.telecom;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothStatusCodes;

import java.util.List;

/**
 * A proxy class that facilitates testing of the BluetoothPhoneServiceImpl class.
 *
 * This is necessary due to the "final" attribute of the BluetoothHeadset class. In order to
 * test the correct functioning of the BluetoothPhoneServiceImpl class, the final class must be put
 * into a container that can be mocked correctly.
 */
public class BluetoothHeadsetProxy {

    private BluetoothHeadset mBluetoothHeadset;

    public BluetoothHeadsetProxy(BluetoothHeadset headset) {
        mBluetoothHeadset = headset;
    }

    public List<BluetoothDevice> getConnectedDevices() {
        return mBluetoothHeadset.getConnectedDevices();
    }

    public int getConnectionState(BluetoothDevice device) {
        return mBluetoothHeadset.getConnectionState(device);
    }

    public int getAudioState(BluetoothDevice device) {
        return mBluetoothHeadset.getAudioState(device);
    }

    public boolean connectAudio() {
        return mBluetoothHeadset.connectAudio() == BluetoothStatusCodes.SUCCESS;
    }

    public boolean setActiveDevice(BluetoothDevice device) {
	return false;
    }

    public BluetoothDevice getActiveDevice() {
	return null;
    }

    public boolean isAudioOn() {
        int scoConnectionRequest = mBluetoothHeadset.connectAudio();
        return scoConnectionRequest == BluetoothStatusCodes.SUCCESS ||
            scoConnectionRequest == BluetoothStatusCodes.ERROR_AUDIO_DEVICE_ALREADY_CONNECTED;
    }

    public boolean disconnectAudio() {
        return mBluetoothHeadset.disconnectAudio() == BluetoothStatusCodes.SUCCESS;
    }

    public boolean isInbandRingingEnabled() {
        return mBluetoothHeadset.isInbandRingingEnabled();
    }

    public BluetoothHeadset getBluetoothHeadsetObj() {
        return mBluetoothHeadset;
    }
}
