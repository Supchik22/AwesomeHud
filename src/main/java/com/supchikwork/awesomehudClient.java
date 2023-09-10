package com.supchikwork;



import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public class awesomehudClient implements ClientModInitializer {

	@Override
	public void onInitializeClient()
	{
		HudRenderCallback.EVENT.register(new awesomehudOverlay());
		//KeyInputHandler.register();
	}
}
