package com.codedead.deadhash.domain.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import com.codedead.deadhash.R;

public final class IntentUtils {

    /**
     * Initialize a new IntentUtils
     */
    private IntentUtils() {
        // Empty constructor
    }

    /**
     * Open a specific website using an Intent
     *
     * @param context The Context that can be used to open an Intent
     * @param site    The website that should be opened
     */
    public static void openSite(final Context context, final String site) {
        if (context == null)
            throw new NullPointerException("Context cannot be null!");
        if (site == null)
            throw new NullPointerException("Site cannot be null!");
        if (site.length() == 0)
            throw new IllegalArgumentException("Site cannot be empty!");

        try {
            final Uri uriUrl = Uri.parse(site);
            final Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
            context.startActivity(launchBrowser);
        } catch (final Exception ex) {
            Toast.makeText(context, context.getString(R.string.error_website), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Open the Play Store using an Intent
     *
     * @param context The Context that can be used to open the Play Store
     */
    public static void openPlayStore(final Context context) {
        if (context == null)
            throw new NullPointerException("Context cannot be null!");

        final Intent intent = new Intent(Intent.ACTION_VIEW);
        try {
            intent.setData(Uri.parse("market://details?id=com.codedead.deadhash"));
            context.startActivity(intent);
        } catch (final Exception ignored) {
            Toast.makeText(context, context.getString(R.string.error_playstore), Toast.LENGTH_SHORT).show();
        }
    }
}
