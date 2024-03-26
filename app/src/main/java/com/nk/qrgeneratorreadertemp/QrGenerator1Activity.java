package com.nk.qrgeneratorreadertemp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

/**
 * https://github.com/androidmads/QRGenerator - implementation GitHyb
 * https://youtu.be/rpIWHXX3Ai0?si=ps6LjR0GudlgmsJc - lesson video.
 */

public class QrGenerator1Activity extends AppCompatActivity {

    private ImageView qrCodeImageView;
    private EditText qrEditText;
    private Button generateBtn;
    private Bitmap qrCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_generator1);
        setReferences();

        generateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputValue = qrEditText.getText().toString();
                generateQR(inputValue);
            }
        });
    }

    private void setReferences() {
        qrCodeImageView = findViewById(R.id.qr_code_image_view);
        qrEditText = findViewById(R.id.qr_edit_text);
        generateBtn = findViewById(R.id.generate_btn);
    }

    private void generateQR(String value) {
        QRGEncoder qrgEncoder = new QRGEncoder(value, null, QRGContents.Type.TEXT, 256);
//        qrgEncoder.setColorBlack(Color.WHITE); //lines color
//        qrgEncoder.setColorWhite(Color.BLACK); //background color

        qrCode = qrgEncoder.getBitmap(0);
        qrCodeImageView.setImageBitmap(qrCode);
    }
}