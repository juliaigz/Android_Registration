# Android_Registration
### This is an android project made in java and xml , the purpose is to make a registration project to register a new user.

```bash
near call <your deployed contract> hello --account-id <username>.testnet
```

Tecnology Used 
<img src="https://img.shields.io/badge/-xml-yellowgreen"> 
<img src="https://img.shields.io/badge/-java-red">

STEP 1 = Doing the design in XML
![image](https://github.com/juliaigz/Android_Register/assets/40221707/0b516cef-99eb-4ec6-908f-d82dae97c697)

STEP 2 = Doing the MainActivity java 

 The id of the xml objects are connected with the objects 
 
 textNombre = (EditText) findViewById(R.id.textNombre);
 
 textApellido = (EditText) findViewById(R.id.textApellido);
 
 textEmail = (EditText) findViewById(R.id.textEmail);
 
 textPassword = (EditText) findViewById(R.id.textPassword);
 
 buttonRegistrarse =(Button) findViewById(R.id.buttonRegistrarse);
 
 The class intent  is declared and iniciated to connect with the next activity.
 
 Intent intent = new Intent(MainActivity.this, MainActivity2.class);
 
 intent.putExtra("nombre", nombre);
 
 intent.putExtra("apellido", apellido);
 
 intent.putExtra("correo", correo);
 
 intent.putExtra("clave", clave);
 
 startActivity(intent); 
 
![image](https://github.com/juliaigz/Android_Registration/assets/40221707/9a8b562b-cb8e-444f-bb28-894df9dece0a)
![image](https://github.com/juliaigz/Android_Registration/assets/40221707/4e762da6-6098-4a0d-9c70-780404d84c67)

STEP 3 = Conecting MainActiviy Java with MainActivity2

It is connected with the intent class

Intent intent = getIntent();

![image](https://github.com/juliaigz/Android_Registration/assets/40221707/24aa3fe8-8675-423f-afc0-2fdba43481db)

