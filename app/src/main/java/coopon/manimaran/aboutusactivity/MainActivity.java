package coopon.manimaran.aboutusactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnShowAboutActivity = findViewById(R.id.btn_show_about_activity);
        btnShowAboutActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


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
                int poweredByIcon = R.drawable.ic_power_by;
                String poweredByTitle = "Powered By";
                String poweredByName = "Coopon";
                String poweredByAbout = "Coopon Sci Tech LLP";
                String poweredByLink = "http://cooponscitech.in/";

                // Initiated By
                int initiatedByIcon = R.drawable.ic_initiator;
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

            }
        });
    }
}
