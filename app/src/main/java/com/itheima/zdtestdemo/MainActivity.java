package com.itheima.zdtestdemo;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    private static final int MAX_PROGRESS = 100;
    String[] single_list = {"男", "女", "女博士", "程序员"};
    String[] multi_list = {"篮球", "足球", "男生", "女生"};
    String[] item_list = {"项目经理", "策划", "测试", "美工", "程序猿"};
    ArrayList<Integer> MultiChoiceID = new ArrayList<Integer>();
    final String[] mItems = {"item0", "item1", "itme2", "item3", "itme4", "item5", "item6"};
    private ProgressDialog mProgressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initEvent();
    }

    /**
     * 初始化点击事件
     */
    private void initEvent() {
        findViewById(R.id.dialog_bt1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogNum1();
            }


        });
        findViewById(R.id.dialog_bt2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogNum2();
            }


        });
        findViewById(R.id.dialog_bt3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogNum3();
            }


        });
        findViewById(R.id.dialog_bt4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogNum4();
            }


        });
        findViewById(R.id.dialog_bt5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogNum5();
            }


        });
        findViewById(R.id.dialog_bt6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                owDialogNum6();

            }


        });
        findViewById(R.id.dialog_bt7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                owDialogNum7();   不太稳定，后续完善

            }


        });

    }


    private void showDialogNum1() {
        AlertDialog.Builder aBuilder = new AlertDialog.Builder(MainActivity.this);
        aBuilder.setTitle("确认对话框");
        aBuilder.setIcon(R.mipmap.ic_launcher);
        aBuilder.setMessage("您是否要去北京呐？？");
        aBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "你点击了确定按钮哦", LENGTH_SHORT).show();
            }
        });
        aBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(MainActivity.this, "你点击了取消按钮哦", LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = aBuilder.create();//获取dialog
        dialog.show();//显示出来哦！！！
    }

    private void showDialogNum2() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("选择性别");//设置标题
        builder.setIcon(R.mipmap.ic_launcher);//设置图标
        builder.setSingleChoiceItems(single_list, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                String str = single_list[which];
                Toast.makeText(MainActivity.this, "这个人是" + str + "！",
                        Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();//获取dialog
        dialog.show();//显示对话框
    }

    private void showDialogNum3() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("选择爱好");//设置标题
        builder.setIcon(R.mipmap.ic_launcher);//设置图标
        builder.setMultiChoiceItems(multi_list, null, new DialogInterface.OnMultiChoiceClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                // TODO Auto-generated method stub
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "我喜欢上了" + multi_list[which] + "！",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "我不喜欢" + multi_list[which] + "了！",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();//获取dialog
        dialog.show();//显示对话框
    }

    /**
     * 显示列表对话框
     */
    private void showDialogNum4() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("部门列表");//设置标题
        builder.setIcon(R.mipmap.ic_launcher);//设置图标
        builder.setItems(item_list, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                Toast.makeText(MainActivity.this, "我点击了" + item_list[which] + "！",
                        Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();//获取dialog
        dialog.show();//显示对话框
        //设置大小
        WindowManager.LayoutParams layoutParams = dialog.getWindow().getAttributes();
        layoutParams.width = 500;
        layoutParams.height = ActionBar.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(layoutParams);
    }

    /**
     * 显示自定义对话框
     */
    private void showDialogNum5() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.dialog_layout, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("自定义对话框");//设置标题
        builder.setIcon(R.mipmap.ic_launcher);//设置图标
        builder.setView(view);
        AlertDialog dialog = builder.create();//获取dialog
        dialog.show();//显示对话框
    }


    private void owDialogNum6() {

        mProgressDialog = new ProgressDialog(MainActivity.this);
        mProgressDialog.setIcon(R.mipmap.ic_launcher);
        mProgressDialog.setTitle("进度条窗口");
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mProgressDialog.setMax(MAX_PROGRESS);

        mProgressDialog.setButton("确定", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //这里添加点击后的逻辑
            }
        });
        mProgressDialog.setButton2("取消", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //这里添加点击后的逻辑
            }
        });
        mProgressDialog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {

                int Progress = 0;
                while (Progress < MAX_PROGRESS) {
                    try {
                        Thread.sleep(200);
                        Progress++;
                        mProgressDialog.incrementProgressBy(1);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }


                }


            }
        }).start();
    }


    private void owDialogNum7() {

       /* MultiChoiceID 用于记录多选选中的id号 存在ArrayList中
        选中后 add 进ArrayList
        取消选中后 remove 出ArrayList。*/


        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        MultiChoiceID.clear();
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("可多项选择");
        builder.setMultiChoiceItems(mItems,
                new boolean[]{false, false, false, false, false, false, false},
                new DialogInterface.OnMultiChoiceClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton,
                                        boolean isChecked) {
                        if (isChecked) {
                            MultiChoiceID.add(whichButton);
//                            Toast.makeText(this,"你选择的id为" + whichButton + " , " + mItems[whichButton],Toast).show();
                        } else {
                            MultiChoiceID.remove(whichButton);
                        }

                    }
                });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String str = "";
                int size = MultiChoiceID.size();
                for (int i = 0; i < size; i++) {
                    str += mItems[MultiChoiceID.get(i)] + ", ";
                }
//                showDialog("你选择的是" + str);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

            }
        });
        builder.create().show();
    }


}