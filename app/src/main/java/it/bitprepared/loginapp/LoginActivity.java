package it.bitprepared.loginapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class LoginActivity extends Activity {

    EditText txtUserName;
    EditText txtCognome;
    Button btnLogin;
    Button btnCancel;
    ImageView immagine;
    TextView txtMessaggio;

    ArrayList<Ragazzi> ragazzi;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        txtUserName = this.findViewById(R.id.txtUname);
        txtCognome = this.findViewById(R.id.txtPwd);
        btnLogin = this.findViewById(R.id.btnLogin);
        btnCancel = this.findViewById(R.id.btnCancel);
        immagine = this.findViewById(R.id.immagine);
        txtMessaggio = this.findViewById(R.id.txtErrore);

        ragazzi = new ArrayList<>();

        loadJsonRagazzi(ragazzi);
        ragazzi.add(new Ragazzi("nome", "cognome", Ragazzi.Rossi));

        btnLogin.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Ragazzi allievo = new Ragazzi(txtUserName.getText().toString().toLowerCase().trim(),
                        txtCognome.getText().toString().toLowerCase().trim());
                int index = ragazzi.indexOf(allievo);

                if (index > -1) {
                    allievo = ragazzi.get(index);
                    Intent intent = new Intent(LoginActivity.this, CostigiolaSq.class);
                    intent.putExtra("sq", allievo.sq);
                    startActivity(intent);
                } else {
                    txtMessaggio.setText(R.string.errore);
                }

            }
        });

        btnCancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                txtUserName.setText("");
                txtCognome.setText("");
                txtMessaggio.setText("");
            }
        });

    }

    private void loadJsonRagazzi(ArrayList<Ragazzi> ragazzi) {

        InputStream inputStream = getResources().openRawResource(R.raw.ragazzi);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int ctr;
        try {
            ctr = inputStream.read();
            while (ctr != -1) {
                byteArrayOutputStream.write(ctr);
                ctr = inputStream.read();
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            // Parse the data into jsonobject to get original data in form of json.
            JSONObject jObject = new JSONObject(byteArrayOutputStream.toString());
            JSONArray jObjectResult = jObject.getJSONArray("ragazzi");
            String catName;
            String catSurname;
            String catSq;

            for (int i = 0; i < jObjectResult.length(); i++) {
                catName = jObjectResult.getJSONObject(i).getString("nome");
                catSurname = jObjectResult.getJSONObject(i).getString("cognome");
                catSq = jObjectResult.getJSONObject(i).getString("squadriglia");
                ragazzi.add(new Ragazzi(catName, catSurname, catSq));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
