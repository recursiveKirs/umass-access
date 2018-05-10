# Steps taken to set up react native on Ubuntu 16.04:
# react native setup
sudo apt install npm
npm install -g create-react-native app
create-react-native-app AwesomeProject

# android installation
# download android studio, extract in Downloads
sudo mv ~/Downloads/android-studio /usr/local/
sudo apt-get install libc6:i386 libncurses5:i386 libstdc++6:i386 lib32z1 libbz2-1.0:i386
/usr/local/android-studio/bin/studio.sh # don't worry about kvm installation til later.

# Install (SDK Platforms)
# Android 6.0 (Marshmallow) SDK
# Intel x86 Atom System Image
# Intel x86 Adom_64 System Image
# Google APIs ARM EABI v7a System Image
# Google APIs Intel x86 Atom System Image
# Google APIs Intel x86 Atom_64 System Image
# (Android SDK Build-Tools 28-rc1)
# 23.0.3
# 27.0.3
# GPU Debugging Tool
# CMake 3.6.4111459
# Android Emulator
# Android SDK Platform-Tools
# Android SDK Tools


# kvm installation
sudo apt-get install qemu-kvm libvirt-bin ubuntu-vm-builder bridge-utils
sudo apt install cpu-checker
sudo adduser `id -un` libvirtd

sudo ls -la /var/run/libvirt/libvirt-sock
sudo virsh list --all # shouldn't throw error
ls -l /dev/kvm # crw-rw----+ 1 root root 10, 232 Jul  8 22:04 /dev/kvm
sudo chown root:libvirtd /dev/kvm

rmmod kvm
modprobe -a kvm

sudo apt-get install virt-manager


