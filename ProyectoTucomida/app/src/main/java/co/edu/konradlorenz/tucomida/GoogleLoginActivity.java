package co.edu.konradlorenz.tucomida;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GoogleLoginActivity extends AppCompatActivity {

    Button btnGoogleLogin;
    private int dpheight,dpWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_login);

        dpheight = GoogleLoginActivity.this.getResources().getConfiguration().screenHeightDp;
        dpWidth=GoogleLoginActivity.this.getResources().getConfiguration().screenWidthDp;

        if(dpheight < 600 && dpWidth<600){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        btnGoogleLogin = (Button) findViewById ( R.id.googleLoginUserButton );


        btnGoogleLogin.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent ( GoogleLoginActivity.this, DishesListActivity.class );
                startActivity ( intent );
            }
        } );
    }
}
