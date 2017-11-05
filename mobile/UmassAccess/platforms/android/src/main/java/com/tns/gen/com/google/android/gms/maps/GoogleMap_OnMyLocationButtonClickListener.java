package com.tns.gen.com.google.android.gms.maps;

public class GoogleMap_OnMyLocationButtonClickListener implements com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener {
	public GoogleMap_OnMyLocationButtonClickListener() {
		com.tns.Runtime.initInstance(this);
	}

	public boolean onMyLocationButtonClick()  {
		java.lang.Object[] args = null;
		return (boolean)com.tns.Runtime.callJSMethod(this, "onMyLocationButtonClick", boolean.class, args);
	}

}
