package com.example.womensafety;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.List;

public class AddGuardianActivity extends AppCompatActivity {
    private Button btnStore;
    private EditText gname, gmob1,gmob2,gemail;
    private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_guardian);
        databaseHelper = new DatabaseHelper(this);
        btnStore = (Button) findViewById(R.id.btnstore);
        gname = (EditText) findViewById(R.id.gname);
        gmob1 = (EditText) findViewById(R.id.gm1);
        gmob2=findViewById(R.id.gm2);
        gemail=findViewById(R.id.gemail);

        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(isEmpty(gname) || isEmpty(gmob1) || isEmpty(gemail))) {
                    databaseHelper.addUserDetail(gname.getText().toString(), gmob1.getText().toString(), gmob2.getText().toString(), gemail.getText().toString());
                    gname.setText("");
                    gmob1.setText("");
                    gmob2.setText("");
                    gemail.setText("");

                    Toast.makeText(AddGuardianActivity.this, "Stored Successfully!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(AddGuardianActivity.this, "Fields should not be empty! ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public boolean isEmpty(EditText text)
    {
        CharSequence str=text.getText().toString();
        return TextUtils.isEmpty(str);
    }
}




