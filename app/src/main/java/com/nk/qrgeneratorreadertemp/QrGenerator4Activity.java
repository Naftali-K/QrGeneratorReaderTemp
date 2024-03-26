package com.nk.qrgeneratorreadertemp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

/**
 * https://youtu.be/n8HdrLYL9DA?si=DAbdCxUtSnzyfjc_ - lesson video
 * https://youtu.be/eEm2XzVtAlA?si=_SIKLbjb7jDhAieC
 * https://github.com/journeyapps/zxing-android-embedded - GitHub library
 */

public class QrGenerator4Activity extends AppCompatActivity {

    private ImageView qrCodeImageView;
    private EditText qrEditText;
    private Button generateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_generator4);
        setReferences();

        generateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string = qrEditText.getText().toString().trim();
                generateQR(string);
            }
        });
    }

    private void setReferences() {
        qrCodeImageView = findViewById(R.id.qr_code_image_view);
        qrEditText = findViewById(R.id.qr_edit_text);
        generateBtn = findViewById(R.id.generate_btn);
    }

    private void generateQR(String value) {
        MultiFormatWriter writer = new MultiFormatWriter();

        try {
            BitMatrix bitMatrix = writer.encode(value, BarcodeFormat.QR_CODE, 400, 400);

            BarcodeEncoder encoder = new BarcodeEncoder();
            Bitmap bitmap = encoder.createBitmap(bitMatrix);

            qrCodeImageView.setImageBitmap(bitmap);
        } catch (WriterException e) {
            throw new RuntimeException(e);
        }

    }
}