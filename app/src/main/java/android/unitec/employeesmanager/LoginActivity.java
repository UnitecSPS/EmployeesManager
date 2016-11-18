package android.unitec.employeesmanager;

import android.content.Intent;
import android.net.Uri;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etUser, etPassword;
    final static String LOGGED_USER = "logged";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUser = (EditText)findViewById(R.id.etUser);
        etPassword = (EditText)findViewById(R.id.etPassword);
    }

    public void login(View view){
        String user = etUser.getText().toString();
        String pass = etPassword.getText().toString();

        if( autenticar(user, pass) ){
            Intent inte = new Intent(this, MenuActivity.class);
            inte.putExtra(LOGGED_USER, user);
            startActivity(inte);
        }
        else
            Toast.makeText(this, user + " no es valido.", Toast.LENGTH_LONG).show();
    }

    private boolean autenticar(String u, String p){
        return  (u.equals("gochez") &&  p.equals("dathia")) ||
                (u.equals("lorraine") && p.equals("roatan"));
    }

    public void web(View view) {
        Intent iweb = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.unitec.edu"));
        startActivity(iweb);
    }
}
