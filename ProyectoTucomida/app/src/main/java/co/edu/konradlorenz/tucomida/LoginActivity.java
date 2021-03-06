package co.edu.konradlorenz.tucomida;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    Button btnGoogleLogin;
    EditText userEmail;
    EditText password;
    TextView register;
    private int dpheight,dpWidth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //supportRequestWindowFeature ( Window.FEATURE_NO_TITLE );

        dpheight = LoginActivity.this.getResources().getConfiguration().screenHeightDp;
        dpWidth=LoginActivity.this.getResources().getConfiguration().screenWidthDp;

        if(dpheight < 600 && dpWidth<600){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        btnLogin = (Button) findViewById ( R.id.loginButton );
        btnGoogleLogin = (Button) findViewById ( R.id.googleLoginButton );
        userEmail = (EditText) findViewById ( R.id.usenameEditText );
        password = (EditText) findViewById ( R.id.passwordEditText );
        register = (TextView) findViewById ( R.id.registerLinkTextView );



        btnLogin.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent ( LoginActivity.this, DishesListActivity.class );
                startActivity ( intent );
            }
        } );


        btnGoogleLogin.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent ( LoginActivity.this, GoogleLoginActivity.class );
                startActivity ( intent );
            }
        } );


        register.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent ( LoginActivity.this, RegisterActivity.class );
                startActivity ( intent );
            }
        } );
    }

}
