package com.dk.myhdfs.test;



import java.io.FileOutputStream;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;


/**
 * 通过API访问HDFS
 * @author rikka
 *
 */
public class TestHdfs {
	/**
	 * 写操作
	 * @throws Exception
	 */
//	@Test
	public void writeFileTest() throws Exception{
		Configuration conf = new Configuration();
//		conf.set("fs.defaultFS", "hdfs://localhost:9000");
//		FileSystem fs = FileSystem.get(conf);
		
		Path path = new Path("hdfs://localhost:9000/user/rikka/helloworld.txt");
		FileSystem fs = path.getFileSystem(conf);
//		数据输出流
		FSDataOutputStream dos = fs.create(path);
		dos.write("HelloWorld2\n".getBytes());
		dos.close();
		System.out.println("over");
	}
	
	/**
	 * 读操作
	 * @throws Exception
	 */
	@Test
	public void readFileTest() throws Exception{
		Configuration conf = new Configuration();
		
		Path path = new Path("hdfs://localhost:9000/user/rikka/helloworld.txt");
		FileSystem fs = path.getFileSystem(conf);
		FSDataInputStream in = fs.open(path);
//		System.out.println(in.readLine());
		
		FileOutputStream fos = new FileOutputStream("/Users/rikka/myfile/file/helloworld.txt");
		IOUtils.copyBytes(in, fos, 1024);
		IOUtils.closeStream(in);
		IOUtils.closeStream(fos);
		
		System.out.println("over");
		
	}

}
