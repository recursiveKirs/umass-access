from umapp.models import user, marker_type, marker, comment, disability, user_disability, location, entrance, favorite

from rest_framework import serializers

# Starting Serializer Classes

class userSerializer(serializers.ModelSerializer):
    class Meta:
        model = user
        fields = '__all__'

class marker_typeSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = marker_type
        fields = '__all__'

class markerSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = marker
        fields = '__all__'

class commentSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = comment
        fields = '__all__'

class disabilitySerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = disability
        fields = '__all__'

class user_disabilitySerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = user_disability
        fields = '__all__'

class locationSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = location
        fields = '__all__'

class entranceSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = entrance
        fields = '__all__'

class favoriteSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = favorite
        fields = '__all__'

