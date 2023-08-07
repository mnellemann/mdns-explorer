# mDNS Explorer

View all multicastDNS devices.

## Development

Java SDK version 17 (or later) is required.

## Native Images

The native images are built with GraalVM.
Download the Gluon version of GraalVM from https://github.com/gluonhq/graal/releases/tag/gluon-22.1.0.1-Final and extract it locally.

Point the GRAALVM_HOME environment variable to the folder:

```export GRAALVM_HOME="/path/to/gluon-22.1.0.1```

With all requirements setup and on a supported platform, the general idea is to run:

```shell
./gradlew clean build
./gradlew nativeBuild   -Ptarget=android    # or -Ptarget=ios
./gradlew nativeLink    -Ptarget=android
./gradlew nativePackage -Ptarget=android
./gradlew nativeInstall -Ptarget=android
./gradlew nativeRun     -Ptarget=android
```

or, in one go for Android:

```shell
./gradlew -Ptarget=android clean build nativeBuild nativeLink nativePackage nativeInstall nativeRun
```

or, in one go for iOS:
```shell
./gradlew -Ptarget=ios clean build nativeBuild nativeLink nativePackage nativeInstall nativeRun
```

### Linux

See https://docs.gluonhq.com/#prerequisites_linux

For nativeBuild on Linux, install the following dependencies.

```shell
sudo apt install libgtk-3-dev libavformat-dev libavutil-dev libavcodec-dev libasound2-dev libpango1.0-dev libxtst-dev build-essential
```

#### Building for Android (on Linux)

See https://docs.gluonhq.com/#prerequisites_android

Install Android Studio and use sdkmanager to install the following:

- Android SDK Platform 31
- NDK (Side by side)

Point the ANDROID_NDK variable to the installed NDK directory:

```
export ANDROID_NDK="/home/mark/Android/Sdk/ndk/25.2.9519653/"
```

Add the platform-tools to you PATH to use 'adb' command:


```
export PATH="$PATH:/home/mark/Android/Sdk/platform-tools/"
```

Run the 'adb devices' and 'adb usb' to verify your Android networkService is in development mode and allows connections.

### MacOS

See https://docs.gluonhq.com/#platforms_macos

Install the xcode command line tools and an iPhone emulator.

If you have problems with *xcrun* not being able to find *iphoneos*, try:

```shell
sudo xcode-select --switch /Applications/Xcode.app
```

Download and install homebrew, and install the following:

```shell
brew install maven
brew install --HEAD libusbmuxd
brew install --HEAD libimobiledevice
```

#### iOS (on MacOS)

See https://docs.gluonhq.com/#prerequisites_ios
