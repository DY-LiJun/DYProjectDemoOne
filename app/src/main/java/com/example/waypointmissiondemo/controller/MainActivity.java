package com.example.waypointmissiondemo.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.waypointmissiondemo.model.MyWayPoints;
import com.example.waypointmissiondemo.utils.FileInput;
import com.example.waypointmissiondemo.R;
import com.example.waypointmissiondemo.model.WaypointMissionOperatorTool;
import com.example.waypointmissiondemo.utils.LoadOrSaveFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

//import dji.common.error.DJIError;
//import dji.common.mission.waypoint.Waypoint;
//import dji.common.mission.waypoint.WaypointMission;
//import dji.common.mission.waypoint.WaypointMissionState;
//import dji.common.util.CommonCallbacks;
//import dji.sdk.mission.MissionControl;
//import dji.sdk.mission.waypoint.WaypointMissionOperator;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    private Button startMission;
    private Button stopMission;

//    private WaypointMissionOperator mWaypointMissionOperator;
//    private WaypointMission mWaypointMission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startMission = findViewById(R.id.startMission);
        stopMission = findViewById(R.id.stopMisson);

        startMission.setOnClickListener(this);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_CALENDAR)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CALENDAR)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
        }

    }


    @Override
    public void onClick(View v) {
//        if(mWaypointMissionOperator == null){
//            mWaypointMissionOperator = MissionControl.getInstance().getWaypointMissionOperator();
//        }
        switch (v.getId()){
            case R.id.startMission:

                String myTxt = loadByAndroid("test.txt");
                System.out.println(myTxt);



//                WaypointMissionOperatorTool waypointMissionOperatorTool = new WaypointMissionOperatorTool();
//                FileInput file = new FileInput("com/example/waypointmissiondemo/resources/测试路线.txt");
//                LoadOrSaveFile loadOrSaveFile = new LoadOrSaveFile();
//                if(loadOrSaveFile.readFileByLine("com/example/waypointmissiondemo/resources/测试路线.txt")== null){
//                    System.out.println("输入为空");
//                }
//                System.out.println(loadOrSaveFile.readFileByLine("D:\\ProgramFiles(x86)\\Android\\WaypointMissionDemo\\app\\src\\main\\res\\测试路线.txt"));

//                MyWayPoints myWayPoints= null;
//                try {
//                    myWayPoints = MyWayPoints.fromJsonString(file.getFileOfString());
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                MyWayPoints.StartPositionBean startPositionBean= myWayPoints.getStartPosition();
//                System.out.println(startPositionBean.getAbsoluteAltitude());
//                ArrayList<Waypoint> mList = null;
//                try {
//                    mList = (ArrayList<Waypoint>) waypointMissionOperatorTool.getDjiWayPointFromMyWayPoints(file.getFileOfString());
//                    for()
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                mWaypointMission = waypointMissionOperatorTool.ctreateWaypointMission(mList);
//                //上传任务
//                if (WaypointMissionState.READY_TO_RETRY_UPLOAD.equals(mWaypointMissionOperator.getCurrentState())
//                        || WaypointMissionState.READY_TO_UPLOAD.equals(mWaypointMissionOperator.getCurrentState())) {
//                    mWaypointMissionOperator.uploadMission(new CommonCallbacks.CompletionCallback() {
//                        @Override
//                        public void onResult(DJIError djiError) {
//                            String djiErrorString  = djiError == null ? "Action started!" : djiError.getDescription();
//                            Log.e("未能成功上传：",djiErrorString);
//                        }
//                    });
//                }else {
//                    Toast.makeText(this,"请先准备好路点任务！",Toast.LENGTH_LONG).show();
//                }
//                //开始任务
//                if (mWaypointMission != null) {
//                    mWaypointMissionOperator.startMission(new CommonCallbacks.CompletionCallback() {
//                        @Override
//                        public void onResult(DJIError djiError) {
//                            String djiErrorString  = djiError == null ? "Action started!" : djiError.getDescription();
//                            Log.e("未能开始任务：",djiErrorString);
//                        }
//                    });
//                } else {
//                    Toast.makeText(this,"请先准备好路点任务！",Toast.LENGTH_LONG).show();
//                }
//                break;
//                //停止任务
//            case R.id.stopMisson:
//                mWaypointMissionOperator.stopMission(new CommonCallbacks.CompletionCallback() {
//                    @Override
//                    public void onResult(DJIError djiError) {
//                        String djiErrorString  = djiError == null ? "Action started!" : djiError.getDescription();
//                        Log.e("未能开始任务：",djiErrorString);
//                    }
//                });
//                break;
                default:
        }
    }
    public void saveByAndroid(String fileName,String data){
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try{
            out = openFileOutput(fileName, Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(data);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(writer != null){
                    writer.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public String loadByAndroid(String fileName){
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder contentOfFile = new StringBuilder();
        try{
            in = openFileInput(fileName);
            reader = new BufferedReader(new InputStreamReader(in));
            String line ="";
            while((line = reader.readLine() )!= null){
                contentOfFile.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return contentOfFile.toString();
    }
}
