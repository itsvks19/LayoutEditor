package com.itsvks.layouteditor;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.elevation.SurfaceColors;
// import com.itsaky.androidide.logsender.LogSender;

public class BaseActivity extends AppCompatActivity {

  public LayoutEditor app;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    // LogSender.startLogging(this);
    super.onCreate(savedInstanceState);
    Thread.setDefaultUncaughtExceptionHandler(new CrashHandler(this));
    app = LayoutEditor.getInstance();
    getWindow().setStatusBarColor(SurfaceColors.SURFACE_0.getColor(this));
  }

  public void openUrl(String url) {
    try {
      Intent open = new Intent(Intent.ACTION_VIEW);
      open.setData(Uri.parse(url));
      open.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      startActivity(open);
    } catch (Throwable th) {
      Toast.makeText(this, th.getMessage(), Toast.LENGTH_SHORT).show();
      th.printStackTrace();
    }
  }
}
