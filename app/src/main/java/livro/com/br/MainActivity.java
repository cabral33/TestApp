package livro.com.br;

import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText etPeso;
    private EditText etAltura;
    private Button btCalcular;
    private Button btLimpar;
    private TextView tvResul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPeso = (EditText) findViewById(R.id.etPeso);
        etAltura = (EditText) findViewById(R.id.etAltura);
        tvResul = (TextView) findViewById(R.id.tvResul);
        btCalcular = (Button) findViewById(R.id.btCalcular);
        btLimpar =  (Button) findViewById(R.id.btLimpar);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                btCalcularOnClick();
            }

            private void btCalcularOnClick() {              //classe anonimata para o botao
            }
        });

        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                btLimparOnClick();
            }
            private void btLimparOnClick() {                //classe anonimataaaa
            }                                               //hehe
        });

        private void btCalcularOnClick(){
            if (etPeso.getText().toString().equals("")) {
                Toast.makeText(getApplicationContext(), "Campo deve ser preenchido", Toast.LENGTH_LONG).show();
                etPeso.requestFocus();
                return;
            }

            if (etAltura.getText().toString().equals("")){
                Toast.makeText(getApplicationContext(), "Campo alterado deve ser preenchido", Toast.LENGTH_LONG).show();
                etAltura.requestFocus();
                return;
            }

            double peso = Double.parseDouble(etPeso.getText().toString());
            double altura = Double.parseDouble(etAltura.getText().toString());

            double imc = peso/Math.pow(altura,  2);

            tvResul.setText(new DecimalFormat("0.00").format(imc));
        }

        private void btLimparOnClick() {
            etPeso.setText("");
            etAltura.setText("");
            tvResul.setText("0.0");
        }

    }
}
