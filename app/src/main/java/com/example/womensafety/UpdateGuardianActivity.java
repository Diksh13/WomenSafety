package com.example.womensafety;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateGuardianActivity extends AppCompatActivity {
    private UserModel userModel;
    private EditText etname, mb1,mb2,etemail;
    private Button btnupdate, btndelete;
    private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_guardian);
        Intent intent = getIntent();
        userModel = (UserModel) intent.getSerializableExtra("user");
        databaseHelper = new DatabaseHelper(this);
        etname = (EditText) findViewById(R.id.etname);
        mb1 = (EditText) findViewById(R.id.mb1);
        mb2=findViewById(R.id.mb2);
        etemail=findViewById(R.id.etemail);
        btndelete = (Button) findViewById(R.id.btndelete);
        btnupdate = (Button) findViewById(R.id.btnupdate);
        etname.setText(userModel.getName());
        mb1.setText(userModel.getGmob1());
        mb2.setText(userModel.getGmob2());
        etemail.setText(userModel.getGemail());
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.updateUser(userModel.getId(),etname.getText().toString(),mb1.getText().toString(),mb2.getText().toString(),etemail.getText().toString());
                Toast.makeText(UpdateGuardianActivity.this, "Updated Successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UpdateGuardianActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.deleteUSer(userModel.getId());
                Toast.makeText(UpdateGuardianActivity.this, "Deleted Successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UpdateGuardianActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }
}