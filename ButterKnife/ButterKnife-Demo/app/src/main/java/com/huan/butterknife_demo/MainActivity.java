package com.huan.butterknife_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindArray;
import butterknife.BindDimen;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.OnLongClick;
import butterknife.OnTextChanged;
import butterknife.OnTouch;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_text)
    TextView textView;
    @BindViews({R.id.bt_button1,R.id.bt_button2})
    List<Button> buttonList;
    @BindString(R.string.app_name)
    String appName;
//    @BindArray(R.array.swordsman)
//    String[] swordsman;
//    @BindDimen(R.dimen.activity_horizontal_margin)
//    float margin;


    @OnClick(R.id.bt_button1)
    public void showToast(){
        Toast.makeText(this,"Onclick",Toast.LENGTH_SHORT).show();
    }

    @OnTextChanged(value=R.id.et_edittext,callback = OnTextChanged.Callback.BEFORE_TEXT_CHANGED)
    void beforeTextChanged(CharSequence s,int start,int count,int after){

    }

    @OnTextChanged(value = R.id.et_edittext,callback = OnTextChanged.Callback.TEXT_CHANGED)
        void OnTextChanged(CharSequence s,int start,int before,int count){

    }

//    @OnTextChanged(value = R.id.et_edittext,callback =OnTextChanged.Callback.AFTER_TEXT_CHANGED)
//        void afterTextChanged(Exception s){
//
//    }
    @OnTouch(R.id.bt_button2)
        public boolean onTouch(View view, MotionEvent event){
        return true;
    }
//    @OnItemClick(R.id.lv_list)
//        void OnItemClick(int position){
//        Toast.makeText(this,"Onclick"+position,Toast.LENGTH_SHORT).show();
//    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        textView.setText("BindView");
        buttonList.get(0).setText("button1");
        buttonList.get(1).setText("button2");

    }
}
