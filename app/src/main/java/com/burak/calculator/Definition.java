package com.burak.calculator;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Definition {

    Button button00,button0,button1,button2,button3,button4,button5,button6,button7,button8,button9;
    Button buttonesittir,buttontoplam,buttoncikar,buttoncarp,buttonbol,buttonc,buttonnokta,buttonsil,buttonus;
    TextView textView2, textView3;
    String yazdirma="";
    double sayi1,sayi2,sonuc;

    public Definition(View v){
        textView2 = v.findViewById(R.id.textView2);
        textView3 = v.findViewById(R.id.textView3);

        button00 = v.findViewById(R.id.button00);
        button0 = v.findViewById(R.id.button0);
        button1 = v.findViewById(R.id.button1);
        button2 = v.findViewById(R.id.button2);
        button3 = v.findViewById(R.id.button3);
        button4 = v.findViewById(R.id.button4);
        button5 = v.findViewById(R.id.button5);
        button6 = v.findViewById(R.id.button6);
        button7 = v.findViewById(R.id.button7);
        button8 = v.findViewById(R.id.button8);
        button9 = v.findViewById(R.id.button9);

        buttonesittir=v.findViewById(R.id.buttonesittr);
        buttontoplam=v.findViewById(R.id.buttonToplam);
        buttoncikar=v.findViewById(R.id.buttoncikar);
        buttoncarp=v.findViewById(R.id.buttoncarp);
        buttonbol=v.findViewById(R.id.buttonbol);
        buttonc=v.findViewById(R.id.buttonC);
        buttonnokta=v.findViewById(R.id.buttonNokta);
        buttonsil=v.findViewById(R.id.buttonsil);
        buttonus=v.findViewById(R.id.buttonus);
    }
}
