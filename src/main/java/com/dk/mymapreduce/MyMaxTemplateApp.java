package com.dk.mymapreduce;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MyMaxTemplateApp {
	public static void main(String[] args) throws Exception{
		if(args.length != 2){
			System.out.println("需要两个参数");
			System.exit(-1);
		}
		
		Job job = Job.getInstance();
		job.setJarByClass(MyMaxTemplateApp.class);
		job.setJobName("max template");
		
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.setMapperClass(MyMaxTemplateMapper.class);
		job.setReducerClass(MyMaxTemplateReduce.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		System.exit(job.waitForCompletion(true)?0:1);
		
		
	}

}
