package com.supchikwork;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import com.supchikwork.awesomehudClient;
// import net.minecraft.util.math.Direction.Axis;
// import com.mojang.blaze3d.systems.RenderSystem;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;

public class awesomehudOverlay implements HudRenderCallback {

	private TextRenderer textRenderer;

	@Override
	public void onHudRender(DrawContext drawContext, float tickDelta)
	{

		int appleX = 0;
		int appleY = 0;

		int compassX = 0;
		int compassY = 0;

		int armorX = 0;
		int armorY = 0;
		float health = 0;

		MinecraftClient client = MinecraftClient.getInstance();
		textRenderer = client.textRenderer;

		if(client != null)
		{
			int width = client.getWindow().getScaledWidth();	 // Ширина екрана
			int height = client.getWindow().getScaledHeight();  // Висота екрана

			// health = client.player.getHealth();

			// String hp = String.format("HP: %.2f", health/2);


			int ba = 16;		// Відступ між предметами

			compassX = width - 20 - 20;
			compassY = height - 20;

			// ItemStack apple = new ItemStack(Items.APPLE);


			armorX = width - 20;
			armorY = height - 20;


			Iterable<ItemStack> armorItems = client.player.getArmorItems();



			for (ItemStack armorItem : armorItems) {
    			drawContext.drawItem(armorItem, armorX, armorY);		// Малюю предмет
    			armorY -= ba; 											// Плюс (але блін мінус) до позиції
			}
			// drawContext.drawText(textRenderer, hp, x, y, 0xFF1010, true);

			ItemStack rcompas = new ItemStack( Items.RECOVERY_COMPASS );
			ItemStack clock   = new ItemStack(       Items.CLOCK     );
			ItemStack compas  = new ItemStack(      Items.COMPASS     );

			drawContext.drawItem( rcompas, compassX, compassY      );
			drawContext.drawItem( clock  , compassX, compassY - 20 );
			drawContext.drawItem( compas , compassX, compassY - 40 );
		}
	}
}
