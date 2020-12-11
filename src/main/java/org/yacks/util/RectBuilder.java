package org.yacks.util;

import net.minecraft.client.renderer.BufferBuilder;

public class RectBuilder {

	private int width;
	private int height;

	private int imgx;
	private int imgy;

	private int x;
	private int y;

	public RectBuilder(int width, int height, int imgx, int imgy) {
		this.width = width;
		this.height = height;
		this.imgx = imgx;
		this.imgy = imgy;
	}

	public RectBuilder posX(int x){
		this.x = x;
		return this;
	}
	public RectBuilder posY(int y){
		this.y = y;
		return this;
	}
	public void build(BufferBuilder builder) {
		//bottom left
		builder.pos(this.x, this.height - this.y, -90.0D).tex(0.0F, 1.0F).endVertex();
		//bottom right
		builder.pos(this.width - this.x, this.height - this.y, -90.0D).tex(1.0F, 1.0F).endVertex();
		//Top right
		builder.pos(this.width - this.x, this.y, -90.0D).tex(1.0F, 0.0F).endVertex();
		//top left
		builder.pos(this.x, this.y, -90.0D).tex(0.0F, 0.0F).endVertex();

	}

}
