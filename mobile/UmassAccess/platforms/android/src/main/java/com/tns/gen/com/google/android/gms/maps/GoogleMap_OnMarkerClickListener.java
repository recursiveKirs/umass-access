package com.tns.gen.com.google.android.gms.maps;

public class GoogleMap_OnMarkerClickListener implements com.google.android.gms.maps.GoogleMap.OnMarkerClickListener {
	public GoogleMap_OnMarkerClickListener() {
		com.tns.Runtime.initInstance(this);
	}

	public boolean onMarkerClick(com.google.android.gms.maps.model.Marker param_0)  {
		java.lang.Object[] args = new java.lang.Object[1];
		args[0] = param_0;
		return (boolean)com.tns.Runtime.callJSMethod(this, "onMarkerClick", boolean.class, args);
	}

}
