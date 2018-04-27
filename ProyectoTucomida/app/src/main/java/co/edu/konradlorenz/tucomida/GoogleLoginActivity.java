package co.edu.konradlorenz.tucomida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GoogleLoginActivity extends AppCompatActivity {

    Button btnGoogleLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_login);

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
