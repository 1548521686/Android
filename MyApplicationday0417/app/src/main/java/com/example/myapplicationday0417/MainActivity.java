package com.example.myapplicationday0417;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    private Button button1;
    private  Button button2;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);

        editText1=findViewById(R.id.editText1);
        editText2=findViewById(R.id.editText2);
        editText3=findViewById(R.id.editText3);

        textView1=findViewById(R.id.textView1);
        textView2=findViewById(R.id.textView2);
        textView3=findViewById(R.id.textView3);
        button1.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           //参数为（名字，模式），MODE_PRIVATE为默认模式，代表该文件是私有数据，只能被应用本身访问，在该模式下写入的内容会覆盖原文件的内容。
                                           //除了这种模式还有MODE_WORLD_REDABLE（可以被其他应用读取）
                                           //安卓为了应用共享安全，这样的方法已经行不通了
                                           SharedPreferences.Editor
                                                   editor=getSharedPreferences("cong",MODE_PRIVATE).edit();
                                           editor.putString("name",editText1.getText().toString());
                                           //这里要进行类型转换
                                           editor.putInt("age",Integer.parseInt(editText2.getText().toString()));
                                           editor.putString("sex",editText3.getText().toString());
                                           editor.apply();//无返回值
                                           editor.commit();//直接提交一个返回值，这是同步存储的方式
                                           button2.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   SharedPreferences pref = getSharedPreferences("cong", MODE_PRIVATE);
                                                   //根据key获取值，后面为默认值
                                                   String name = pref.getString("name", "");
                                                   int age = pref.getInt("age", 0);
                                                   String str = age + "";
                                                   String sex = pref.getString("sex", "");
                                                   //写入到textview中
                                                   textView1.setText(name);
                                                   textView2.setText(str);
                                                   textView3.setText(sex);
                                               }});
                                               }
                                           });}}