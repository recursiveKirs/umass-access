# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models

# Create your models here.

class user(models.Model):
    device_id = models.CharField(max_length=17)

class marker_type(models.Model):
    title = models.CharField(max_length=100)

class marker(models.Model):
    marker_type_id = models.ForeignKey('marker_type', null=True) 
    longitude = models.DecimalField(blank=True, null=True, max_digits=8, decimal_places=6)
    latitude = models.DecimalField(blank=True, null=True, max_digits=8, decimal_places=6)
    up_votes = models.IntegerField(default=0)
    down_votes = models.IntegerField(default=0)
    user_id = models.ForeignKey('user', null=True)

class comment(models.Model):
    marker_id = models.ForeignKey('marker', null=True)
    user_id = models.ForeignKey('user', null=True)
    text = models.CharField(max_length=140)

class disability(models.Model):
    title = models.CharField(max_length=100)

class user_disability(models.Model):
    user_id = models.ForeignKey('user', null=True)
    disability_id = models.ForeignKey('disability', null=True)

class location(models.Model):
    title = models.CharField(max_length=100)

class entrance(models.Model):
    location_id = models.ForeignKey('location', null=True)
    title_suffix = models.CharField(max_length=100)
    latitude = models.DecimalField(blank=True, null=True, max_digits=8, decimal_places=6)
    longitude = models.DecimalField(blank=True, null=True, max_digits=8, decimal_places=6)
    ramp_access = models.BooleanField(default=False)
    powered_doors = models.BooleanField(default=False)

class favorite(models.Model):
    location_id = models.ForeignKey('location', null=True)
    entrance_id = models.ForeignKey('entrance', null=True)
    user_id = models.ForeignKey('user', null=True)
