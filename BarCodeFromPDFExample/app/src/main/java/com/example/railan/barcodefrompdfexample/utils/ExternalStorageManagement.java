package com.example.railan.barcodefrompdfexample.utils;

import android.os.Environment;
import android.util.Log;

import java.io.File;

/**
 * Created by ericm on 17-Oct-16.
 */

public abstract class ExternalStorageManagement {

    /* Checks if external storage is available for read and write */
    public static boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    /* Checks if external storage is available to at least read */
    public static boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state);
    }

    public static File getPDFStorageDir(String pdfName) {
        // Get the directory for the user's public pictures directory.
        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOWNLOADS), pdfName);
        if (!file.getParentFile().mkdirs()) {
            Log.e("FILE", "Directory not created");
        }
        return file;
    }

}
