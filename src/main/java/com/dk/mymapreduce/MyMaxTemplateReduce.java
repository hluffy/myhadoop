package com.dk.mymapreduce;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MyMaxTemplateReduce extends Reducer<Text, IntWritable, Text, IntWritable>{

	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		int maxValue = Integer.MIN_VALUE;
		
//		提取年度的最高气温
		for(IntWritable value:values){
			maxValue = Math.max(maxValue, value.get());
		}
		
//		写出输出
		context.write(key, new IntWritable(maxValue));
	}
	
	
}
