package com.example.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText textNombre;
    EditText textApellido;
    EditText textEmail;
    EditText textPassword;

    Button buttonRegistrarse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textNombre = findViewById(R.id.textNombre);
        textApellido = findViewById(R.id.textApellido);
        textEmail = findViewById(R.id.textEmail);
        textPassword = findViewById(R.id.textPassword);

        buttonRegistrarse  = findViewById(R.id.buttonRegistrarse);

        buttonRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // obtenemos los datos del usuario.
                String nombre = textNombre.getText().toString();
                String apellido = textApellido.getText().toString();
                String correo = textEmail.getText().toString();
                String clave = textPassword.getText().toString();

                //creamos intent para iniciar la segunda actividad.
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                intent.putExtra("nombre", nombre);
                intent.putExtra("apellido", apellido);
                intent.putExtra("correo", correo);
                intent.putExtra("clave", clave);
                startActivity(intent);

            }
        });


    }
}



