package com.firstapp.socialnetwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import de.hdodenhof.circleimageview.CircleImageView;

public class SetupActivity extends AppCompatActivity {

    private EditText Username, Fullname;
    private Button SaveInformationButton;
    private CircleImageView profileImage;
    private FirebaseAuth mAuth;
    private DatabaseReference UsersRef;

    String CurrentUserID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        mAuth = FirebaseAuth.getInstance();
        CurrentUserID = mAuth.getCurrentUser().getUid();
        UsersRef = FirebaseDatabase.getInstance().getReference().child("Users").child(CurrentUserID);


        Username = (EditText) findViewById(R.id.setup_username);
        Fullname = (EditText) findViewById(R.id.setup_fullname);
        SaveInformationButton = (Button) findViewById(R.id.setup_information_button);
        profileImage =(CircleImageView) findViewById(R.id.setup_profile_image);

        SaveInformationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveAccountSetupInformation();
            }
        });
    }

    private void SaveAccountSetupInformation() {
        String username = Username.getText().toString();
        String fullname = Fullname.getText().toString();

        if (TextUtils.isEmpty(username))
        {
            Toast.makeText(this, "Username Field Empty", Toast.LENGTH_SHORT).show();
        }

        if (TextUtils.isEmpty(fullname))
        {
            Toast.makeText(this, "Full name Field Empty", Toast.LENGTH_SHORT).show();
        }
    }
}