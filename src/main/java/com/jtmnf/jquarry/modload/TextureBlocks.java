package com.jtmnf.jquarry.modload;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;

public class TextureBlocks extends TextureAtlasSprite {

    public TextureBlocks(String string) {
        super(string);
    }

    @Override
    public boolean load(IResourceManager manager, ResourceLocation location) {
        return false;
    }
}
