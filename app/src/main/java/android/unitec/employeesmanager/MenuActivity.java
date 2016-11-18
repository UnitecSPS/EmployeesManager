package android.unitec.employeesmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    TextView tvUser;
    private String user;
    final static String USER_TASA = "tasa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        tvUser = (TextView)findViewById(R.id.tvUser);
        Intent i = getIntent();
        //necesito sacar el valor del user logged in
        user = i.getStringExtra(LoginActivity.LOGGED_USER);
        tvUser.setText(user);
    }

    public void hora(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void venta(View view) {
        Intent i = new Intent(this, VentaActivity.class);
        i.putExtra(LoginActivity.LOGGED_USER, user);

        //evaluar la tasa
        double tasa = 0.05;
        if(user.equals("gochez"))
            tasa = 0.1;
        i.putExtra(USER_TASA, tasa);

        startActivity(i);
    }
}
