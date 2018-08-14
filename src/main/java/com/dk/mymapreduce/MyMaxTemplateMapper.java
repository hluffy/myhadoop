package com.dk.mymapreduce;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MyMaxTemplateMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	private static final int MISSING = 9999;

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String line = value.toString();
//		年份
		String year = line.substring(15,19);
//		气温
		int airTemplate;
		if(line.charAt(87)=='+'){
			airTemplate = Integer.parseInt(line.substring(88, 92));
		}else{
			airTemplate = Integer.parseInt(line.substring(87, 92));
		}
		
//		质量
		String quality = line.substring(92, 93);
		
//		判断气温是否合法
		if(airTemplate != MISSING && quality.matches("[0,1,4,5,9]")){
			context.write(new Text(year), new IntWritable(airTemplate));
		}
		
	}
	

}
