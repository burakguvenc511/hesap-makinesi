package com.burak.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Definition def;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        def = new Definition(findViewById(android.R.id.content));
        OnClickListener click = new OnClickListener(def,this);
        click.setOnClickListenerForButtons(); // Düğmeleri dinlemek için
    }
    public void islembutonlari(String islem){
        if(!def.yazdirma.equals("")){
            if(def.yazdirma.charAt(def.yazdirma.length()-1)=='.') {return;}
            if(def.yazdirma.charAt(def.yazdirma.length()-1)=='+' ||
                    def.yazdirma.charAt(def.yazdirma.length()-1)=='-'||
                    def.yazdirma.charAt(def.yazdirma.length()-1)=='x'||
                    def.yazdirma.charAt(def.yazdirma.length()-1)=='/'||
                    def.yazdirma.charAt(def.yazdirma.length()-1)=='^'){
                if(islem.equals(".")){ return;}
                else if(islem.equals("=")){ return;}
                tekrarbasma();
            }
            else{
                if(islem.equals("=")){
                    oncesindeislemvarmi();
                    return;
                }
                if(islem.equals(".")){
                    if(noktavarmi()){
                        System.out.println("return çalışmadı");
                        return;
                    }
                }
                else {
                    islemyap();
                }
            }
            if(!islem.equals("=")){
                burada_yazdir(islem);
            }
        }
    }        // işlem olarak atanmış butonların çalışma sistemleri
    public  boolean sayimi(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }             // clicklistener için basılan butonun sayısal bir değer olup olmadığını try catch yöntemi ile güvenceye alır.
    public  boolean noktavarmi(){
        String harf;
        String tut=def.yazdirma.substring(1);
        String[] islemler = {"+", "-", "x", "/","^"};
        int islemyok=0;

        for (String islem : islemler) {
            if (tut.contains(islem)) {
                int index = tut.indexOf(islem);
                harf = tut.substring(index, tut.length());
                if (harf.contains(".")) {
                    return true;
                }
            }
            else {
                islemyok++;
            }
        }
        if(islemyok==5){
            harf=tut.substring(0, tut.length());
            if(harf.contains(".")){
                return true;
            }
        }
        return false;
    }                    // 3.6.3 gibi alakasız bir sayı değerini onlemek için kullanılan fonksiyon
    public  void tekrarbasma(){
        def.yazdirma = def.yazdirma.substring(0, def.yazdirma.length() - 1);
    }                      // üst üste iki kere işlem butonuna basılması durumunda çalışır ve ilk basmayı yok eder.
    public void oncesindeislemvarmi(){
        if(def.yazdirma.contains("+")||
                def.yazdirma.contains("-")||
                def.yazdirma.contains("x")||
                def.yazdirma.contains("/")||
                def.yazdirma.contains("^")){
            islemyap();
        }
        else{
            def.textView2.setText(def.yazdirma);
        }
    }               // text içerisinde önceden atanmış bir işlem varmı diye kontrol etmek için fonkiyon
    public void burada_yazdir(String value) {
        def.yazdirma+=value;
        def.textView3.setText(def.yazdirma);
    }        // textView lere yazırmak için kullanılan fonkiyon
    public void islemyap() {
        char operator = '*';
        char karakter;
        int hedefindex=0;
        for (int i = 1; i < def.yazdirma.length(); i++) {
            karakter = def.yazdirma.charAt(i);
            if (karakter == '+' || karakter == '-' || karakter == 'x' || karakter == '/' || karakter == '^') {
                operator = karakter;
                hedefindex = i;
                break;
            }
        }


        if (hedefindex > 0) {
            String onceHarf = def.yazdirma.substring(0, hedefindex);
            String sonraHarf = def.yazdirma.substring(hedefindex + 1);
            onceHarf = onceHarf.replace(',', '.');
            def.sayi1 = Double.valueOf(onceHarf);
            def.sayi2 = Double.valueOf(sonraHarf);

            switch (operator) {
                case '+':
                    def.sonuc = def.sayi1 + def.sayi2;
                    break;
                case '-':
                    def.sonuc = def.sayi1 - def.sayi2;
                    break;
                case 'x':
                    def.sonuc = def.sayi1 * def.sayi2;
                    break;
                case '/':
                    def.sonuc = def.sayi1 / def.sayi2;
                    break;
                case '^':
                    def.sonuc = Math.pow(def.sayi1, def.sayi2);
                    break;
            }
            def.yazdirma = String.format("%.2f", def.sonuc);
            def.textView2.setText(String.format("%.2f", def.sonuc));
        }
    }                         // matematiksel işlemler ve metinin sayi olarak dönüştürülüp kullanıldığı fonkiyon

}