package com.github.documents_please.documents;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.github.documents_please.resources.Assets;

public class InvitePermission extends Document {
    private DocumentImage firstStamp;
    private DocumentImage secondStamp;
    private DocumentText name;
    private DocumentText gender;
    private DocumentText purpose;
    private DocumentText howLong;
    private DocumentText validUntil;
    private DocumentText id;

    public InvitePermission(Texture firstStamp, Texture secondStamp, String name, String gender, String purpose,
                            String howLong, String validUntil, String id) {
        super(Assets.invitePermissionTextureIcon, Assets.invitePermissionTexture, 1750, 800, 1100, 440);

        this.firstStamp = new DocumentImage(firstStamp, x + 30, y + 60, 150, 150);
        this.secondStamp = new DocumentImage(secondStamp, x + 280, y + 60, 150, 150);
        LabelStyle style = new LabelStyle(Assets.mainFont, new Color(0, 0, 0, 1));

        this.name = new DocumentText(name, style, x + 130, y + 505);
        this.gender = new DocumentText(gender, style, x + 120, y + 455);
        this.purpose = new DocumentText(purpose, style, x + 230, y + 410);
        this.howLong = new DocumentText(howLong, style, x + 150, y + 360);
        this.validUntil = new DocumentText(validUntil, style, x + 280, y + 315);
        this.id = new DocumentText(id, style, x + 80, y + 270);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        if (isExtended) {
            firstStamp.render(batch);
            secondStamp.render(batch);
            name.render(batch, parentAlpha);
            gender.render(batch, parentAlpha);
            purpose.render(batch, parentAlpha);
            howLong.render(batch, parentAlpha);
            validUntil.render(batch, parentAlpha);
            id.render(batch, parentAlpha);
        }
    }
}
