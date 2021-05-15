package com.example.womensafety;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    private Button btnadd,btnedit,btngeo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnadd=findViewById(R.id.add);
        btnedit=findViewById(R.id.edit);
        btngeo=findViewById(R.id.geo);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddGuardianActivity.class);
                startActivity(intent);
            }
        });

        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ViewGuardianActivity.class);
                startActivity(intent);
            }
        });

        btngeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,GeoLocation.class);
                startActivity(intent);

            }
        });

//
//        btnEmail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final Intent intent = new Intent(android.content.Intent.ACTION_SEND);
//                intent.setType("text/plain");
//                final PackageManager pm = getPackageManager();
//                final List<ResolveInfo> matches = pm.queryIntentActivities(intent, 0);
//                ResolveInfo best = null;
//                for (final ResolveInfo info : matches)
//                    if (info.activityInfo.packageName.endsWith(".gm") ||
//                            info.activityInfo.name.toLowerCase().contains("gmail")) best = info;
//                if (best != null)
//                    intent.setClassName(best.activityInfo.packageName,best.activityInfo.name);
//
//                startActivity(intent);
//            }
//        });
    }
}