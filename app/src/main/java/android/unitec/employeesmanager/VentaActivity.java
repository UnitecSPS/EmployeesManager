package android.unitec.employeesmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class VentaActivity extends AppCompatActivity {
    EditText etVenta;
    TextView tvUser, tvComis;
    private double tasa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venta);

        tvUser = (TextView)findViewById(R.id.tvuser);
        tvComis = (TextView)findViewById(R.id.tvcomis);
        etVenta = (EditText)findViewById(R.id.etventas);

        //Sacar los valores del intent-----
        Intent i = getIntent();
        tvUser.setText( i.getStringExtra(LoginActivity.LOGGED_USER) );
        tasa = i.getDoubleExtra(MenuActivity.USER_TASA, 0);
    }

    public void calcular(View view) {
        try {
            double ventas = Double.parseDouble(etVenta.getText().toString());
            double comis = ventas * tasa;
            tvComis.setText("L. "+comis);
        }
        catch(Exception e){
            Toast.makeText(this, "Error: "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
