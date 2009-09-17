package com.fju.csie.example.barcode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class HelloBarCodeActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        IntentIntegrator.initiateScan(this);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    	IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
    	if (scanResult != null) {
    		// handle scan result
			Toast
			  .makeText(this, 
					 "Contents: " + scanResult.getContents() + ", FormatName: " + scanResult.getFormatName(), 
					 Toast.LENGTH_SHORT)
			  .show();    		
    	}
    	// else continue with any other code you need in the method
    	// ...
    }    
}