package com.ctech.aleco.beatbox;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BeatBox {
    public static final String TAG = "BeatBox";
    public static final String SOUNDS_FOLDER = "sample_sounds";

    private AssetManager mAssets;
    private List<Sound> mSoundList = new ArrayList<>();
    public BeatBox(Context context){
        mAssets = context.getAssets();
        loadSounds();
    }

    private void loadSounds() {
        String[] soundNames;try{
 soundNames = mAssets.list(SOUNDS_FOLDER);
            Log.i(TAG, "found" + soundNames.length + " sounds.");} catch (IOException ioe){Log.e(TAG,"Could not list assets in " + SOUNDS_FOLDER, ioe); return;}

for (String filename : soundNames){
String assetPath = SOUNDS_FOLDER + "/" + filename;
Sound mySound = new Sound(assetPath);
mSoundList.add(mySound);
}
}
public List<Sound> getSoundList(){
return mSoundList; }
}