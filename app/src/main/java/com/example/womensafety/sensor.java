package com.example.womensafety;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

public class sensor extends AppCompatActivity {
    TextView txt1;
//            txt_currentAccel,txt_prevAccel,txt_Accel;
//    ProgressBar prog_shakeMeter;


    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private GeoLocation geoLocation = new GeoLocation();

    private double accelerationCurrentValue;
    private double accelerationPreviousValue;
    private SensorEventListener sensorEventListener=new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {

            float x=sensorEvent.values[0];
            float y=sensorEvent.values[1];
            float z=sensorEvent.values[2];
            accelerationCurrentValue=(int)Math.sqrt((x*x+y*y+z*z));
            double changeInAcceleration = (int)Math.abs(accelerationCurrentValue - accelerationPreviousValue);
            accelerationPreviousValue=(int)accelerationCurrentValue;
//            txt1.setText((int) changeInAcceleration);
            if(changeInAcceleration>3)
            {
                Intent intent = new Intent(sensor.this,AddGuardianActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

//                Log.d("sensor message", "onSensorChanged: hi");
//                Intent intent = new Intent(sensor.this,
//                        GeoLocation.class);
//                startActivity(intent);

            }

//            txt_currentAccel.setText("current="+(int)accelerationCurrentValue);
//            txt_prevAccel.setText("prev="+(int)accelerationPreviousValue);
//            txt_Accel.setText("accelertion chng="+(int)changeInAcceleration);

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//
//        txt_Accel=findViewById(R.id.txt_accel);
//        txt_currentAccel=findViewById(R.id.txt_currentAccel);
//        txt_prevAccel=findViewById(R.id.txt_prevAccel);
//        prog_shakeMeter=findViewById(R.id.prog_shakeMeter);
//txt1=findViewById(R.id.txt1);
        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

    }
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(sensorEventListener, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(sensorEventListener);
    }


}