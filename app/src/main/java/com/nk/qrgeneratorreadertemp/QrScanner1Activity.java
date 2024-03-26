package com.nk.qrgeneratorreadertemp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

/**
 * https://github.com/journeyapps/zxing-android-embedded - GitHub library
 * https://youtu.be/pdYz9BMcpDI?si=i4ymwR1eizTIlkTK - lesson video
 */

public class QrScanner1Activity extends AppCompatActivity {

    private ImageView scannerQrImageView;
    private TextView qrTextView;

    private ActivityResultLauncher<ScanOptions> scannerQrCodeResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_scanner1);
        setReferences();
        setLaunchers();

        scannerQrImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScanOptions options = new ScanOptions();
                    options.setDesiredBarcodeFormats(ScanOptions.QR_CODE);
                    options.setPrompt("Scan QR Code");
                    options.setCameraId(0);
                    options.setBeepEnabled(false);
                    options.setBarcodeImageEnabled(true);
                    options.setOrientationLocked(false);
                scannerQrCodeResultLauncher.launch(options);
            }
        });
    }

    private void setReferences() {
        scannerQrImageView = findViewById(R.id.scanner_qr_image_view);
        qrTextView = findViewById(R.id.qr_text_view);
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