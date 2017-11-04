package com.tns.gen.com.google.android.gms.maps;

public class OnMapReadyCallback implements com.google.android.gms.maps.OnMapReadyCallback {
	public OnMapReadyCallback() {
		com.tns.Runtime.initInstance(this);
	}

	public void onMapReady(com.google.android.gms.maps.GoogleMap param_0)  {
		java.lang.Object[] args = new java.lang.Object[1];
		args[0] = param_0;
		com.tns.Runtime.callJSMethod(this, "onMapReady", void.class, args);
	}

}
