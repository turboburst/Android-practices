package com.tencent.unipay.offline.test;

import com.tencent.unipay.offline.R;
import com.tencent.unipay.offline.TencentUnipayCofig;
import com.tencent.unipay.offline.common.TencentUnipayOperatorInfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class TencentUnipayTest extends Activity implements OnClickListener{
	private Button btnMobileCommon,btnMobileHe,btnMobileMM,btnUniconCommon,btnUnicomWo,btnUnicomKD,btnTelecomCommon,btnNoSimCoard;
	private LinearLayout llMobile,llUnicom,llTelecom,llNoSimCoard;
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unipay_layout_demo_index);   
        init();
    }
	
	private void init()
	{
		btnMobileCommon=(Button)findViewById(R.id.btnMobileCommon);
		btnMobileHe=(Button)findViewById(R.id.btnMobileHe);
		btnMobileMM=(Button)findViewById(R.id.btnMobileMM);
		btnUniconCommon=(Button)findViewById(R.id.btnUniconCommon);
		btnUnicomWo=(Button)findViewById(R.id.btnUnicomWo);
		btnUnicomKD=(Button)findViewById(R.id.btnUnicomKD);
		btnTelecomCommon=(Button)findViewById(R.id.btnTelecomCommon);
		btnNoSimCoard=(Button)findViewById(R.id.btnNoSimCoard);

		btnMobileCommon.setOnClickListener(this);
		btnMobileHe.setOnClickListener(this);
		btnMobileMM.setOnClickListener(this);
		btnUniconCommon.setOnClickListener(this);
		btnUnicomWo.setOnClickListener(this);
		btnUnicomKD.setOnClickListener(this);
		btnTelecomCommon.setOnClickListener(this);
		btnNoSimCoard.setOnClickListener(this);
		
		llMobile=(LinearLayout)findViewById(R.id.llMobile);
		llUnicom=(LinearLayout)findViewById(R.id.llUnicom);
		llTelecom=(LinearLayout)findViewById(R.id.llTelecom);
		llNoSimCoard=(LinearLayout)findViewById(R.id.llNoSimCoard);
		TencentUnipayOperatorInfo operator = new TencentUnipayOperatorInfo(TencentUnipayTest.this);
           int type = operator.getOperator();
           if(type == TencentUnipayOperatorInfo.OPERATOR_MOBILE)
           {   //移动用户
        	   llMobile.setVisibility(View.VISIBLE);
        	   llUnicom.setVisibility(View.GONE);
        	   llTelecom.setVisibility(View.GONE);
        	   llNoSimCoard.setVisibility(View.GONE);
           }
           else if(type == TencentUnipayOperatorInfo.OPERATOR_UNICOM)
           {   //联通用户
        	   llMobile.setVisibility(View.GONE);
        	   llUnicom.setVisibility(View.VISIBLE);
        	   llTelecom.setVisibility(View.GONE);
        	   llNoSimCoard.setVisibility(View.GONE);
           }
           else if(type == TencentUnipayOperatorInfo.OPERATOR_TELECOM)
           {   //电信用户
        	   llMobile.setVisibility(View.GONE);
        	   llUnicom.setVisibility(View.GONE);
        	   llTelecom.setVisibility(View.VISIBLE);
        	   llNoSimCoard.setVisibility(View.GONE);
           }else
           {   //无SIM卡，通过“移动和游戏基地”的好友来支付
        	   llMobile.setVisibility(View.GONE);
        	   llUnicom.setVisibility(View.GONE);
        	   llTelecom.setVisibility(View.GONE);
        	   llNoSimCoard.setVisibility(View.VISIBLE);
           }
	}

	@Override
	public void onClick(View view) {
		Intent intent =new Intent();
		 switch(view.getId())
		 {
		    case R.id.btnMobileCommon:
		    	 intent.putExtra("channel", TencentUnipayCofig.MOBILE_COMMON);
			     break;
		    case R.id.btnMobileHe:
		    	 intent.putExtra("channel", TencentUnipayCofig.MOBILE_HE);
		    	 break;
		    case R.id.btnMobileMM:
		    	 intent.putExtra("channel", TencentUnipayCofig.MOBILE_MM);
		    	 break;
		    case R.id.btnUniconCommon:
		    	 intent.putExtra("channel", TencentUnipayCofig.UNICOM_COMMON);
			     break;
		    case R.id.btnUnicomWo:
		    	 intent.putExtra("channel", TencentUnipayCofig.UNICOM_WO);
		    	 break;
		    case R.id.btnUnicomKD:
		    	 intent.putExtra("channel", TencentUnipayCofig.UNICOM_KD);
		    	 break;
		    case R.id.btnTelecomCommon:
		    	 intent.putExtra("channel", TencentUnipayCofig.MOBILE_COMMON);
		    	 break;
		    case R.id.btnNoSimCoard:
		    	break;
		 }
		 intent.setClass(this, TencentUnipayPay.class);
		 startActivity(intent);		
	}
	
}
