package com.text.project.utils;

import java.io.Serializable;

import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;

public class MyByteSource extends SimpleByteSource implements ByteSource, Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyByteSource(String string) {
		super(string);
	}
	
}
