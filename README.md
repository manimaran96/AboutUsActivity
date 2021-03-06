# AboutUsActivity - Library

*  About Us Activity for Android Application About screen.
*  Simple and Easy to Use


**Demo App** - [Click here](https://gitlab.com/manimaran/aboutusactivity/raw/master/files/about_us_activity_demo.apk)

### Screen Shot

<center><img src="https://gitlab.com/manimaran/aboutusactivity/raw/master/files/about_us_activity.gif" data-canonical-src="https://gitlab.com/manimaran/aboutusactivity/raw/master/files/about_us_activity.gif" width="300" height="500" /></center>
<br>

#### More Screen Shot
<center>
<img src="https://gitlab.com/manimaran/aboutusactivity/raw/master/files/4.png" data-canonical-src="https://gitlab.com/manimaran/aboutusactivity/raw/master/files/4.png" width="300" height="500" />

</center>

### How To Use

1. Add the JitPack repository to your build file. Add it in your root build.gradle at the end of repositories

```xml
    allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
    }
```

2. Add the dependency

```xml
	dependencies {
	        implementation 'com.gitlab.manimaran:aboutusactivity:v1.0'
	}
```

3. Inside Click Listener

```java
    // Base
    int appTheme = R.style.AppTheme;
    String aboutUsActivityTitle = "About Us";

    // App Details
    int appLogo = R.drawable.ic_app_logo;
    String appName = getString(R.string.app_name);
    String appAbout = "About App Info. About Activity for simple and easy way to show about us.";
    String appVersion = "Version : " + BuildConfig.VERSION_NAME;
    String appPlayStoreLink =  "https://play.google.com/store/apps/details?id=com.jskaleel.fte";


    // License details
    String licenseName = "GPL v3";
    String licenseUrl = "https://www.gnu.org/licenses/gpl-3.0.txt";

    // Share Details
    String shareMsgText = "About Us Activity you can see : \nhttps://gitlab.com/manimaran/aboutusactivity";
    String shareIntentTitle = "Choose app to share...";

    // Powered By
    int poweredByIcon = R.drawable.ic_power_by; // If No need image set 0
    String poweredByTitle = "Powered By";
    String poweredByName = "Coopon";
    String poweredByAbout = "Coopon Sci Tech LLP";
    String poweredByLink = "http://cooponscitech.in/";

    // Initiated By
    int initiatedByIcon = R.drawable.ic_initiator; // If No need image set 0
    String initiatedByTitle = "Initiated By";
    String initiatedByName = "Initiator";
    String initiatedByAbout = "About details of Initiator";
    String initiatedByLink = "http://initiator.in/";

    // Others
    String sourceCodeLink = "https://gitlab.com/manimaran/aboutusactivity";
    int jsonResOfThirdPartyLibrary = R.raw.third_party_library;
    int jsonResOfCredits = R.raw.credits;
    String contactMail = "manimaran@cooponscitech.in";


    /**
     *  All the values are set in about activity builder
     *  If we don't need any views just ignore in build.
     */
    new AboutActivityBuilder.Builder(MainActivity.this)
            .setAppTheme(appTheme)
            .setTitle(aboutUsActivityTitle)
            .setAppLogo(appLogo)
            .setAppName(appName)
            .setAppAbout(appAbout)
            .setAppVersion(appVersion)
            .setLicense(licenseName, licenseUrl)
            .setShare(shareMsgText, shareIntentTitle)
            .setRateUs(appPlayStoreLink)
            .setPoweredBy(poweredByIcon, poweredByTitle, poweredByName, poweredByAbout, poweredByLink)
            .setInitiatedBy(initiatedByIcon, initiatedByTitle, initiatedByName, initiatedByAbout, initiatedByLink)
            .setSeeSourceCode(sourceCodeLink)
            .setThirdPartyLibrary(jsonResOfThirdPartyLibrary)
            .setCredits(jsonResOfCredits)
            .setContactUs(contactMail)
            .showAboutActivity();

```
### Note

**Syntax : R.raw.credits - structure like**

```json
{
  "credits": [
    {
      "name": "Manimaran",
      "about": "Reason/About",
      "url": "http://manimaran96.wordpress.com/"
    },
    {
      "name": "XYZ",
      "about": "Reason/About",
      "url": "http://xyz.com/"
    }
  ]
}
```

**Syntax : R.raw.third_party_library**

```json
{
  "third_party_library": [
    {
      "name": "androidx.appcompat:appcompat:1.0.2",
      "url": "http://developer.android.com/tools/extras/support-library.html",
      "license": "The Apache Software License, Version 2.0",
      "license_url": "http://www.apache.org/licenses/LICENSE-2.0.txt"
    },
    {
      "name": "androidx.constraintlayout:constraintlayout:1.1.3",
      "url": "http://developer.android.com/tools/extras/support-library.html",
      "license": "The Apache Software License, Version 2.0",
      "license_url": "http://www.apache.org/licenses/LICENSE-2.0.txt"
    }
  ]
}
```


### Thanks To

*  [AboutActivity](https://github.com/biagiopietro/AboutActivity)