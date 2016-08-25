package edu.feicui.actionbuttonsdome;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_dome1,btn_dome2,btn_dome3,btn_dome4,btn_dome5;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initbtn();
        onclickbtn();

    }


    private void onclickbtn() {
        btn_dome1.setOnClickListener(this);
        btn_dome2.setOnClickListener(this);
        btn_dome3.setOnClickListener(this);
        btn_dome4.setOnClickListener(this);
        btn_dome5.setOnClickListener(this);

    }

    private void initbtn() {
        btn_dome1 = (Button) findViewById(R.id.btn_dome1);
        btn_dome2 = (Button) findViewById(R.id.btn_dome2);
        btn_dome3 = (Button) findViewById(R.id.btn_dome3);
        btn_dome4 = (Button) findViewById(R.id.btn_dome4);
        btn_dome5 = (Button) findViewById(R.id.btn_dome5);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_dome1:

                //    通过AlertDialog.Builder这个类来实例化我们的一个AlertDialog的对象
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                //    设置Title的图标
                builder.setIcon(R.drawable.ic_launcher);
                //    设置Title的内容
                builder.setTitle("弹出警告框");
                //    设置Content来显示一个信息
                builder.setMessage("确定删除吗？");
                //    设置一个PositiveButton
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        Toast.makeText(MainActivity.this, "positive: " + which, Toast.LENGTH_SHORT).show();
                    }
                });
                //    设置一个NegativeButton
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        Toast.makeText(MainActivity.this, "negative: " + which, Toast.LENGTH_SHORT).show();
                    }
                });

                //    设置一个NeutralButton
                builder.setNeutralButton("忽略", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        Toast.makeText(MainActivity.this, "neutral: " + which, Toast.LENGTH_SHORT).show();
                    }
                });
                //    显示出该对话框
                builder.show();

                break;

            case R.id.btn_dome2:

                builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.ic_launcher);
                builder.setTitle("选择一个城市");
                //    指定下拉列表的显示数据
                final String[] cities = {"广州", "上海", "北京", "香港", "澳门"};
                //    设置一个下拉的列表选择项
                builder.setItems(cities, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        Toast.makeText(MainActivity.this, "选择的城市为：" + cities[which], Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();

                break;
            case R.id.btn_dome3:

                builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.ic_launcher);
                builder.setTitle("请选择性别");
                final String[] sex = {"男", "女", "未知性别"};
                //    设置一个单项选择下拉框
                /**
                 * 第一个参数指定我们要显示的一组下拉单选框的数据集合
                 * 第二个参数代表索引，指定默认哪一个单选框被勾选上，1表示默认'女' 会被勾选上
                 * 第三个参数给每一个单选项绑定一个监听器
                 */
                builder.setSingleChoiceItems(sex, 1, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        Toast.makeText(MainActivity.this, "性别为：" + sex[which], Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {

                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {

                    }
                });
                builder.show();

                break;
            case R.id.btn_dome4:

                builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.ic_launcher);
                builder.setTitle("爱好");
                final String[] hobbies = {"篮球", "足球", "网球", "斯诺克"};
                //    设置一个单项选择下拉框
                /**
                 * 第一个参数指定我们要显示的一组下拉多选框的数据集合
                 * 第二个参数代表哪几个选项被选择，如果是null，则表示一个都不选择，如果希望指定哪一个多选选项框被选择，
                 * 需要传递一个boolean[]数组进去，其长度要和第一个参数的长度相同，例如 {true, false, false, true};
                 * 第三个参数给每一个多选项绑定一个监听器
                 */
                builder.setMultiChoiceItems(hobbies, null, new DialogInterface.OnMultiChoiceClickListener() {
                    StringBuffer sb = new StringBuffer(100);

                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            sb.append(hobbies[which] + ", ");
                        }
                        Toast.makeText(MainActivity.this, "爱好为：" + sb.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();

                break;

            case R.id.btn_dome5:

                builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.ic_launcher);
                builder.setTitle("请输入用户名和密码");
                //    通过LayoutInflater来加载一个xml的布局文件作为一个View对象
                view = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog, null);
                //    设置我们自己定义的布局文件作为弹出框的Content
                builder.setView(view);

                final EditText username = (EditText)view.findViewById(R.id.username);
                final EditText password = (EditText)view.findViewById(R.id.password);

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        String a = username.getText().toString().trim();
                        String b = password.getText().toString().trim();
                        //    将输入的用户名和密码打印出来
                        Toast.makeText(MainActivity.this, "用户名: " + a + ", 密码: " + b, Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {

                    }
                });
                builder.show();

                break;

        }
    }
}
