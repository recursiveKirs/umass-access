from umapp.models import user, marker_type, marker, comment, disability, user_disability, location, entrance, favorite

from rest_framework import serializers

# Starting Serializer Classes

class userSerializer(serializers.HyperlinkedModelSerializer):
    id = serializers.Field()
    class Meta:
        model = user
        fields = '__all__'

class marker_typeSerializer(serializers.HyperlinkedModelSerializer):
    id = serializers.Field()
    class Meta:
        model = marker_type
        fields = '__all__'

class markerSerializer(serializers.HyperlinkedModelSerializer):
    id = serializers.Field()
    class Meta:
        model = marker
        fields = '__all__'

class commentSerializer(serializers.HyperlinkedModelSerializer):
    id = serializers.Field()
    class Meta:
        model = comment
        fields = '__all__'

class disabilitySerializer(serializers.HyperlinkedModelSerializer):
    id = serializers.Field()
    class Meta:
        model = disability
        fields = '__all__'

class user_disabilitySerializer(serializers.HyperlinkedModelSerializer):
    id = serializers.Field()
    class Meta:
        model = user_disability
        fields = '__all__'

class locationSerializer(serializers.HyperlinkedModelSerializer):
    id = serializers.Field()
    class Meta:
        model = location
        fields = '__all__'

class entranceSerializer(serializers.HyperlinkedModelSerializer):
    id = serializers.Field()
    class Meta:
        model = entrance
        fields = '__all__'

class favoriteSerializer(serializers.HyperlinkedModelSerializer):
    id = serializers.Field()
    class Meta:
        model = favorite
        fields = '__all__'

