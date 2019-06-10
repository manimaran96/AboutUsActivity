package coopon.manimaran.aboutusactivity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;

import java.io.Serializable;

/**
 * Created by Manimaran on 9-Jun-2019.
 */

public class AboutActivityBuilder {
    public static class Builder implements Serializable {

        transient Activity activity;

        String activityTitle = "About us Activity";

        /* App Info Section */
        boolean showAppLogo = false, showAppName = false, showAppAbout = false, showAppVersion = false;
        int appLogo;
        String appName;
        String appAbout;
        String appVersion;

        boolean showLicenseBtn = false, showShareBtn = false, showRateUsBtn = false;
        String hintLicense, hintShare, hintRateUs, licenseUrl, appPlayStoreLink, shareMsgText, shareIntentTitle;

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
        String linkSourceCode;
        String contactMail;

        /* Theme */
        int idTheme = 0;

        public Builder(@NonNull Context thisContext)
        {
            activity = (Activity) thisContext;
        }


        /**
         * Set the theme
         *
         * @param idTheme - App Theme
         * @return this builder
         */
        public Builder setAppTheme(int idTheme) {
            this.idTheme = idTheme;
            return this;
        }

        /**
         * Set Title
         * @param title - title app activity
         * @return
         */
        public Builder setTitle(String title) {
            this.activityTitle = title;
            return this;
        }

        /**
         * Set ImageView in general card
         *
         * @param appLogo -  logo image
         * @return this builder
         */
        public Builder setAppLogo(int appLogo) {
            this.showAppLogo = true;
            this.appLogo = appLogo;
            return this;
        }

        /**
         *  Set App Name
         *
         * @param appName - app name
         * @return
         */
        public Builder setAppName(String appName) {
            this.showAppName = true;
            this.appName = appName;
            return this;
        }


        /**
         *  Set App About Info
         *
         * @param appAbout - about application
         * @return
         */
        public Builder setAppAbout(String appAbout) {
            this.showAppAbout = true;
            this.appAbout = appAbout;
            return this;
        }

        /**
         *  Set Application Version
         *
         * @param appVersion - app version
         * @return
         */
        public Builder setAppVersion(String appVersion) {
            this.showAppVersion = true;
            this.appVersion = appVersion;
            return this;
        }

        /**
         *  Set App License Details
         *
         * @param license - license name
         * @return
         */
        public Builder setLicense(String license, String licenseUrl) {
            this.showLicenseBtn = true;
            this.hintLicense = license;
            this.licenseUrl = licenseUrl;
            return this;
        }


        /**
         *  Set Share details
         *
         * @param shareMsgText - Message content
         * @param shareIntentTitle - Intent Chosen title
         * @return
         */
        public Builder setShare(String shareMsgText, String shareIntentTitle) {
            this.showShareBtn = true;
            this.shareMsgText = shareMsgText;
            this.shareIntentTitle = shareIntentTitle;
            return this;
        }

        /**
         *  Rate the application in play store
         *
         * @param appPlayStoreLink - app play store link
         * @return
         */
        public Builder setRateUs(String appPlayStoreLink) {
            this.showRateUsBtn = true;
            this.appPlayStoreLink = appPlayStoreLink;
            return this;
        }


        /**
         *  Application Developer details. I.e Application Powered by
         *
         * @param poweredByIcon - Icon
         * @param poweredByTitle - Powered by or Developed By
         * @param poweredByName - Name
         * @param poweredByAbout - ABout
         * @param poweredByLink - Web site link
         * @return
         */
        public Builder setPoweredBy(int poweredByIcon, String poweredByTitle, String poweredByName, String poweredByAbout, String poweredByLink) {
            this.showPoweredBy = true;
            this.poweredByIcon = poweredByIcon;
            this.poweredByTitle = poweredByTitle;
            this.poweredByName = poweredByName;
            this.poweredByAbout = poweredByAbout;
            this.poweredByLink = poweredByLink;
            return this;
        }

        /**
         *  Application Initiator name. Like Application Client
         *
         * @param initiatedByIcon - icon
         * @param initiatedByTitle - title
         * @param initiatedByName - name
         * @param initiatedByAbout - about
         * @param initiatedByLink - link
         * @return
         */
        public Builder setInitiatedBy(int initiatedByIcon, String initiatedByTitle, String initiatedByName, String initiatedByAbout, String initiatedByLink) {
            this.showInitiatedBy = true;
            this.initiatedByIcon = initiatedByIcon;
            this.initiatedByTitle = initiatedByTitle;
            this.initiatedByName = initiatedByName;
            this.initiatedByAbout = initiatedByAbout;
            this.initiatedByLink = initiatedByLink;
            return this;
        }

        /**
         *  See Source code
         * @param linkSourceCode - repo link
         * @return
         */
        public Builder setSeeSourceCode(String linkSourceCode) {
            this.showSeeSourceCode = true;
            this.linkSourceCode = linkSourceCode;
            return this;
        }

        /**
         *  Third party library details used in app.
         *
         * @param jsonResOfThirdPartyLib - json file for third party library
         * @return
         */
        public Builder setThirdPartyLibrary(int jsonResOfThirdPartyLib) {
            this.showThirdPartyLibrary = true;
            this.jsonResOfThirdPartyLib = jsonResOfThirdPartyLib;
            return this;
        }

        /**
         *  Credits details - Credits Info of art, images, icons
         * @param jsonResOfCredits - Json file for credits
         * @return
         */
        public Builder setCredits(int jsonResOfCredits) {
            this.showCredits = true;
            this.jsonResOfCredits = jsonResOfCredits;
            return this;
        }

        /**
         *  Help to App Development
         * @param linkSourceCode
         * @return
         */
        public Builder setHelpDevelopment(String linkSourceCode) {
            this.showHelpDevelopment = true;
            return this;
        }

        /**
         *  Contact Details
         *
         * @param contactMail - mail id
         * @return
         */
        public Builder setContactUs(String contactMail) {
            this.showContactUs = true;
            this.contactMail = contactMail;
            return this;
        }

        /**
         * Open Activity
         */
        public void showAboutActivity() {
            if (activity == null) {
                return;
            }
            Intent intent = new Intent(activity, AboutActivity.class);
            intent.putExtra("builder", (Serializable) this);
            if (activity != null) {
                activity.startActivity(intent);
            }
        }
    }
}
