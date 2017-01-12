package com.blue.code.java.utils.file;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.pmw.tinylog.Logger;

import com.blue.code.java.utils.exception.ZipUtilException;

public class ZipUtil {
	private static final byte[] buffer = new byte[1024];

	/**
	 * Comprime un archivo
	 * @param fileInput Archivo a comprimir.
	 * @param fileNameToCompress Nombre del archivo a comprimir.
	 * @param zipFileName Nombre del archivo zip final.
	 * @return
	 * @throws ZipUtilException
	 */
	public ZipOutputStream zipFile(FileInputStream fileInput, String fileNameToCompress, String zipFileName)
			throws ZipUtilException {
		ZipOutputStream zipOutputStream = null;
		Logger.debug("Try zip file.");
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(zipFileName);
			zipOutputStream = new ZipOutputStream(fileOutputStream);

			ZipEntry zipEntry = new ZipEntry(fileNameToCompress);
			zipOutputStream.putNextEntry(zipEntry);
			int len;
			while ((len = fileInput.read(buffer)) > 0) {
				zipOutputStream.write(buffer, 0, len);
			}
			fileInput.close();
			zipOutputStream.closeEntry();
			// remember close it
			zipOutputStream.close();
			Logger.debug("Done zip process.");
		} catch (IOException e) {
			Logger.error("An error ocurred when zip package file.", e);
			throw new ZipUtilException("An error ocurred when zip package file.");
		}
		return zipOutputStream;
	}

	/**
	 * Comprime un archivo.
	 * @param is Archivo a comprimir
	 * @param entryFilename nombre del archivo a comprimir.
	 * @return
	 * @throws ZipUtilException
	 */
	public static InputStream zipFile(InputStream is, String entryFilename) throws ZipUtilException {
		Logger.debug("Try zip file.");
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			byte data[] = new byte[2048];
			ZipOutputStream zos = new ZipOutputStream(bos);
			BufferedInputStream entryStream = new BufferedInputStream(is, 2048);
			ZipEntry entry = new ZipEntry(entryFilename);
			zos.putNextEntry(entry);
			int count;
			while ((count = entryStream.read(data, 0, 2048)) != -1) {
				zos.write(data, 0, count);
			}
			entryStream.close();
			zos.closeEntry();
			zos.close();
			Logger.debug("Done zip process.");
		} catch (IOException e) {
			Logger.error("An error ocurred when zip package file.", e);
			throw new ZipUtilException("An error ocurred when zip package file.");
		}
		return new ByteArrayInputStream(bos.toByteArray());
	}
	
	/**
	 * 
	 * @param in
	 * @param file
	 */
	private static void copyInputStreamToFile( InputStream in, File file ) {
	    try {
	        OutputStream out = new FileOutputStream(file);
	        byte[] buf = new byte[1024];
	        int len;
	        while((len=in.read(buf))>0){
	            out.write(buf,0,len);
	        }
	        out.close();
	        in.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	/**
	 * Zip file in zip format.
	 * @param fileToZip
	 * @param entryFilename
	 * @param zipFilename
	 * @return
	 * @throws ZipUtilException
	 */
	public static File zipFile(File fileToZip, String entryFilename, String zipFilename) throws ZipUtilException {		
		Logger.info("Try zip file.");
		File zipFile = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			InputStream is = new FileInputStream(fileToZip);
			
			byte data[] = new byte[2048];
			ZipOutputStream zos = new ZipOutputStream(bos);
			BufferedInputStream entryStream = new BufferedInputStream(is, 2048);
			ZipEntry entry = new ZipEntry(entryFilename);
			zos.putNextEntry(entry);
			int count;
			while ((count = entryStream.read(data, 0, 2048)) != -1) {
				zos.write(data, 0, count);
			}
			entryStream.close();
			zos.closeEntry();
			zos.close();
			
			// Write the final zip file.
			InputStream inputStreamToCopy = new ByteArrayInputStream(bos.toByteArray());
			zipFile = new File(zipFilename);
			copyInputStreamToFile(inputStreamToCopy,zipFile);
			
			Logger.info("Done zip process.");
			
		}catch (FileNotFoundException e) {
			Logger.error("An error ocurred when zip package file.", e);
			throw new ZipUtilException("An error ocurred when zip package file.");
		
		} catch (IOException e) {
			Logger.error("An error ocurred when zip package file.", e);
			throw new ZipUtilException("An error ocurred when zip package file.");
		} 
		
		
		return zipFile;
	}
}
