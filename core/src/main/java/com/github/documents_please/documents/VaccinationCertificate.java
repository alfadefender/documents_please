package com.github.documents_please.documents;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.github.documents_please.resources.Assets;

public class VaccinationCertificate extends Document {
    private DocumentImage stamp;
    private DocumentText name;
    private DocumentText surname;
    private DocumentText disease;
    private DocumentText date;

    public VaccinationCertificate(Texture stamp, String name, String surname, String disease, String date) {
        super(Assets.vaccinationTextureIcon, Assets.vaccinationTexture, 1750, 660, 1100, 440);

        this.stamp = new DocumentImage(stamp, x + 220, y + 60, 150, 150);
        Label.LabelStyle style = new Label.LabelStyle(Assets.mainFont, new Color(0, 0, 0, 1));

        this.name = new DocumentText(name, style, x + 130, y + 500);
        this.surname = new DocumentText(surname, style, x + 220, y + 445);
        this.disease = new DocumentText(disease, style, x + 20, y + 340);
        this.date = new DocumentText(date, style, x + 20, y + 235);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        if (isExtended) {
            stamp.render(batch);
            name.render(batch, parentAlpha);
            surname.render(batch, parentAlpha);
            disease.render(batch, parentAlpha);
            date.render(batch, parentAlpha);
        }
    }
}
