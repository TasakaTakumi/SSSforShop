package com.socu.enpit.sssforshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nifcloud.mbaas.core.NCMB
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //**************** APIキーの設定とSDKの初期化 **********************
        NCMB.initialize(this, "d33534c7daf258e354c67e100f9923e1be23c347779ef8379e7f8596271ccc29", "f0354f95aba607910c5cb18b8d74d8df858880316963c04ecb9d07f66aef05b2")

        // ログインボタンを押したときの処理
        loginButton.setOnClickListener {
            // 画面遷移するにはまず「Intent」を用意する
            val intent = Intent(this, EditActivity::class.java)
            // 画面遷移した後に、バックキーでこの画面に戻って来れないようにする。
            // 画面遷移してきた順番は、スタックに保存されていく仕組みになっており、例えば
            // A → B → C → A → C と画面遷移した場合、バックキーを押すと
            // C → A → C → B → A と画面を逆にたどる。
            // ログイン画面に戻るのはいらないので消すフラグを立てた。
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}
