package com.sykj.arsg;

import com.unity3d.player.*;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * @deprecated Use UnityPlayerActivity instead.
 */
public class UnityPlayerProxyActivity extends Activity
{
	@Override protected void onCreate (Bundle savedInstanceState)
	{
		Log.w("Unity", "UnityPlayerNativeActivity has been deprecated, please update your AndroidManifest to use UnityPlayerActivity instead");
		super.onCreate(savedInstanceState);
/*
		Intent intent = new Intent(this, com.DefaultCompany.ARSG.UnityPlayerActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		Bundle extras = getIntent().getExtras();
		if (extras != null)
			intent.putExtras(extras);
		startActivity(intent);
*/
		
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter  
                .getDefaultAdapter();  
        if (mBluetoothAdapter == null) {  
            Toast.makeText(this, "����û���ҵ�����Ӳ����������", Toast.LENGTH_SHORT).show();  
            finish();  
        }  
        // �����������û�п���������  
        if (!mBluetoothAdapter.isEnabled()) {  
            // ����ͨ��startActivityForResult()���������Intent������onActivityResult()�ص������л�ȡ�û���ѡ�񣬱����û�������Yes������  
            // ��ô�����յ�RESULT_OK�Ľ����  
            // ���RESULT_CANCELED������û���Ը�⿪������  
            Intent mIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);  
            startActivityForResult(mIntent, 1);  
            // ��enable()����������������ѯ���û�(ʵ������Ϣ�Ŀ��������豸),��ʱ����Ҫ�õ�android.permission.BLUETOOTH_ADMINȨ�ޡ�  
            // mBluetoothAdapter.enable();  
            // mBluetoothAdapter.disable();//�ر�����  
        } else {
        	StartGame();
        }
	}
	
	private void StartGame() {
		Intent intent = new Intent(this, com.sykj.arsg.UnityPlayerActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		Bundle extras = getIntent().getExtras();
		if (extras != null)
			intent.putExtras(extras);
		startActivity(intent);
	}
	
	@Override  
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
        // TODO Auto-generated method stub  
        super.onActivityResult(requestCode, resultCode, data);  
        if (requestCode == 1) {  
            if (resultCode == RESULT_OK) {  
            	
                Toast.makeText(this, "�����Ѿ�����", Toast.LENGTH_SHORT).show();  
            } else if (resultCode == RESULT_CANCELED) {  
                Toast.makeText(this, "��������������", Toast.LENGTH_SHORT).show();  
                finish();  
            }  
        }  
        StartGame();
    }  
}
