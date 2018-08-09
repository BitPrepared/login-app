package it.bitprepared.loginapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CostigiolaSq extends AppCompatActivity {
    ImageView img;
    String sq;
    TextView txt;
    Bundle extras;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seconda);
        img = this.findViewById(R.id.immagine);
        txt = this.findViewById(R.id.textView1);

        if (savedInstanceState == null) {
            extras = getIntent().getExtras();
            if (extras == null) {
                sq = null;
            } else {
                sq = extras.getString("sq");
            }
        } else {
            sq = (String) savedInstanceState.getSerializable("sq");
        }

        if (sq == null){
            return;
        }

        if (sq.equals(Ragazzi.Bianchi)) {
            img.setImageResource(R.drawable.rad1);
        } else if (sq.equals(Ragazzi.Rossi)) {
            img.setImageResource(R.drawable.rad3);
        } else if (sq.equals(Ragazzi.Verdi)) {
            img.setImageResource(R.drawable.rad4);
        }
        txt.setText(getString(R.string.sei_stato_arrouolato, sq));

    }
}
