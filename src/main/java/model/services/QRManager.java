package br.edu.ifs.academico.model.services;

import java.awt.image.BufferedImage;

import com.github.sarxos.webcam.Webcam;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRManager {

	public static void readQR() {

		Webcam cam = Webcam.getDefault();
		cam.open();

		do {

			BufferedImage image = cam.getImage();

			LuminanceSource source = new BufferedImageLuminanceSource(image);
			BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
			Result result = null;

			try {

				result = new QRCodeReader().decode(bitmap);

			} catch (NotFoundException | ChecksumException | FormatException e) {

				System.out.println("Não encontrado");
				continue;

			}

			if (result != null) {

				System.out.println(result.getText());

			}

		} while (true);

	}

	public static BufferedImage generateQR(String content) {

		QRCodeWriter qrWriter = new QRCodeWriter();
		BufferedImage image = null;

		try {

			BitMatrix bitMatrix = qrWriter.encode(content, BarcodeFormat.QR_CODE, 350, 350);
			image = MatrixToImageWriter.toBufferedImage(bitMatrix);

		} catch (WriterException e) {

			e.printStackTrace();
		}

		return image;

	}

}
