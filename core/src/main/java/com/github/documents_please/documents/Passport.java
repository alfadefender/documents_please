package com.github.documents_please.documents;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.github.documents_please.resources.Assets;

public class Passport extends Document {
    private DocumentImage photo;
    private DocumentImage stamp;
    private DocumentText name;
    private DocumentText surname;
    private DocumentText address;
    private DocumentText id;
    private DocumentText age;
    private DocumentText gender;
    private DocumentText validUntil;

    public Passport(AtlasRegion photo, Texture stamp, String name, String surname, String address, String id, String age,
                    String gender, String validUntil) {
        super(Assets.passportTextureIcon, Assets.passportTexture, 1750, 940, 550, 440);

        this.photo = new DocumentImage(photo, x + 30, y + 390, 200, 200);
        this.stamp = new DocumentImage(stamp, x + 275, y + 400, 150, 150);
        LabelStyle style = new LabelStyle(Assets.mainFont, new Color(0, 0, 0, 1));

        this.name = new DocumentText(name, style, x + 150, y + 320);
        this.surname = new DocumentText(surname, style, x + 200, y + 270);
        this.address = new DocumentText(address, style, x + 150, y + 230);
        this.id = new DocumentText(id, style, x + 320, y + 185);
        this.age = new DocumentText(age, style, x + 200, y + 135);
        this.gender = new DocumentText(gender, style, x + 120, y + 90);
        this.validUntil = new DocumentText(validUntil, style, x + 200, y + 40);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        if (isExtended) {
            photo.render(batch);
            stamp.render(batch);
            name.render(batch, parentAlpha);
            surname.render(batch, parentAlpha);
            address.render(batch, parentAlpha);
            id.render(batch, parentAlpha);
            age.render(batch, parentAlpha);
            gender.render(batch, parentAlpha);
            validUntil.render(batch, parentAlpha);
        }
    }
}
