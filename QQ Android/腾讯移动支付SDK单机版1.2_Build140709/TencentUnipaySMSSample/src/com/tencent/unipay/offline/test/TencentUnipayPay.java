package com.tencent.unipay.offline.test;
 
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import com.tencent.unipay.offline.R;
import com.tencent.unipay.offline.TencentUnipayHEMobilepayCallBack;
import com.tencent.unipay.offline.TencentUnipayAPI;
import com.tencent.unipay.offline.TencentUnipayCallBack;
import com.tencent.unipay.offline.TencentUnipayCofig;
import com.tencent.unipay.offline.TencentUnipayMMMobilepayCallBack;

import com.tencent.unipay.offline.common.TencentUnipayPropsType;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class TencentUnipayPay extends Activity implements OnClickListener
{
	private TencentUnipayAPI smsAPI;
	private Button btnPay;
	private Handler handler = null; 
	private int channel;
	//移动MM基地计费信息 (现网环境)
	private static final String APPID = "000000000000";
	private static final String APPKEY = "0000000000000000";
	// 移动MM基地计费点信息
	private static final String LEASE_PAYCODE = "000000000000000";
	
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unipay_layout_demo_pay); 
        channel=this.getIntent().getIntExtra("channel",-1);
        smsAPI = new TencentUnipayAPI(TencentUnipayPay.this);
        /*smsAPI.setMobileGameBase 该接口使用情况如下：
         * 1、当移动用户采用 “移动和游戏基地”的短信支付，需设置
         * 2、无SIM卡的情况下，默认采用“移动和游戏基地”通过好友来支付，需设置
        */
        if(channel==TencentUnipayCofig.MOBILE_HE || channel==-1)
    	   {
        	smsAPI.setMobileGameBase(TencentUnipayCofig.MOBILE_HE);
        	smsAPI.setTencentUnipayMobileHEParams("QQ飞车","腾讯","098988888");
    	   }
        else if(channel==TencentUnipayCofig.MOBILE_MM)
           {
        	smsAPI.setMobileGameBase(TencentUnipayCofig.MOBILE_MM);
        	smsAPI.setTencentUnipayMobileMMParams(APPID, APPKEY);
        	smsAPI.setCallBack(mmMobilepayCallBack);
           }
        smsAPI.init(TencentUnipayCofig.ENV_TEST);
        handler = new Handler();      
        btnPay = (Button)findViewById(R.id.btnPay);
        btnPay.setOnClickListener(this);   
        
    }  
    
	@Override
	public void onClick(View arg0) 
	{
		int viewId=arg0.getId();
		if(viewId==R.id.btnPay)
		{
	      new Thread()
    		 {  
                 public void run()
                 {    
                     handler.post(runnableUi);   
                 }                     
             }.start();
		}
	}
    
     // 构建Runnable对象，在runnable中调用支付   
	Runnable runnableUi=new  Runnable()
    {  
        @Override  
        public void run() 
        {  	  
            switch(channel)
            {
            case TencentUnipayCofig.MOBILE_COMMON://移动老指令
            	 LaunchMobileCommonGameBase();
            	break;
            case TencentUnipayCofig.MOBILE_HE://移动和游戏基地
            	LaunchMobileHeGameBase();
            	break;
            case TencentUnipayCofig.MOBILE_MM://移动MM基地
            	LaunchMobileMMGameBase();
            	break;
            case TencentUnipayCofig.UNICOM_COMMON://联通老指令
            	LaunchUnicomCommonGameBase();
            	break;
            case TencentUnipayCofig.UNICOM_WO://联通沃商店
            	LaunchUnicomWoGameBase();
            	break;
            case TencentUnipayCofig.UNICOM_KD://联通沃阅读
            	break;
            case TencentUnipayCofig.TELECOM_COMMOM://电信爱游戏基地
            	LaunchTelecomCommonGameBase();
            	break;
            default://无SIM卡，通过“移动和游戏基地”的好友来支付
            	 LaunchMobileHeGameBase();
            	break;
            }
        }  
    };  
    
    //移动老指令
    public void LaunchMobileCommonGameBase()
    {
    	smsAPI.setCallBack(callBack);
  	  	smsAPI.setUnicomGameBase(TencentUnipayCofig.MOBILE_COMMON);         	  
  	  	//offerid、channelid、gameid、gamename、goodsid、goodsname、pointid、money
        smsAPI.smsPayEntry("1450000368", "2001", "102", "大鱼吃小鱼", "907", "海底霸王",2, "2");
    }
    
    //移动和游戏基地
    public void LaunchMobileHeGameBase()
    {
    	//移动用户
        smsAPI.setCallBack(heMobilepayCallBack);
  	  	smsAPI.setMobileGameBase(TencentUnipayCofig.MOBILE_HE);
  	  	try {
			smsAPI.smsMobileHEPayEntry(TencentUnipayPropsType.NO_SPECIAL_NEED,true,2,null,"1450000368", "2001", "102", "大鱼吃小鱼", "907", "海底霸王","2");
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
    
    //移动MM基地支付
    public void LaunchMobileMMGameBase()
    {	
    	smsAPI.setMobileGameBase(TencentUnipayCofig.MOBILE_MM);
    	smsAPI.smsMobileMMPayEntry(LEASE_PAYCODE, "test", "1450000368", "2001", "102", "大鱼吃小鱼", "907", "海底霸王", 1, "1");
    }
    
    //联通老指令
    public void LaunchUnicomCommonGameBase()
    {
    	smsAPI.setCallBack(callBack);
  	  	smsAPI.setUnicomGameBase(TencentUnipayCofig.UNICOM_COMMON);         	  
  	  	//offerid、channelid、gameid、gamename、goodsid、goodsname、pointid、money
        smsAPI.smsPayEntry("1450000368", "2001", "102", "大鱼吃小鱼", "907", "海底霸王", 2, "2");
    }
    
    //联通沃商店游戏基地
    public void LaunchUnicomWoGameBase()
    {
    	smsAPI.setCallBack(callBack);
  	  	smsAPI.setUnicomGameBase(TencentUnipayCofig.UNICOM_WO);         	  
  	  	//offerid、channelid、gameid、gamename、goodsid、goodsname、pointid、money
        smsAPI.smsPayEntry("1450000368", "2001", "102", "大鱼吃小鱼", "907", "海底霸王", 2, "2");
    }
    
    //电信爱游戏基地
    public void LaunchTelecomCommonGameBase()
    {
    	 smsAPI.setCallBack(callBack);
    	 smsAPI.setTelecomGameBase(TencentUnipayCofig.TELECOM_COMMOM);
   	  	 //offerid、channelid、gameid、gamename、goodsid、goodsname、pointid、money
         smsAPI.smsPayEntry("1450000368", "2001", "102", "大鱼吃小鱼", "907", "海底霸王", 2, "2");
    }
    
    //移动MM基地接口回调
    TencentUnipayMMMobilepayCallBack mmMobilepayCallBack=new TencentUnipayMMMobilepayCallBack()
    {
    	@Override
    	public void onBillingFinish(int code, HashMap arg1,String reason) {
    		String result = "订购结果：订购成功";
    		// 商品信息
    		String paycode = null;
    		// 商品的交易 ID，用户可以根据这个交易ID，查询商品是否已经交易
    		String tradeID = null;
    		if (code == 1001){
//    				|| code == PurchaseCode.ORDER_OK_TIMEOUT) {
    			/**
    			 * 商品购买成功或者已经购买。 此时会返回商品的paycode，orderID,以及剩余时间(租赁类型商品)
    			 */
    			if (arg1 != null) {
    				paycode = (String) arg1.get("Paycode");
    				if (paycode != null && paycode.trim().length() != 0) {
    					result = result + ",Paycode:" + paycode;
    				}
    				tradeID = (String) arg1.get("TradeID");
    				if (tradeID != null && tradeID.trim().length() != 0) {
    					result = result + ",tradeid:" + tradeID;
    				}
    			}
    		} else if(code == 1214)
    		{
    			//订购超时
    			result = "订购结果："+reason;
    		}
    		
    		else {
    			// 表示订购失败。
    			result = "订购结果："+reason;
    		}
    		 Toast.makeText(TencentUnipayPay.this, result, Toast.LENGTH_SHORT).show();

    	}

		@Override
		public void onInitFinish(String result) {
			// TODO Auto-generated method stub
			 Toast.makeText(TencentUnipayPay.this, result, Toast.LENGTH_SHORT).show();
		}

    	
    };
    
    
    //移动和游戏基地接口回调   
    TencentUnipayHEMobilepayCallBack heMobilepayCallBack=new TencentUnipayHEMobilepayCallBack()
    {
		//购买道具结果回调提示
	      @Override
	      public void onResult(int resultCode, String billingIndex, Object obj) {
	        String result = "";
	        switch (resultCode) {
	          case 1:
	            result = "购买道具：[" + billingIndex + "] 成功";
	            break;
	          case 2:
	            result = "购买道具：[" + billingIndex + "] 失败";
	            break;
	          default:
	            result = "购买道具：[" + billingIndex + "] 取消";
	            break;
	        }
	        Toast.makeText(TencentUnipayPay.this, result, Toast.LENGTH_SHORT).show();
	      }

    };
     
    TencentUnipayCallBack callBack = new TencentUnipayCallBack()
    {
		@Override
		public void OnResult(int resultCode, String reslutMsg)
		{
			if (resultCode == 0)
			{
				Toast.makeText(TencentUnipayPay.this, "支付成功", Toast.LENGTH_SHORT).show();
			}
			else if(resultCode == 2)
			{
				Toast.makeText(TencentUnipayPay.this, "短信发送超时", Toast.LENGTH_SHORT).show();
			}
			else if(resultCode == 1)
			{
				//电信ui回调
			}
			else
			{
				Toast.makeText(TencentUnipayPay.this, reslutMsg + "-非0", Toast.LENGTH_SHORT).show();
			}
		}
    };

	@Override
	protected void onDestroy()
	{
		if (smsAPI != null)
		{
			smsAPI.destory();
		}
		super.onDestroy();
	}
}