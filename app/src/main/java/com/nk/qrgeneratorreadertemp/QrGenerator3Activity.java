package com.nk.qrgeneratorreadertemp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

/**
 * https://github.com/zxing/zxing - GitHub
 * https://stackoverflow.com/questions/28232116/android-using-zxing-generate-qr-code
 */

public class QrGenerator3Activity extends AppCompatActivity {

    private ImageView qrCodeImageView;
    private EditText qrEditText;
    private Button generateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_generator3);
        setReferences();

        generateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string = qrEditText.getText().toString();
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
        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix bitMatrix = null;
        try {
            bitMatrix = writer.encode(value, BarcodeFormat.QR_CODE, 400, 400);

            int w = bitMatrix.getWidth();
            int h = bitMatrix.getHeight();
            int[] pixels = new int[w * h];
            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    pixels[y * w + x] = bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE;
                }
            }

            Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            bitmap.setPixels(pixels, 0, w, 0, 0, w, h);

            qrCodeImageView.setImageBitmap(bitmap);

        } catch (WriterException e) {
            throw new RuntimeException(e);
        }


    }
}