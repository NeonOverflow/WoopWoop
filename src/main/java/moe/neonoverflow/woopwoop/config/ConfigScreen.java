package moe.neonoverflow.woopwoop.config;

import moe.neonoverflow.woopwoop.WoopWoopMod;
import net.minecraft.client.gui.screen.DirectConnectScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;

public class ConfigScreen extends Screen {
    private final Screen parent;
    private TextFieldWidget triggerDurability;

    public ConfigScreen(Screen parent) {
        super(new TranslatableText("woopwoop.config.title"));
        this.parent = parent;
    }

    @Override
    public void onClose() {
        if(checkFields()) {
            commit();
            client.setScreen(parent);
        }
    }

    @Override
    public void init() {
        this.triggerDurability = new TextFieldWidget(this.textRenderer, this.width / 2 - 100, 40, 200, 15, new TranslatableText("woopwoop.config.triggerdurability"));
        this.triggerDurability.setText(Integer.toString(WoopWoopConfigurator.CONFIG.triggerDurability));
        addDrawableChild(new ButtonWidget(this.width / 2 - 50, this.height - 45, 100, 20, new TranslatableText("woopwoop.config.save"), button -> onClose()));
        addDrawableChild(triggerDurability);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        drawTextWithShadow(matrices, this.textRenderer, new TranslatableText("woopwoop.config.triggerdurability"), this.width / 2 - 100, 30, 0xA0A0A0);
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 15, 0xFFFFFF);
        super.render(matrices, mouseX, mouseY, delta);
    }

    public void commit() {
        WoopWoopConfigurator.CONFIG.triggerDurability = Integer.parseInt(triggerDurability.getText());
        WoopWoopMod.CONFIGURATOR.save();
    }

    private boolean checkFields() {
        if(!triggerDurability.getText().matches("-?\\d+")) { return false; }
        return true;
    }
}
