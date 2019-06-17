package coopon.manimaran.about_us_activity;


import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AboutUsActivity extends AppCompatActivity {

    private ImageView imgAppLogo, imgPoweredByLogo, imgInitiatedByLogo;
    private View layoutPoweredBy, layoutInitiatedBy, layoutSeeSourceCode, layoutThirdPartyLibrary;
    private View layoutCredits, layoutHelpDevelopment, layoutContactUs;

    private TextView txtAppName, txtAppAbut, txtAppVersionAndLicense, btnShare, btnRateUs;
    private TextView txtPoweredByTitle, txtPoweredByName, txtPoweredByAbout, txtPoweredByLink;
    private TextView txtInitiatedByTitle, txtInitiatedByName, txtInitiatedByAbout, txtInitiatedByLink;

    private AboutActivityBuilder.Builder builder;

    @SuppressLint("SetTextI18n")
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

        // Set Title
        if (builder.activityTitle != null)
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
        StringBuilder appVersionLicense = new StringBuilder();

        if (builder.showAppVersion) {
            txtAppVersionAndLicense.setVisibility(builder.appVersion != null ? View.VISIBLE : View.GONE);
            appVersionLicense.append(builder.appVersion != null ? "Version : " + builder.appVersion : "");
        }

        // App License - Button
        if (builder.showLicenseBtn) {
            if (builder.hintLicense != null) {
                appVersionLicense.append(TextUtils.isEmpty(txtAppVersionAndLicense.getText()) ? "" : " & ");
                appVersionLicense.append("License : <a href=").append(builder.licenseUrl).append(">").append(builder.hintLicense).append("</a>");

                txtAppVersionAndLicense.setMovementMethod(LinkMovementMethod.getInstance());
                txtAppVersionAndLicense.setText(Html.fromHtml(appVersionLicense.toString()));
            }
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
            if (builder.poweredByIcon != 0)
                imgPoweredByLogo.setImageResource(builder.poweredByIcon);
            else
                imgPoweredByLogo.setVisibility(View.GONE);
            txtPoweredByTitle.setText(builder.poweredByTitle != null ? builder.poweredByTitle : "");
            txtPoweredByName.setText(builder.poweredByName != null ? builder.poweredByName : "");
            txtPoweredByAbout.setText(builder.poweredByAbout != null ? builder.poweredByAbout : "");
            txtPoweredByLink.setText(builder.poweredByLink != null ? builder.poweredByLink : "");
        }

        // App Initiator By
        if (builder.showInitiatedBy) {
            layoutInitiatedBy.setVisibility(View.VISIBLE);
            if (builder.initiatedByIcon != 0)
                imgInitiatedByLogo.setImageResource(builder.initiatedByIcon);
            else
                imgInitiatedByLogo.setVisibility(View.GONE);
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
       /* if (builder.showHelpDevelopment) {
            makeVisible(layoutHelpDevelopment);
        }*/

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
                        Toast.makeText(AboutUsActivity.this, "No email client", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void initViews() {
        imgAppLogo = findViewById(R.id.img_app_logo);
        txtAppName = findViewById(R.id.txt_app_name);
        txtAppAbut = findViewById(R.id.txt_app_about);
        txtAppVersionAndLicense = findViewById(R.id.txt_app_version_and_license);

        btnShare = findViewById(R.id.txt_share);
        btnRateUs = findViewById(R.id.txt_rate_us);

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
