package com.nk.qrgeneratorreadertemp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * https://github.com/kenglxn/QRGen - GitHub
 * https://stackoverflow.com/questions/42155015/how-to-generate-a-custom-qr-code-in-android-programmatically-using-zxing-library
 */

public class QrGenerator2Activity extends AppCompatActivity {

    private ImageView qrCodeImageView;
    private EditText qrEditText;
    private Button generateBtn;
    private Bitmap qrCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_generator2);
        setReferences();

        generateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = qrEditText.getText().toString();
                generateQR(text);
            }
        });
    }

    private void setReferences() {
        qrCodeImageView = findViewById(R.id.qr_code_image_view);
        qrEditText = findViewById(R.id.qr_edit_text);
        generateBtn = findViewById(R.id.generate_btn);
    }

    private void generateQR(String value) {
//        File file = QRCode.from(value).file();
//        String filePath = file.getPath();
//        Bitmap bitmap = BitmapFactory.decodeFile(filePath);
//
//        qrCodeImageView.setImageBitmap(bitmap);
    }
}