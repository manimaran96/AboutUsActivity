package coopon.manimaran.aboutusactivity;

import android.app.ActionBar;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    private ImageView imgAppLogo, imgPoweredByLogo, imgInitiatedByLogo;
    private Button btnShare, btnLicense, btnRateUs;
    private View layoutPoweredBy, layoutInitiatedBy, layoutSeeSourceCode, layoutThirdPartyLibrary;
    private View layoutCredits, layoutHelpDevelopment, layoutContactUs;

    private TextView txtAppName, txtAppAbut, txtAppVersion;
    private TextView txtPoweredByTitle, txtPoweredByName, txtPoweredByAbout, txtPoweredByLink;
    private TextView txtInitiatedByTitle, txtInitiatedByName, txtInitiatedByAbout, txtInitiatedByLink;

    private AboutActivityBuilder.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Getting Builder
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }

        // Builder
        builder = (AboutActivityBuilder.Builder) intent.getSerializableExtra("builder");

        // Set Theme
        if (builder.idTheme != 0) {
            setTheme(builder.idTheme);
        }

        setContentView(R.layout.activity_about_us);

        // Action Bar
        setupActionBar();

        // Set Title
        if(builder.activityTitle != null)
            setTitle(builder.activityTitle);

        // Views Init
        initViews();

        // Make invisible all cards
        initVisibility();

        // App Logo
        if (builder.showAppLogo) {
            imgAppLogo.setVisibility(View.VISIBLE);
            imgAppLogo.setImageResource(builder.appLogo);
        }

        // App Name
        if (builder.showAppName) {
            txtAppName.setVisibility(builder.appName != null ? View.VISIBLE : View.GONE);
            txtAppName.setText(builder.appName != null ? builder.appName : "");
        }

        // App About
        if (builder.showAppAbout) {
            txtAppAbut.setVisibility(builder.appAbout != null ? View.VISIBLE : View.GONE);
            txtAppAbut.setText(builder.appAbout != null ? builder.appAbout : "");
        }

        // App Version
        if (builder.showAppVersion) {
            txtAppVersion.setVisibility(builder.appVersion != null ? View.VISIBLE : View.GONE);
            txtAppVersion.setText(builder.appVersion != null ? builder.appVersion : "");
        }

        // App License - Button
        if (builder.showLicenseBtn) {
            if (builder.hintLicense != null)
                btnLicense.setText(builder.hintLicense);

            btnLicense.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(builder.licenseUrl)));
                }
            });
        }

        // App Share - Button
        if (builder.showShareBtn) {
            if (builder.hintShare != null)
                btnShare.setText(builder.hintShare);

            btnShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT, builder.shareMsgText);
                    startActivity(Intent.createChooser(intent, builder.shareIntentTitle));
                }
            });
        }

        // App Rate Us - Button
        if (builder.showRateUsBtn) {
            if (builder.hintRateUs != null)
                btnRateUs.setText(builder.hintRateUs);

            btnRateUs.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(builder.appPlayStoreLink)));
                }
            });
        }

        // App Power By Info
        if (builder.showPoweredBy) {
            layoutPoweredBy.setVisibility(View.VISIBLE);
            imgPoweredByLogo.setImageResource(builder.poweredByIcon);
            txtPoweredByTitle.setText(builder.poweredByTitle != null ? builder.poweredByTitle : "");
            txtPoweredByName.setText(builder.poweredByName != null ? builder.poweredByName : "");
            txtPoweredByAbout.setText(builder.poweredByAbout != null ? builder.poweredByAbout : "");
            txtPoweredByLink.setText(builder.poweredByLink != null ? builder.poweredByLink : "");
        }

        // App Initiator By
        if (builder.showInitiatedBy) {
            layoutInitiatedBy.setVisibility(View.VISIBLE);
            imgInitiatedByLogo.setImageResource(builder.initiatedByIcon);
            txtInitiatedByTitle.setText(builder.initiatedByTitle != null ? builder.initiatedByTitle : "");
            txtInitiatedByName.setText(builder.initiatedByName != null ? builder.initiatedByName : "");
            txtInitiatedByAbout.setText(builder.initiatedByAbout != null ? builder.initiatedByAbout : "");
            txtInitiatedByLink.setText(builder.initiatedByLink != null ? builder.initiatedByLink : "");
        }

        // App See Source Code - Button
        if (builder.showSeeSourceCode) {
            if (builder.linkSourceCode != null && builder.linkSourceCode.length() > 0) {
                makeVisible(layoutSeeSourceCode);
                layoutSeeSourceCode.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(builder.linkSourceCode)));
                    }
                });
            }
        }

        // App Third Party Library - Button
        if (builder.showThirdPartyLibrary) {
            makeVisible(layoutThirdPartyLibrary);
            layoutThirdPartyLibrary.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getApplicationContext(), ThirdPartyLibraryActivity.class);
                    i.putExtra("json_res_id", builder.jsonResOfThirdPartyLib);
                    startActivity(i);
                }
            });
        }

        // App Credits - Button
        if (builder.showCredits) {
            makeVisible(layoutCredits);
            layoutCredits.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getApplicationContext(), CreditsActivity.class);
                    i.putExtra("json_res_id", builder.jsonResOfCredits);
                    startActivity(i);
                }
            });
        }

        // App Help Development
        if (builder.showHelpDevelopment)
        {
            //makeVisible(layoutHelpDevelopment);
        }

        // App Contact Us
        if (builder.showContactUs) {
            makeVisible(layoutContactUs);

            layoutContactUs.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("message/rfc822");
                    i.putExtra(Intent.EXTRA_EMAIL, new String[]{builder.contactMail});
                    try {
                        startActivity(Intent.createChooser(i, "Contact via mail..."));
                    } catch (ActivityNotFoundException ex) {
                        Toast.makeText(AboutActivity.this, "No email client", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void initViews() {
        imgAppLogo = findViewById(R.id.img_app_logo);
        txtAppName = findViewById(R.id.txt_app_name);
        txtAppAbut = findViewById(R.id.txt_app_about);
        txtAppVersion = findViewById(R.id.txt_app_version);

        btnLicense = findViewById(R.id.btn_licence);
        btnShare = findViewById(R.id.btn_share);
        btnRateUs = findViewById(R.id.btn_rate_us);

        layoutPoweredBy = findViewById(R.id.layout_powered_by);
        imgPoweredByLogo = findViewById(R.id.img_powered_by);
        txtPoweredByTitle = findViewById(R.id.txt_powered_by_title);
        txtPoweredByName = findViewById(R.id.txt_powered_by_name);
        txtPoweredByAbout = findViewById(R.id.txt_powered_by_about);
        txtPoweredByLink = findViewById(R.id.txt_powered_by_link);

        layoutInitiatedBy = findViewById(R.id.layout_initiated_by);
        imgInitiatedByLogo = findViewById(R.id.img_initiated_by);
        txtInitiatedByTitle = findViewById(R.id.txt_initiated_by_title);
        txtInitiatedByName = findViewById(R.id.txt_initiated_by_name);
        txtInitiatedByAbout = findViewById(R.id.txt_initiated_by_about);
        txtInitiatedByLink = findViewById(R.id.txt_initiated_by_link);

        layoutSeeSourceCode = findViewById(R.id.layout_see_source_code);
        layoutThirdPartyLibrary = findViewById(R.id.layout_third_party_licence);
        layoutCredits = findViewById(R.id.layout_credits);
        layoutContactUs = findViewById(R.id.layout_contact_us);
        layoutHelpDevelopment = findViewById(R.id.layout_help_development);
    }

    private void makeVisible(View view) {
        view.setVisibility(View.VISIBLE);
    }

    // Views Visibility
    private void initVisibility() {
        int visibility = View.GONE;
        layoutPoweredBy.setVisibility(visibility);
        layoutInitiatedBy.setVisibility(visibility);
        layoutSeeSourceCode.setVisibility(visibility);
        layoutThirdPartyLibrary.setVisibility(visibility);
        layoutCredits.setVisibility(visibility);
        layoutHelpDevelopment.setVisibility(visibility);
        layoutContactUs.setVisibility(visibility);
        layoutCredits.setVisibility(visibility);
    }

    // Action bar
    private void setupActionBar() {
        Window window = getWindow();
        // finally change the color
        if (Build.VERSION.SDK_INT >= 21) {
            // clear FLAG_TRANSLUCENT_STATUS flag:
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        }
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
