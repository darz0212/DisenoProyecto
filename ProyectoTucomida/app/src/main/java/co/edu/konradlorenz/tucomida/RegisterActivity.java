package co.edu.konradlorenz.tucomida;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    Button btnRegister;
    Button btnCancel;
    EditText userEmail;
    EditText password;
    private int dpheight,dpWidth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dpheight = RegisterActivity.this.getResources().getConfiguration().screenHeightDp;
        dpWidth=RegisterActivity.this.getResources().getConfiguration().screenWidthDp;

        if(dpheight < 600 && dpWidth<600){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        btnRegister = (Button) findViewById ( R.id.registerConfirmButton );
        btnCancel = (Button) findViewById ( R.id.cancelRegisterButton );
        userEmail = (EditText) findViewById ( R.id.emailEditText );
        password = (EditText) findViewById ( R.id.passwordUserEditText );


        btnRegister.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent ( RegisterActivity.this, DishesListActivity.class );
                startActivity ( intent );
            }
        } );


        btnCancel.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent ( RegisterActivity.this, LoginActivity.class );
                startActivity ( intent );
            }
        } );
    }
}
