package com.jaydip.dropshadowforinsta.gridmaker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.jaydip.dropshadowforinsta.R;
import java.io.File;
import java.io.FileOutputStream;

public class SystemUtils {
    public static void refreshGallery(Context context, String str) {
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.fromFile(new File(str)));
        context.sendBroadcast(intent);
    }

    public static void saveImage(Activity activity, Bitmap bitmap) {
        if (!checkPermisson(activity)) {
            String file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString();
            File file2 = new File(file + "/" + activity.getString(R.string.app_name));
            file2.mkdirs();
            File file3 = new File(file2, "Image-" + System.currentTimeMillis() + ".jpg");
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file3);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                Toast.makeText(activity, "Save image success!", 0).show();
                refreshGallery(activity, file3.getPath());
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(activity, "Save error", 0).show();
            }
        }
    }

    public static boolean checkPermisson(Activity activity) {
        if (ContextCompat.checkSelfPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE") != -1 && ContextCompat.checkSelfPermission(activity, "android.permission.READ_EXTERNAL_STORAGE") != -1) {
            return false;
        }
        ActivityCompat.requestPermissions(activity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 11);
        return true;
    }
}
