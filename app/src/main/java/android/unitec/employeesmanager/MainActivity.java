package android.unitec.employeesmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etHoras;
    private TextView tvPago, tvhn, tvhe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etHoras = (EditText) findViewById(R.id.etHoras);
        tvPago = (TextView) findViewById(R.id.tvPago);
        tvhn = (TextView) findViewById(R.id.tvHn);
        tvhe = (TextView) findViewById(R.id.tvHe);
    }

    public void calcular(View view) {

        //sacar las horas trabajadas
        double horas = Double.parseDouble( etHoras.getText().toString() );
        double pago=0;

        /*
        Saquemos el pago:
            Se paga L. 150 x cada hora normal. Hasta 40 son normales
            El resto extra se paga a L. 300
         */

        if(horas > 40){
            pago = (150*40) + (horas-40) * 300;
        }
        else{
            pago = horas * 150;
        }

        tvPago.setText("L. "+pago);

        Toast.makeText(this, "Pago Calculado", Toast.LENGTH_LONG).show();
    }

    public void detalle(View view) {
        double hn = 40, he=0;
        double horas = Double.parseDouble( etHoras.getText().toString() );

        if(horas > 40)
            he = (horas-40);
        else
            hn = horas;

        tvhn.setText(hn + " horas");
        tvhe.setText(he + " horas");
    }
}
