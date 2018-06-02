package android.lifeistech.com.clapcamp;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import java.net.ContentHandler;

/**
 * Created by kawamuradaisuke on 2018/06/01.
 */

public class Clap {
    //音楽プレイヤー
    private SoundPool soundPool;
    //読み込んだ音声のID
    private int soundid;

    //Clapインスタンスを作り、初期化する
    public Clap(Context context){
        //新しいSoundPoolインスタンスを生成
        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC,0);
        //音声ファイルを読み込む
        soundid = soundPool.load(context,R.raw.clap,1);
    }

    public void play(){
        soundPool.play(soundid,1.0f,1.0f,0,0,1.0f);
    }

    //手拍子を再生するメソッド
    public void repeatPlay(int repeat){
        //繰り返した回数をカウントする変数
        int count = 0;

        while (count < repeat){
            //playメソッドで音声を再生
            play();

            count++;

            //プログラム実行を一時停止
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
