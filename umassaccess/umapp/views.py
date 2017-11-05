# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.shortcuts import render
from django.http import HttpResponse, HttpResponseRedirect, Http404
from django.template import Context, loader
from django.core.exceptions import ObjectDoesNotExist
from django.http import HttpResponse, JsonResponse
from django.views.decorators.csrf import csrf_exempt
from rest_framework.renderers import JSONRenderer
from rest_framework.parsers import JSONParser
from umapp.models import user, marker_type, marker, comment, disability, user_disability, location, entrance, favorite
from umapp.serializers import userSerializer, marker_typeSerializer, markerSerializer, commentSerializer, disabilitySerializer, user_disabilitySerializer, locationSerializer, entranceSerializer, favoriteSerializer
import json


# Create your views here.

# list of mobile User Agents
mobile_uas = [
	'w3c ','acs-','alav','alca','amoi','audi','avan','benq','bird','blac',
	'blaz','brew','cell','cldc','cmd-','dang','doco','eric','hipt','inno',
	'ipaq','java','jigs','kddi','keji','leno','lg-c','lg-d','lg-g','lge-',
	'maui','maxo','midp','mits','mmef','mobi','mot-','moto','mwbp','nec-',
	'newt','noki','oper','palm','pana','pant','phil','play','port','prox',
	'qwap','sage','sams','sany','sch-','sec-','send','seri','sgh-','shar',
	'sie-','siem','smal','smar','sony','sph-','symb','t-mo','teli','tim-',
	'tosh','tsm-','upg1','upsi','vk-v','voda','wap-','wapa','wapi','wapp',
	'wapr','webc','winw','winw','xda','xda-'
	]
 
mobile_ua_hints = [ 'SymbianOS', 'Opera Mini', 'iPhone', 'Android' ]

def mobileBrowser(request):
    ''' Super simple device detection, returns True for mobile devices '''
 
    mobile_browser = False
    ua = request.META['HTTP_USER_AGENT'].lower()[0:4]
 
    if (ua in mobile_uas):
        mobile_browser = True
    else:
        for hint in mobile_ua_hints:
            if request.META['HTTP_USER_AGENT'].find(hint) > 0:
                mobile_browser = True
 
    return mobile_browser
 

 
def index(request):
    '''Render the index page'''
     print(request.body)
    if mobileBrowser(request):
        t = loader.get_template('m_index.html')
    else:
        t = loader.get_template('index.html', 'js/main.js', 'css/main.css')
 
    c = Context( { }) # normally your page data would go here
 
    return HttpResponse(t.render(c))

@csrf_exempt
def connection(request, mac_add):
    try:
        existing_user = user.objects.get(id=mac_add)
	response = HttpResponse({
		user_id : existing_user.id
	}, content_type='application/json')
        return response
 
    except ObjectDoesNotExist:
        new_user = user(mac_add)
	new_user.save()
	response = HttpResponse({
		user_id : new_user.id
	}, content_type='application/json')
	return response

@csrf_exempt
# dis_list is an array of disabilities
def profile(request, usr_id, dis_list)
    disability_list = json.loads(dis_list)[disabilities]
    for index in range(0, len(disability_list)):
        new_user_disability = user_disability(usr_id, disability_list[index]):
	new_user_disability.save()
    return

@csrf_exempt
def create_marker(request, usr_id, latitude, longitude, marker_type_id):
    new_marker = marker(marker_type_id, longitude, latitude, 0, 0, usr_id)
    new_marker.save()
    return

@csrf_exempt
def request_marker(request, marker_id):
    return_marker = marker.objects.get(id=marker_id)
    longitude = return_marker.longitude
    latitude = return_marker.latitude
    up_votes = return_marker.up_votes
    down_votes = return_marker.down_votes
    response = HttpResponse({
		longitude : longitude, latitude : latitude, up_votes : up_votes, down_votes : down_votes
    }, content_type='application/json')
    return response













