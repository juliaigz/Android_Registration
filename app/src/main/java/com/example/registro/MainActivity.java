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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText textNombre;
    EditText textApellido;
    EditText textEmail;
    EditText textPassword;

    Button buttonRegistrarse;
    String pass = "1234";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textNombre = (EditText) findViewById(R.id.textNombre);
        textApellido = (EditText) findViewById(R.id.textApellido);
        textEmail = (EditText) findViewById(R.id.textEmail);
        textPassword = (EditText) findViewById(R.id.textPassword);

        buttonRegistrarse =(Button) findViewById(R.id.buttonRegistrarse);

        buttonRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //toast
                Context context = getApplicationContext();
                CharSequence text = "Datos vacios";
                CharSequence text2 = "error de password";
                CharSequence text3 = "solo se permiten letras, nombre y apellido no validos";
                CharSequence text4 = "formato de correo no valido";
                int duracion = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duracion);
                Toast toast2 = Toast.makeText(context, text2, duracion);
                Toast toast3 = Toast.makeText(context, text3, duracion);
                Toast toast4 = Toast.makeText(context, text4, duracion);


                // obtenemos los datos del usuario.
                String nombre = textNombre.getText().toString();
                String apellido = textApellido.getText().toString();
                String correo = textEmail.getText().toString();
                String clave = textPassword.getText().toString();

                //validamos campos vacios
                if ((!textNombre.getText().toString().trim().equals("")) && (!textApellido.getText().toString().trim().equals(""))
                        && (!textEmail.getText().toString().trim().equals(""))) {
                    //patrones de validacion
                    Pattern pat = Pattern.compile("[a-zA-Z]{2,10}");
                    Pattern patEmail = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
                    Matcher mat = pat.matcher(textNombre.getText().toString());
                    Matcher mat2 = pat.matcher(textApellido.getText().toString());
                    Matcher mat3 = patEmail.matcher(textEmail.getText().toString());
                    //validamos que nombre y apellido sean validos, letras mayusculas y minusculas
                    if (mat.matches() && mat2.matches()) {
                        //validamos formato de correo
                        if (mat3.matches()) {
                            //validamos contraseña
                            if (textPassword.getText().toString().equals(pass)) {
                                //creamos intent para iniciar la segunda actividad.
                                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                                intent.putExtra("nombre", nombre);
                                intent.putExtra("apellido", apellido);
                                intent.putExtra("correo", correo);
                                intent.putExtra("clave", clave);
                                startActivity(intent);

                            } else {
                                toast2.show();
                            }
                        } else {
                            toast4.show();
                        }

                    } else {
                        toast3.show();
                    }

                } else {toast.show();}
            }
            });
    }

    }


