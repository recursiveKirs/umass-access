# -*- coding: utf-8 -*-
# Generated by Django 1.11.7 on 2017-11-04 20:52
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('umapp', '0002_marker_type'),
    ]

    operations = [
        migrations.CreateModel(
            name='marker',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('up_votes', models.IntegerField()),
            ],
        ),
    ]
