package com.example.yuko.myapplication;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
//import android.graphics.Camera;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.hardware.Camera;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 * Created by yuko on 2014/12/09.
 */
public class SimpleCameraSampleActivity  extends Activity {
    // カメラインスタンス
    private Camera mCam = null;

    // カメラプレビュークラス
    private CameraPreview mCamPreview = null;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        // カメラインスタンスの取得
        try {
            mCam = Camera.open(1);
        } catch (Exception e) {
            // エラー
            this.finish();
        }

        // FrameLayout に CameraPreview クラスを設定
        FrameLayout preview = (FrameLayout)findViewById(R.id.cameraPreview);
        mCamPreview = new CameraPreview(this, mCam);
        preview.addView(mCamPreview);
    }


    @Override
    protected void onPause() {
        super.onPause();
        // カメラ破棄インスタンスを解放
        if (mCam != null) {
            mCam.release();
            mCam = null;
        }
    }
}



