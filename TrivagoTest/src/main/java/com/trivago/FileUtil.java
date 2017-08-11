package com.trivago;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



public class FileUtil {

	/** The logger. */
	private static Logger logger = LogManager.getLogger(FileUtil.class);

	/**
	 * Load properties from classpath.
	 *
	 * @param fileFromClasspath the file from classpath
	 * @return the properties
	 * @throws Exception the exception
	 */
	public static Properties readFileAsProperties(String fileFromClasspath)
			throws Exception {
		logger.info("Loading the file " + fileFromClasspath);
		try {
			File file = new File(
					(FileUtil.class.getClassLoader()
							.getResource(fileFromClasspath)).getFile());
			Properties properties = new Properties();
			if (file.exists()) {
				properties.load(ClassLoader
						.getSystemResourceAsStream(fileFromClasspath));
				return properties;
			} else {
				logger.error("File " + fileFromClasspath + " does not exist");
			}
		} catch (IOException e) {
			logger.error("Failed to read file " + fileFromClasspath);
			throw new Exception(e.getCause());
		}
		return null;
	}

	/**
	 * Read file as stream.
	 *
	 * @param fileFromClasspath the file from classpath
	 * @return the input stream
	 * @throws Exception the exception
	 */
	public static InputStream readFileAsStream(String fileFromClasspath)
			throws Exception {
		logger.info("Loading the file " + fileFromClasspath);
		InputStream in = FileUtil.class.getClassLoader().getResourceAsStream(
				fileFromClasspath);
		if (in == null) {
			logger.error("Failed to read file " + fileFromClasspath);
			throw new Exception("Unable to load the file " + fileFromClasspath);
		}
		return in;
	}

	/**
	 * Read properties file from the disk path.
	 *
	 * @param fileDiskPath the file disk path
	 * @return the properties
	 * @throws Exception the exception
	 */
	public static Properties readFileFromExternalPath(String fileDiskPath)
			throws Exception {
		logger.info("Loading the properties from " + fileDiskPath);
		Properties properties = null;
		File filePath = new File(fileDiskPath);
		try {
			if (filePath.exists()) {
				logger.debug("Properties file @ " + filePath.toString());
				properties.load(new FileInputStream(filePath));
			}
		} catch (IOException e) {
			logger.error("Unable to properties read the file from path "
					+ fileDiskPath);
			throw new Exception(e.getCause());
		}
		return properties;
	}

}
