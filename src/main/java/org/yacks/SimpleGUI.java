package org.yacks;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import org.yacks.util.RectBuilder;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.gui.ForgeIngameGui;

public class SimpleGUI extends ForgeIngameGui {

    private static final ResourceLocation IMG = new ResourceLocation("whosidea", "textures/misc/test.png");

    private MatrixStack stack;
    public int scaledWidth;
    public int scaledHeight;
    public SimpleGUI(Minecraft mcIn, MatrixStack stack) {
        super(mcIn);
        this.stack = stack;
        super.getFontRenderer().drawString(this.stack, "text", 100, 100, Integer.parseInt("FFAA00", 16));
        this.scaledWidth = this.mc.getMainWindow().getScaledWidth();
        this.scaledHeight = this.mc.getMainWindow().getScaledHeight();
        System.out.println(String.format("scaled height: %s", this.scaledHeight));
        System.out.println(String.format("scaled Width: %s", this.scaledWidth));
        this.renderImg();
    }

    private void renderImg() {
        // FIXME: make render not over full screen
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.defaultBlendFunc();
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.disableAlphaTest();
        this.mc.getTextureManager().bindTexture(IMG);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        // top left is 0, 0
        // so what we want to do is set each corner then offset it by image width and height
        // bufferbuilder.pos(0.0D, (double) this.scaledHeight, -90.0D).tex(0.0F, 1.0F).endVertex();
        // bufferbuilder.pos((double) this.scaledWidth, (double) this.scaledHeight, -90.0D).tex(1.0F, 1.0F).endVertex();
        // bufferbuilder.pos((double) this.scaledWidth, 0.0D, -90.0D).tex(1.0F, 0.0F).endVertex();
        // bufferbuilder.pos(0.0D, 0.0D, -90.0D).tex(0.0F, 0.0F).endVertex();
        new RectBuilder(this.scaledHeight, this.scaledWidth, 0, 0).posX(50).posY(50).build(bufferbuilder);
        tessellator.draw();
        RenderSystem.depthMask(true);
        RenderSystem.enableDepthTest();
        RenderSystem.enableAlphaTest();
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

}
