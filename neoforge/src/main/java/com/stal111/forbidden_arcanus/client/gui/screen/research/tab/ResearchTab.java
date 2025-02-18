package com.stal111.forbidden_arcanus.client.gui.screen.research.tab;

import com.mojang.blaze3d.systems.RenderSystem;
import com.stal111.forbidden_arcanus.ForbiddenArcanus;
import com.stal111.forbidden_arcanus.client.gui.screen.research.KnowledgeWidget;
import com.stal111.forbidden_arcanus.common.research.Knowledge;
import com.stal111.forbidden_arcanus.core.registry.FARegistries;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author stal111
 * @since 18.11.2023
 */
public class ResearchTab extends AbstractTab {

    private static final ResourceLocation BACKGROUND = ForbiddenArcanus.location("textures/gui/research/background.png");
    private static final ResourceLocation BACKGROUND_STARS = ForbiddenArcanus.location("textures/gui/research/background_stars.png");
    private static final ResourceLocation BACKGROUND_STELLAR_DUST_0 = ForbiddenArcanus.location("textures/gui/research/background_stellar_dust_0.png");
    private static final ResourceLocation BACKGROUND_STELLAR_DUST_1 = ForbiddenArcanus.location("textures/gui/research/background_stellar_dust_1.png");

    private final List<KnowledgeWidget> knowledgeWidgets = new ArrayList<>();

    private double scrollX;
    private double scrollY;

    private int minX = Integer.MAX_VALUE;
    private int minY = Integer.MAX_VALUE;
    private int maxX = Integer.MIN_VALUE;
    private int maxY = Integer.MIN_VALUE;

    public ResearchTab(int width, int height) {
        super(width, height);
    }

    @Override
    public void init() {
        for (Knowledge entry : Minecraft.getInstance().level.registryAccess().registryOrThrow(FARegistries.KNOWLEDGE)) {
            this.knowledgeWidgets.add(new KnowledgeWidget(entry.displayInfo(), 0, 0));
        }
    }

    @Override
    public void tick() {
        for (KnowledgeWidget widget : this.knowledgeWidgets) {
            widget.tick();
        }
    }

    @Override
    public void renderBg(@NotNull GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        int i = Mth.floor(this.scrollX);
        int j = Mth.floor(this.scrollY);

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();

        guiGraphics.blit(BACKGROUND, 0, 0, -i * 0.9F, -j * 0.9F, this.getWidth(), this.getHeight(), 512, 512);

        guiGraphics.blit(BACKGROUND_STELLAR_DUST_0, (int) (i * 1.15F), (int) (j * 1.15F), 0, 0, 512, 512, 512, 512);
        guiGraphics.blit(BACKGROUND_STELLAR_DUST_1, (int) (this.getWidth() / 2 + i * 1.15F), (int) (this.getHeight() / 2 + j * 1.15F), 0, 0, 512, 512, 512, 512);

        guiGraphics.blit(BACKGROUND_STARS, 0, 0, -i * 1.35F, -j * 1.35F, this.getWidth(), this.getHeight(), 512, 512);

        RenderSystem.disableBlend();

        for (KnowledgeWidget widget : this.knowledgeWidgets) {
            widget.render(guiGraphics, mouseX, mouseY, partialTick);
        }
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
        this.scroll(dragX, dragY);

        return false;
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double scrollX, double scrollY) {
        this.scroll(scrollX * 16.0D, scrollY * 16.0D);

        return false;
    }

    public void scroll(double dragX, double dragY) {
//        this.scrollX = Mth.clamp(this.scrollX + dragX, -(this.maxX - 234), 0.0D);
//
//        this.scrollY = Mth.clamp(this.scrollY + dragY, -(this.maxY - 113), 0.0D);

        this.scrollX += dragX;
        this.scrollY += dragY;

        for (KnowledgeWidget widget : this.knowledgeWidgets) {
            widget.setX(widget.calculatePositionX((int) this.scrollX));
            widget.setY(widget.calculatePositionY((int) this.scrollY));
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        for (KnowledgeWidget widget : this.knowledgeWidgets) {
            if (widget.mouseClicked(mouseX, mouseY, button)) {
                return true;
            }
        }

        return false;
    }
}
