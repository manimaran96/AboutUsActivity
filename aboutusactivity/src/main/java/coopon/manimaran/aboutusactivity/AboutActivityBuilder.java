package coopon.manimaran.aboutusactivity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;

import androidx.annotation.NonNull;

import java.io.Serializable;

/**
 * Created by Manimaran on 9-Jun-2019.
 */

public class AboutActivityBuilder {
    public static class Builder implements Serializable {

        transient Activity acc;
        transient Fragment frag;

        String activityTitle = "About us Activity";

        /* App Info Section */
        boolean showAppLogo = false, showAppName = false, showAppAbout = false, showAppVersion = false;
        int appLogo;
        String appName, appAbout, appVersion, appPackageName;

        boolean showLicenseBtn = false, showShareBtn = false, showRateUsBtn = false;
        String hintLicense, hintShare, hintRateUs, appPlayStoreLink, shareMsgText, shareIntentTitle;

        /* Powered By Section */
        boolean showPoweredBy = false;
        int poweredByIcon;
        String poweredByTitle, poweredByName, poweredByAbout, poweredByLink;

        /* Initiated By Section */
        boolean showInitiatedBy = false;
        int initiatedByIcon;
        String initiatedByTitle, initiatedByName, initiatedByAbout, initiatedByLink;

        /* Others */
        boolean showSeeSourceCode = false, showThirdPartyLibrary = false, showHelpDevelopment = false;
        boolean showCredits = false, showContactUs = false;
        Integer jsonResOfCredits, jsonResOfThirdPartyLib;
        String linkSourceCode, textForContactMail;
        String contactMail;

        /* Theme */
        int idTheme = 0;


        private Intent intent;

        public Builder(@NonNull Activity act) {
            this.acc = act;
        }

        public Builder(@NonNull Fragment frag) {
            this.frag = frag;
        }


        /**
         * Set the theme
         *
         * @param idTheme
         * @return this builder
         */
        public Builder setAppTheme(int idTheme) {
            this.idTheme = idTheme;
            return this;
        }

        public Builder setTitle(String title) {
            this.activityTitle = title;
            return this;
        }

        /**
         * Set ImageView in general card
         *
         * @param appLogo
         * @return this builder
         */
        public Builder setAppLogo(int appLogo) {
            this.showAppLogo = true;
            this.appLogo = appLogo;
            return this;
        }

        public Builder setAppName(String appName) {
            this.showAppName = true;
            this.appName = appName;
            return this;
        }

        public Builder setAppAbout(String appAbout) {
            this.showAppAbout = true;
            this.appAbout = appAbout;
            return this;
        }

        public Builder setAppVersion(String appVersion) {
            this.showAppVersion = true;
            this.appVersion = appVersion;
            return this;
        }

        public Builder setLicense(String license) {
            this.showLicenseBtn = true;
            this.hintLicense = license;
            return this;
        }


        public Builder setShare(String shareMsgText, String shareIntentTitle) {
            this.showShareBtn = true;
            this.shareMsgText = shareMsgText;
            this.shareIntentTitle = shareIntentTitle;
            return this;
        }

        public Builder setRateUs(String appPlayStoreLink) {
            this.showRateUsBtn = true;
            this.appPlayStoreLink = appPlayStoreLink;
            return this;
        }


        public Builder setPoweredBy(int poweredByIcon, String poweredByTitle, String poweredByName, String poweredByAbout, String poweredByLink) {
            this.showPoweredBy = true;
            this.poweredByIcon = poweredByIcon;
            this.poweredByTitle = poweredByTitle;
            this.poweredByName = poweredByName;
            this.poweredByAbout = poweredByAbout;
            this.poweredByLink = poweredByLink;
            return this;
        }

        public Builder setInitiatedBy(int initiatedByIcon, String initiatedByTitle, String initiatedByName, String initiatedByAbout, String initiatedByLink) {
            this.showInitiatedBy = true;
            this.initiatedByIcon = initiatedByIcon;
            this.initiatedByTitle = initiatedByTitle;
            this.initiatedByName = initiatedByName;
            this.initiatedByAbout = initiatedByAbout;
            this.initiatedByLink = initiatedByLink;
            return this;
        }

        public Builder setSeeSourceCode(String linkSourceCode) {
            this.showSeeSourceCode = true;
            this.linkSourceCode = linkSourceCode;
            return this;
        }

        Builder setThirdPartyLibrary(int jsonResOfThirdPartyLib) {
            this.showThirdPartyLibrary = true;
            this.jsonResOfThirdPartyLib = jsonResOfThirdPartyLib;
            return this;
        }

        public Builder setCredits(int jsonResOfCredits) {
            this.showCredits = true;
            this.jsonResOfCredits = jsonResOfCredits;
            return this;
        }

        public Builder setHelpDevelopment(String linkSourceCode) {
            this.showHelpDevelopment = true;
            return this;
        }

        public Builder setContactUs(String contactMail) {
            this.showContactUs = true;
            this.contactMail = contactMail;
            return this;
        }






        /* *//**
         *
         * @param showLicense true = show card, otherwise the card will be invisible
         * @param notices list of notices where each element is Notice object (es. new Notice("<lib_name>", "<github_link>", "<copyright>", new ApacheSoftwareLicense20())))
         * @param textTitleDialogLicense text like "Open Source License"
         * @param textCloseButton text like "Close"
         * @return this builder
         *//*
        public Builder showLicense(boolean showLicense, NoticesParcelable notices, String textOpenSourceLicense, String textTitleDialogLicense, String textCloseButton)
        {
            this.showLicense = showLicense;
            this.notices = notices;
            this.textOpenSourceLicense = textOpenSourceLicense;
            this.textTitleDialogLicense = textTitleDialogLicense;
            this.textCloseButton = textCloseButton;
            return this;
        }

        *//**
         * Show a card with fab
         * @param showContactUsOnEmail true = show card, otherwise the card will be invisible
         * @param emailAddress email address like "example@gmail.com"
         * @param textContactUsOnEmail text like "For any information contact us"
         * @param textSendAMail text that you see when the choose (to pic the email application) (es. "Send a mail..")
         * @return this builder
         *//*
        public Builder showContactUsOnEmail(boolean showContactUsOnEmail, String emailAddress, String textContactUsOnEmail, String textSendAMail)
        {
            this.showContactUsOnEmail = showContactUsOnEmail;
            this.emailAddress = emailAddress;
            this.textContactUsOnEmail = textContactUsOnEmail;
            this.textSendAMail = textSendAMail;
            return this;
        }
        *//**
         *
         * @param showRecommendedApps true = show card, otherwise the card will be invisible
         * @param marketDevPageLink link to the developer's page
         * @param textLabelRecommendedApps text like "Recommended by Someone"
         * @return this builder
         *//*
        public Builder showRecommendedApps(boolean showRecommendedApps, String marketDevPageLink, String textLabelRecommendedApps)
        {
            this.showRecommendedApps = showRecommendedApps;
            this.marketDevPageLink = marketDevPageLink;
            this.textLabelRecommendedApps = textLabelRecommendedApps;
            return this;
        }

        *//**
         * Show a card with version of the app
         * @param showAppVersion true = show card, otherwise the card will be invisible
         * @param textLabel text to show (eg. "Version:")
         * @param version version of the app (eg. "1.0")
         * @return this builder
         *//*
        public Builder showAppVersion(boolean showAppVersion, String textLabel, String version)
        {
            this.showAppVersion = showAppVersion;
            this.textLabel = textLabel;
            this.version = version;
            return this;
        }

        *//**
         * Show a card with 3 button (Facebook, Google and Telegram)
         * @param showFollowOnSocial true = show card, otherwise the card will be invisible
         * @param textFollowUsOn text like "Follow us on"
         * @param facebookPath facebook link (if it is null than the Facebook button will not be showed)
         * @param googlePlusPath google+ link (if it is null than the GooglePlus button will not be showed)
         * @param telegramPath telegram link (if it is null than the Telegram button will not be showed)
         * @return this builder
         *//*
        public Builder showFollowOnSocial(boolean showFollowOnSocial, String textFollowUsOn, String facebookPath, String googlePlusPath, String telegramPath)
        {
            this.showFollowOnSocial = showFollowOnSocial;
            this.textFollowUsOn = textFollowUsOn;
            this.facebookPath = facebookPath;
            this.googlePlusPath = googlePlusPath;
            this.telegramPath = telegramPath;
            return this;
        }

        *//**
         * Show a card with starts to rate the app (on click will opened the app in the playstore)
         * @param showRateApp true = show card, otherwise the card will be invisible
         * @param packageName package name needed to open the app in the playstore (eg. just call the function "getPackageName()")
         * @param textLabelRateThisApp text like "Rate this app"
         * @return this builder
         *//*
        public Builder showRateApp(boolean showRateApp, String packageName, String textLabelRateThisApp)
        {
            this.showRateApp = showRateApp;
            this.packageName = packageName;
            this.textLabelRateThisApp = textLabelRateThisApp;
            return this;
        }

        */

        /**
         * Show a card with the application logo and so on
         *
         * @param showGeneral           true = show card, otherwise the card will be invisible
         * @param textApplicationName   the application name
         * @param packageName           package name needed to open the app in the playstore (eg. just call the function "getPackageName()")
         * @param textDeveloper         text like "Developed by Developer"
         * @param textThanks            text like "Thank you so much for downloading our application"
         * @param textTitleChooserShare text like "Share with"
         * @return this builder
         *//*
        public Builder showGeneral(boolean showGeneral, String textApplicationName, String packageName, String textDeveloper, String textThanks, String textTitleChooserShare)
        {
            this.showGeneral = showGeneral;
            this.textApplicationName = textApplicationName;
            this.packageName = packageName;
            this.textDeveloper = textDeveloper;
            this.textThanks = textThanks;
            this.textTitleChooserShare = textTitleChooserShare;
            return this;
        }*/
        public void showAboutActivity() {
            if (acc == null) {
                return;
            }
            Intent intent = new Intent(acc, AboutActivity.class);
            intent.putExtra("builder", (Serializable) this);
            if (frag != null) {
                frag.startActivity(intent);
            } else {
                acc.startActivity(intent);
            }
        }
    }
}
