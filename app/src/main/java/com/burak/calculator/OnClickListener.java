package com.burak.calculator;

import android.view.View;

import android.widget.Button;
public class OnClickListener implements View.OnClickListener {

    private final Definition def;
    private final MainActivity main;
    public OnClickListener(Definition def,MainActivity main) {
        this.def = def;
        this.main=main;
    }

    @Override
    public void onClick(View v) {
        if (v instanceof Button) {
            Button clickedButton = (Button) v;
            String buttonText = clickedButton.getText().toString();

            if (main.sayimi(buttonText)) {
                main.burada_yazdir(buttonText);
            }
            else if (buttonText.equals("C")) {
                def.yazdirma = "";
                def.textView2.setText("");
                def.textView3.setText("");
                def.sayi1 = 0;
                def.sayi2 = 0;
                def.sonuc = 0;
            }
            else if (buttonText.equals("←")) {
                if (!def.yazdirma.equals("")) {
                    main.tekrarbasma();
                    main.burada_yazdir("");
                }
            }
            else if (def.textView3.getText().toString().equals("") && buttonText.equals("-")) {
                main.burada_yazdir(buttonText);
            }
            else {
                main.islembutonlari(buttonText);
            }
        }
    }
    public void setOnClickListenerForButtons() {
        def.button00.setOnClickListener(this);
        def.button0.setOnClickListener(this);
        def.button1.setOnClickListener(this);
        def.button2.setOnClickListener(this);
        def.button3.setOnClickListener(this);
        def.button4.setOnClickListener(this);
        def.button5.setOnClickListener(this);
        def.button6.setOnClickListener(this);
        def.button7.setOnClickListener(this);
        def.button8.setOnClickListener(this);
        def.button9.setOnClickListener(this);

        def.buttontoplam.setOnClickListener(this);
        def.buttoncikar.setOnClickListener(this);
        def.buttoncarp.setOnClickListener(this);
        def.buttonbol.setOnClickListener(this);
        def.buttonus.setOnClickListener(this);

        def.buttonsil.setOnClickListener(this);
        def.buttonc.setOnClickListener(this);
        def.buttonesittir.setOnClickListener(this);
        def.buttonnokta.setOnClickListener(this);
    }
}