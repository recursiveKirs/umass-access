package com.tns.gen.com.google.android.gms.maps;

public class GoogleMap_OnCameraChangeListener implements com.google.android.gms.maps.GoogleMap.OnCameraChangeListener {
	public GoogleMap_OnCameraChangeListener() {
		com.tns.Runtime.initInstance(this);
	}

	public void onCameraChange(com.google.android.gms.maps.model.CameraPosition param_0)  {
		java.lang.Object[] args = new java.lang.Object[1];
		args[0] = param_0;
		com.tns.Runtime.callJSMethod(this, "onCameraChange", void.class, args);
	}

}
