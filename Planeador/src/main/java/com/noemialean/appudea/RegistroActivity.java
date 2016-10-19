package com.noemialean.appudea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    EditText eUsuario, eContrasena, eRContrasena, eEmail;
    Button bAceptar, bCancelar;


    private String nombre, rContrasena, contrasena, Email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        eUsuario = (EditText) findViewById(R.id.eUsuario);
        eContrasena = (EditText) findViewById(R.id.eContrasena);
        eRContrasena = (EditText) findViewById(R.id.eRContrasena);
        eEmail = (EditText) findViewById(R.id.eEmail);
        bAceptar = (Button) findViewById(R.id.bAceptar);
        bCancelar = (Button) findViewById(R.id.bCancelar);

        bAceptar.setOnClickListener(new View.OnClickListener() { //Activamos el Listener del boton Aceptar
            @Override
            public void onClick(View v) {

                nombre =eUsuario.getText().toString();//Cargamos los datos en las variables
                contrasena =eContrasena.getText().toString();
                rContrasena =eRContrasena.getText().toString();
                Email =eEmail.getText().toString();

                if (nombre.equals("")|| contrasena.equals("")||rContrasena.equals("")||Email.equals("")){
                    Toast.makeText(getApplicationContext(),"Debes digitar todos los campos", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent =new Intent();
                    intent.putExtra("nombre",nombre);
                    intent.putExtra("contrasena",contrasena);
                    intent.putExtra("Emil",Email);
                    setResult(RESULT_OK, intent);
                    finish();
                }

            }
        });
        bCancelar.setOnClickListener(new View.OnClickListener() { //Activamos el Listener del boton Cancelar
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED); //Respondemos el LogginActivity indicando que se cancelo
                finish();

            }
        });
    }
}