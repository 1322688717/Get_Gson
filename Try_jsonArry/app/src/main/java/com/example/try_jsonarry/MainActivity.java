package com.example.try_jsonarry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * 作者：阿宅
 * 具体内容：Get+Gson实现从服务器上获取API数据，生成实体类并显示在TextView上
 */
public class MainActivity extends AppCompatActivity {
    private TextView one,two,three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //parseByGson();
        one = findViewById(R.id.tv_one);
        two = findViewById(R.id.tv_two);
        three = findViewById(R.id.tv_three);
        parseByGson();


    }


    private void parseByGson() {
        Gson gson = new Gson();
        //将对象变成json字符串
        Bean bean = new Bean("ok", "zh_CN", "metric", "Asia/Shanghai");
        String str = gson.toJson(bean);
        Log.e("TAG", "将Bean对象变成json字符串：" + str);
        //将json字符串变成对象
        Bean msg = gson.fromJson(str, Bean.class);
        Log.e("TAG", "" + msg);
        Log.e("TAG", "状态=" + msg.getStatus() + "       lang值=" + msg.getLang()
                + "       单位=" + msg.getUnit() + "     时区" + msg.getTimezone());


       // ================解析一个实际的字符串
        new Thread() {
            @Override
            public void run() {
                super.run();
                //运行get方法得到彩云的json对象
                String json = get();
                //拿到json对象
                Msg msg1 = gson.fromJson(json, Msg.class);
                //拿到对象集合
                List<Msg.Mdata> dataList = msg1.getData();
                Log.e("TAG", "==================================");
                Log.e("TAG", "这里是json字符串转换成Msg对象:" + msg1);
                Log.e("TAG", "其中message：" + msg1.getMessage());
                Log.e("TAG", "其中code：" + msg1.getCode());
                Log.e("TAG", "其中mdata：" + dataList);
                Log.e("TAG", "其中StatusId：" + dataList.get(0).getStatusId());
                Log.e("TAG", "其中：statusInstrumentId:" + dataList.get(0).getStatusInstrumentId());
                Log.e("TAG", "其中statusRealTemp：" + dataList.get(0).getStatusRealTemp());
                Log.e("TAG", "其中StatusSpinUserName：" + dataList.get(0).getStatusSpinUserName());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        one.setText("StatusRealTemp="+dataList.get(0).getStatusRealTemp());
                        one.setTextSize(30);
                        two.setText("StatusSpinUserName="+dataList.get(0).getStatusSpinUserName());
                        two.setTextSize(30);
                        three.setText("StatusSpin="+dataList.get(0).getStatusSpin());
                        three.setTextSize(30);
                    }
                });
            }


        }.start();

    }

    //=================================get请求
    public static String get(){
        try {
            //实例化一个URL对象
            URL url = new URL("http://192.168.0.101:8080//Monitor/webApi/instrument/selectInstStatus.do?userId=1&instId=1");
            try {
                //获取HttpURLConnection实例
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                //设置和请求相关的属性
                conn.setRequestMethod("GET");
                conn.setConnectTimeout(6000);
                //获取响应码并获取响应数据
                if(conn.getResponseCode()==HttpURLConnection.HTTP_OK){
                    //实例化一个响应流
                    InputStream in = conn.getInputStream();
                    //实例化一个数组
                    byte[] b = new byte[1024];
                    //int一个长度
                    int len = 0;
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    //将字节数组里面的内容写入缓存流
                    while((len = in.read(b))>-1){
                        //参数一：待写入的数组   参数二：起点    参数三：长度
                        baos.write(b,0,len);
                    }
                    //在控制台上显示出获取的数据
                    String msg = new String(baos.toByteArray());
                    Log.e("TAG",msg+"===这里是get方法拿到的json对象");
                    return msg;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}