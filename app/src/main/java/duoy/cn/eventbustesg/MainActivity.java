package duoy.cn.eventbustesg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button btn;

    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //注册EventBus
        EventBus.getDefault().register(this);

        textView = (TextView) findViewById(R.id.text);
        msg = textView.getText().toString();
        Log.i("test",textView.getText()+"@@@"+textView.length());
        btn = (Button) findViewById(R.id.btn);
    }

    public void second(View view){

        if(msg.equals("1".trim())){
            Intent intent = new Intent(this,SecondActivity.class);
            startActivity(intent);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onTestEvent(TestEvent event){
        String i = event.getNum();
        textView.setText(i);
        msg = textView.getText().toString();
        Toast.makeText(this,i,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //反注册
        EventBus.getDefault().unregister(this);
    }
}
