package com.noemialean.appudea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogginActivity extends AppCompatActivity {

    EditText eUsuario, eContrasena;
    Button bEntrar;
    TextView bRegistrar;


    private String nombre, contrasena, email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);

        eUsuario = (EditText) findViewById(R.id.eUsuario);
        eContrasena = (EditText) findViewById(R.id.eContrasena);
        bEntrar = (Button) findViewById(R.id.bEntrar);
        bRegistrar = (TextView) findViewById(R.id.bRegistrar);

        bRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogginActivity.this, RegistroActivity.class);
                startActivityForResult(intent, 1234);
            }
        });

        bEntrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String name, password;
                name=eUsuario.getText().toString();
                password=eContrasena.getText().toString();
                if ((name.equals("")||password.equals(""))){
                    Toast.makeText(getApplicationContext(),"Digite usuario y Contraseña", Toast.LENGTH_SHORT).show();
                } else {

                    if ((nombre.equals(name) && contrasena.equals(password))) {
                        Intent intent = new Intent(LogginActivity.this, MainActivity.class);
                        intent.putExtra("nombre",nombre);
                        intent.putExtra("email",email);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Usuario o Contraseña Incorrecta", Toast.LENGTH_SHORT).show();
                    }
                }
                }
            }
            );
}
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data ){
        if (requestCode == 1234 && resultCode == RESULT_CANCELED) {
            Toast.makeText(this,"Usuario no registrado",Toast.LENGTH_SHORT).show();
        } else {
            if (requestCode ==1234 && resultCode ==RESULT_OK ){
                nombre =data.getExtras().getString("nombre");
                contrasena =data.getExtras().getString("contrasena");
                email =data.getExtras().getString("email");
            }
        }
        super.onActivityResult(requestCode, resultCode,data);
    }

}
