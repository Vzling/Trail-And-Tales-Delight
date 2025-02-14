package show.tatd.mod.init;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Style;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.neoforged.fml.common.asm.enumextension.*;

import java.util.function.IntFunction;
import java.util.function.UnaryOperator;

@NetworkedEnum(NetworkedEnum.NetworkCheck.BIDIRECTIONAL)
@IndexedEnum
@NamedEnum(1)
public enum ModRarity implements StringRepresentable, IExtensibleEnum {
    ANCIENT(0, "ANCIENT", ChatFormatting.WHITE);
    
    private final int id;
    private final String name;
    private final ChatFormatting color;
    private final UnaryOperator<Style> styleModifier;

    private ModRarity(int id, String name, ChatFormatting color) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.styleModifier = (style) -> style.withColor(color);
    }

    private ModRarity(int id, String name, UnaryOperator<Style> styleModifier) {
        this.id = id;
        this.name = name;
        this.color = ChatFormatting.BLACK;
        this.styleModifier = styleModifier;
    }

    /** @deprecated */
    @Deprecated
    public ChatFormatting color() {
        return this.color;
    }

    public UnaryOperator<Style> getStyleModifier() {
        return this.styleModifier;
    }

    public String getSerializedName() {
        return this.name;
    }

    public static ExtensionInfo getExtensionInfo() {
        return ExtensionInfo.nonExtended(net.minecraft.world.item.Rarity.class);
    }
}
