package com.tencent.unipay.offline.test;

import android.app.Application;

/**
 * Created by afwang on 13-9-17.
 */
public class TencentUnipayHEMobilePayApplication extends Application {
  public void onCreate() {
    System.loadLibrary("megjb");
  }
  
}
