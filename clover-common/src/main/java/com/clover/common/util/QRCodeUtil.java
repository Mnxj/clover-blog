package com.clover.common.util;

import com.clover.common.domain.BusinessException;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.clover.common.domain.CommonErrorCode;
import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/**
 * @ClassName: QRCodeUtil
 * @Description:    二维码工具类
 * @Author: Clover
 * @Date: 2021.03.18
 * Version: 1.0
 */
public class QRCodeUtil {
	/**
	 * 生成二维码
	 * @param content 二维码对应的URL
	 * @param width 二维码图片宽度
	 * @param height 二维码图片高度
	 * @return
	 */
	public String createQRCode(String content, int width, int height) throws IOException {
		String resultImage = "";
		//除了尺寸，传入内容不能为空
		if (!StringUtils.isEmpty(content)) {
			ServletOutputStream stream = null;
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			//二维码参数
			@SuppressWarnings("rawtypes")
			HashMap<EncodeHintType, Comparable> hints = new HashMap<>();
			//指定字符编码为“utf-8”
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
			//L M Q H四个纠错等级从低到高，指定二维码的纠错等级为M
			//纠错级别越高，可以修正的错误就越多，需要的纠错码的数量也变多，相应的二维吗可储存的数据就会减少
			hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
			//设置图片的边距
			hints.put(EncodeHintType.MARGIN, 1);

			try {
				//zxing生成二维码核心类
				QRCodeWriter writer = new QRCodeWriter();
				//把输入文本按照指定规则转成二维吗
				BitMatrix bitMatrix = writer.encode(content, BarcodeFormat.QR_CODE, width, height, hints);
				//生成二维码图片流
				BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
				//输出流
				ImageIO.write(bufferedImage, "png", os);
				/**
				 * 原生转码前面没有 data:image/png;base64 这些字段，返回给前端是无法被解析，所以加上前缀
				 */
				resultImage = "data:image/png;base64," + EncryptUtil.encodeBase64(os.toByteArray());
				return resultImage;
			} catch (Exception e) {
				e.printStackTrace();
				throw new BusinessException(CommonErrorCode.E_200007);
			} finally {
				if (stream != null) {
					stream.flush();
					stream.close();
				}
			}
		}
		return null;
	}
	public static byte[] readInputStream(InputStream inputStream) throws Exception {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while((len = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, len);//写到内存
		}
		inputStream.close();
		return outputStream.toByteArray();
	}
	public static void main(String[] args) throws Exception {
		String urlOrPath = "https://gitee.com/to_toast_bread/images/raw/master/img/2021_04_15/1618478379359_af367affb8e9415baa0cafec8ecf7a2b.jpg";
	}

}
