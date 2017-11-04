package com.tns.gen.com.google.android.gms.maps;

public class GoogleMap_OnCameraIdleListener implements com.google.android.gms.maps.GoogleMap.OnCameraIdleListener {
	public GoogleMap_OnCameraIdleListener() {
		com.tns.Runtime.initInstance(this);
	}

	public void onCameraIdle()  {
		java.lang.Object[] args = null;
		com.tns.Runtime.callJSMethod(this, "onCameraIdle", void.class, args);
	}

}
