package com.khaled;

import java.io.InputStream;

public class Image {
	public InputStream image;
	public Image()
	{
		this.image = this.getClass().getClassLoader().getResourceAsStream("nutrioAppImage.jpg");
	}

}
