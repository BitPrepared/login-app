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

import java.util.ArrayList;

public class LoginActivity extends Activity {

    EditText txtUserName;
    EditText txtCognome;
    Button btnLogin;
    Button btnCancel;
    ImageView immagine;
    TextView txtMessaggio;

//    int numeroRagazzi;
//    int numeroSq;
    ArrayList<Ragazzi> ragazzi;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        txtUserName = (EditText) this.findViewById(R.id.txtUname);
        txtCognome = (EditText) this.findViewById(R.id.txtPwd);
        btnLogin = (Button) this.findViewById(R.id.btnLogin);
        btnCancel = (Button) this.findViewById(R.id.btnCancel);
        immagine = (ImageView) this.findViewById(R.id.immagine);
        txtMessaggio = (TextView) this.findViewById(R.id.txtErrore);

        ragazzi = new ArrayList<>();
//	        riempiRagazzi();

// Sq femminile Phoenix
        ragazzi.add(new Ragazzi("nome", "cognome", Ragazzi.Rossi));

        btnLogin.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Ragazzi allievo = new Ragazzi(txtUserName.getText().toString().toLowerCase().trim(),
                        txtCognome.getText().toString().toLowerCase().trim());
                int index = ragazzi.indexOf(allievo);

                if (index > -1) {
                    allievo = ragazzi.get(index);
                    Intent intent = new Intent(LoginActivity.this, CostigiolaSq.class);
                    intent.putExtra("sq", allievo.sq);
                    startActivity(intent);
                } else {
                    txtMessaggio.setText(R.string.Errore);
                }

            }
        });

        btnCancel.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                txtUserName.setText(R.string.vuota);
                txtCognome.setText(R.string.vuota);
                txtMessaggio.setText(R.string.vuota);
            }
        });

    }

    public void riempiRagazzi() {
             /* ATTENZIONE:
              * per aggiungere i ragazzi basta copiare e incollare la riga sottostante. Le sq sono:
	 		 * Bianchi: Scimmia pazza
	 		 * Rossi: Cetriolo di mare
	 		 * Verdi: Vecchia signora
	 		 * Gialli: Jolly rasta
	 		 *
	 		 * Che corrispondono ad ogni sq
	 		 */
        //Sq maschile Cetriolo di mare
//	 		ragazzi.add(new Ragazzi("martino","mogna",Ragazzi.Rossi));
//	 		ragazzi.add(new Ragazzi("antonio","gallusi",Ragazzi.Rossi));
//	 		ragazzi.add(new Ragazzi("riccardo","sagramoni",Ragazzi.Rossi));
//	 		ragazzi.add(new Ragazzi("filippo","falezza",Ragazzi.Rossi));
//	 		ragazzi.add(new Ragazzi("federico","pellissero",Ragazzi.Rossi));
//	 		ragazzi.add(new Ragazzi("cristiano","cavezzale",Ragazzi.Rossi));
//	 		ragazzi.add(new Ragazzi("giovanni","casari",Ragazzi.Rossi));
//
//
//	 		//Sq maschile Jolly rasta
//	 		ragazzi.add(new Ragazzi("agnese","lena",Ragazzi.Gialli));
//	 		ragazzi.add(new Ragazzi("emma","bonotti",Ragazzi.Gialli));
//	 		ragazzi.add(new Ragazzi("chiara","santarelli",Ragazzi.Gialli));
//	 		ragazzi.add(new Ragazzi("silvia","piccheri",Ragazzi.Gialli));
//
//	 		//Sq feminile vecchia signora
////	 		ragazzi.add(new Ragazzi("sara","rissetto",Ragazzi.Verdi));
////	 		ragazzi.add(new Ragazzi("giulia","scattolon",Ragazzi.Verdi));
////	 		ragazzi.add(new Ragazzi("elizabeth","rota",Ragazzi.Verdi));
////	 		ragazzi.add(new Ragazzi("francesca","dodici",Ragazzi.Verdi));
////	 		ragazzi.add(new Ragazzi("arianna","casaroli",Ragazzi.Verdi));
//
//	 		//Sq feminile scimmia pazza
//	 		ragazzi.add(new Ragazzi("assunta","pellegrino",Ragazzi.Bianchi));
//	 		ragazzi.add(new Ragazzi("francesca","vannini",Ragazzi.Bianchi));
//	 		ragazzi.add(new Ragazzi("martina","tiraboschi",Ragazzi.Bianchi));
//	 		ragazzi.add(new Ragazzi("valentina","decuzzi",Ragazzi.Bianchi));
    }
}
