package me.jacktym.shouttimer.util;

import java.awt.Color;

public class ColorUtil {

	public static int getRainbow(float seconds, float saturation, float brightness) {
		float hue = (System.currentTimeMillis() % (int)(seconds * 1000)) / (float)(seconds * 1000f);
		int color = Color.HSBtoRGB(hue, saturation, brightness);
		return color;
	}

}
