package com.nk.qrgeneratorreadertemp;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

/**
 * https://github.com/journeyapps/zxing-android-embedded - GitHub library
 * https://youtu.be/pdYz9BMcpDI?si=BwtsukE_pp0ntI-4 - lesson video
 */

public class QrScanner2Activity extends AppCompatActivity {


    private ActivityResultLauncher<String> requestPermissionLaunch =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    showCamera();
                }
    });
    private ActivityResultLauncher<ScanOptions> scannerQrCodeResultLauncher;

    private FloatingActionButton fab;
    private TextView qrTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_scanner2);
        setReferences();
        setLaunchers();

//        scannerQrImageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ScanOptions options = new ScanOptions();
//                    options.setDesiredBarcodeFormats(ScanOptions.QR_CODE);
//                    options.setPrompt("Scan QR Code");
//                    options.setCameraId(0);
//                    options.setBeepEnabled(false);
//                    options.setBarcodeImageEnabled(true);
//                    options.setOrientationLocked(false);
//                scannerQrCodeResultLauncher.launch(options);
//            }
//        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPermissionAndShowActivity(getBaseContext());
            }
        });
    }

    private void setReferences() {
//        scannerQrImageView = findViewById(R.id.scanner_qr_image_view);
        qrTextView = findViewById(R.id.qr_text_view);
        fab = findViewById(R.id.fab);
    }

    private void checkPermissionAndShowActivity(Context context) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            showCamera();
        } else if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
            Toast.makeText(context, "Camera permission requested.", Toast.LENGTH_SHORT).show();
        } else {
            requestPermissionLaunch.launch(Manifest.permission.CAMERA);
        }
    }

    private void showCamera() {
        ScanOptions options = new ScanOptions();
            options.setDesiredBarcodeFormats(ScanOptions.QR_CODE);
            options.setPrompt("Scan QR Code");
            options.setCameraId(0);
            options.setBeepEnabled(false);
            options.setBarcodeImageEnabled(true);
            options.setOrientationLocked(false);
        scannerQrCodeResultLauncher.launch(options);
    }

    private void setLaunchers() {
        scannerQrCodeResultLauncher = registerForActivityResult(new ScanContract(),
                result -> {
                    if(result.getContents() == null) {
                        Toast.makeText(getBaseContext(), "Cancelled", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getBaseContext(), "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                        qrTextView.setText(result.getContents());
                    }
                });
    }
}