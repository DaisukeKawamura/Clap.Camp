package android.lifeistech.com.clapcamp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener {

    ImageButton button;
    Clap clapInstance;
    Spinner spinner;

    //繰り返しの回数
    int repeat = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (ImageButton)findViewById(R.id.ImgBtn);
        button.setOnClickListener(this);
        clapInstance = new Clap(this.getApplicationContext());
        spinner = (Spinner)findViewById(R.id.spinner);

        //表示する文字列を配列に準備
        String[] strArray = new String[5];
        strArray[0] = "パンッ！";
        strArray[1] = "パンパンッ！";
        strArray[2] = "パンパンパンッ！";
        strArray[3] = "４回";
        strArray[4] = "５回";

        //配列をspinnerに入れる型に変換
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,android.R.layout.simple_spinner_item,strArray
        );
        arrayAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        //spinnerに変化した配列をセット
        spinner.setAdapter(arrayAdapter);

        //spinnerが使われた時の処理をこのクラスで指定
        spinner.setOnItemSelectedListener(this);

    }


    //ボタンが押された時に呼ばれるメソッド
    /*さっき生成したClapクラスのインスタンスをの
    Playメソッドを呼び出すことで再生する*/
    @Override
    public void onClick(View v) {
//        clapInstance.play();
        clapInstance.repeatPlay(repeat);
    }


    //spinner項目が選択された時
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        //選択された番号の（０から数えた）番号＋１を繰り返しに設定
        //positionは選択された項目番号
        repeat = position + 1;

    }
    //spinnerで何も選択されなかった時
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
