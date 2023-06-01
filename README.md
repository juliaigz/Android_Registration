# Android_Registration
### This is an android project made in java and xml , the purpose is to make a registration project to register a new user.

Tecnology Used 
<img src="https://img.shields.io/badge/-xml-yellowgreen"> 
<img src="https://img.shields.io/badge/-java-red">

STEP 1 = Doing the design in XML
![image](https://github.com/juliaigz/Android_Register/assets/40221707/0b516cef-99eb-4ec6-908f-d82dae97c697)

STEP 2 = Doing the MainActivity java 
This the java 
```bash
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
```


 The id of the xml objects are connected with the objects in java using R.id
```bash
        textNombre = (EditText) findViewById(R.id.textNombre);
        textApellido = (EditText) findViewById(R.id.textApellido);
        textEmail = (EditText) findViewById(R.id.textEmail);
        textPassword = (EditText) findViewById(R.id.textPassword);
        buttonRegistrarse =(Button) findViewById(R.id.buttonRegistrarse);
 ```
 The class intent  is declared and iniciated to connect with the next activity.
 
 ```bash
 Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                                intent.putExtra("nombre", nombre);
                                intent.putExtra("apellido", apellido);
                                intent.putExtra("correo", correo);
                                intent.putExtra("clave", clave);
                                startActivity(intent);
 ```
![image](https://github.com/juliaigz/Android_Registration/assets/40221707/9a8b562b-cb8e-444f-bb28-894df9dece0a)
![image](https://github.com/juliaigz/Android_Registration/assets/40221707/4e762da6-6098-4a0d-9c70-780404d84c67)

STEP 3 = Conecting MainActiviy Java with MainActivity2 Java

It is connected with the intent class
```bash
Intent intent = getIntent();
```
![image](https://github.com/juliaigz/Android_Registration/assets/40221707/24aa3fe8-8675-423f-afc0-2fdba43481db)

```bash
public class MainActivity2 extends AppCompatActivity {
    TextView mensaje;
    String nombre;
    String apellido;
    String correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mensaje = (TextView) findViewById (R.id.mensaje);

        Intent intent = getIntent();

        nombre = intent.getStringExtra("nombre");
        apellido = intent.getStringExtra("apellido");
        correo = intent.getStringExtra("correo");

        mensaje.setText("nombre:"+nombre + "apellido : "+ apellido+ "correo : "+ correo );

    }
}
 ```
 
# Individual 10 (working with binding instead of R.id)

## Build grade : module app

```bash
 //DATOS DEL DATA BINDING
    dataBinding {
        enabled = true
    }

    buildFeatures{
        viewBinding = true
    }
```
![image](https://github.com/juliaigz/Android_Registration/assets/40221707/231980e9-c67e-4085-889b-2a1825e57730)

## activity_main.xml

```bash
 <data>
        <variable
            name="textNombre"
            type="java.lang.String" />
        <variable
            name="textApellido"
            type="java.lang.String" />
        <variable
            name="textEmail"
            type="java.lang.String" />
        <variable
            name="textPassword"
            type="java.lang.String" />
    </data>
 ```
![image](https://github.com/juliaigz/Android_Registration/assets/40221707/f1fe0698-1d02-4e45-a060-9c7029e6dd03)

## MainActivity.java

```bash
public class MainActivity extends AppCompatActivity {
    EditText textNombre;
    EditText textApellido;
    EditText textEmail;
    EditText textPassword;
    Button buttonRegistrarse;
    String pass = "1234";

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        //binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setContentView(binding.getRoot());

        //textNombre = (EditText) findViewById(R.id.textNombre);
        //textApellido = (EditText) findViewById(R.id.textApellido);
        //textEmail = (EditText) findViewById(R.id.textEmail);
        //textPassword = (EditText) findViewById(R.id.textPassword);
        //buttonRegistrarse =(Button) findViewById(R.id.buttonRegistrarse);
        textNombre = binding.textNombre;
        textApellido = binding.textApellido;
        textEmail = binding.textEmail;
        textPassword = binding.textPassword;
        buttonRegistrarse = binding.buttonRegistrarse;
        
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
```
![image](https://github.com/juliaigz/Android_Registration/assets/40221707/7ceae34b-32af-44bd-a059-b424f6b9257b)




