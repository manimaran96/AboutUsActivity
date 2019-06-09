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

                new AboutActivityBuilder.Builder(MainActivity.this)
                        .setAppTheme(R.style.AppTheme)
                        .setAppLogo(R.drawable.ic_app_logo)
                        .setAppName("App Name")
                        .setAppAbout("About App Info. About Activity for simple and easy way to show about us.")
                        .setAppVersion("Version : 1.0")
                        .setLicense("GPL v3") // Todo
                        .setShare( "About Us Activity you can see : \nhttps://gitlab.com/manimaran/aboutusactivity", "Choose app to share...")
                        .setRateUs("https://play.google.com/store/apps/details?id=com.jskaleel.fte")
                        .setPoweredBy(R.drawable.ic_power_by, "Powered By", "Coopon", "Coopon Sci Tech LLP",  "http://cooponscitech.in/")
                        .setInitiatedBy(R.drawable.ic_initiator, "Initiated By", "Initiator", "About Initiator", "http://initiator.com/")
                        .setSeeSourceCode("https://gitlab.com/manimaran/aboutusactivity")
                        .setThirdPartyLibrary("")
                        .setCredits("")
                        .setHelpDevelopment("")
                        .setContactUs("manimaran@cooponscitech.in")
                        .showAboutActivity();

            }
        });
    }
}
