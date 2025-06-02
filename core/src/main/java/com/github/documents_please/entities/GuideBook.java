package com.github.documents_please.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.github.documents_please.documents.Document;
import com.github.documents_please.resources.Assets;

import static com.github.documents_please.resources.Assets.buttonSquaredSize;

public class GuideBook extends Document {
    private int currentPage;
    private Array<Texture> pageTextures;
    private Table switchPagesTable;

    public GuideBook() {
        super(Assets.guideBookIcon, Assets.guideBook.get(0), 1750, 520, 500, 0);
        pageTextures = Assets.guideBook;
        currentPage = 0;

        TextButton firstPage = new TextButton("Тип 1", Assets.buttonSkin, "default");
        firstPage.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                currentPage = 0;
                GuideBook.super.documentTexture = pageTextures.get(currentPage);
            }
        });

        TextButton secondPage = new TextButton("Тип 2", Assets.buttonSkin, "default");
        secondPage.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                currentPage = 1;
                GuideBook.super.documentTexture = pageTextures.get(currentPage);
            }
        });

        TextButton thirdPage = new TextButton("Тип 3", Assets.buttonSkin, "default");
        thirdPage.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                currentPage = 2;
                GuideBook.super.documentTexture = pageTextures.get(currentPage);
            }
        });

        TextButton fourthPage = new TextButton("Тип 4", Assets.buttonSkin, "default");
        fourthPage.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                currentPage = 3;
                GuideBook.super.documentTexture = pageTextures.get(currentPage);
            }
        });

        TextButton fifthPage = new TextButton("Штампы", Assets.buttonSkin, "default");
        fifthPage.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                currentPage = 4;
                GuideBook.super.documentTexture = pageTextures.get(currentPage);
            }
        });

        TextButton sixthPage = new TextButton("...", Assets.buttonSkin, "default");
        sixthPage.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                currentPage = 5;
                GuideBook.super.documentTexture = pageTextures.get(currentPage);
            }
        });

        switchPagesTable = new Table();
        switchPagesTable.setPosition(1410, 530);
        switchPagesTable.add(firstPage).width(buttonSquaredSize.x).height(buttonSquaredSize.y).pad(4).row();
        switchPagesTable.add(secondPage).width(buttonSquaredSize.x).height(buttonSquaredSize.y).pad(4).row();
        switchPagesTable.add(thirdPage).width(buttonSquaredSize.x).height(buttonSquaredSize.y).pad(4).row();
        switchPagesTable.add(fourthPage).width(buttonSquaredSize.x).height(buttonSquaredSize.y).pad(4).row();
        switchPagesTable.add(fifthPage).width(buttonSquaredSize.x).height(buttonSquaredSize.y).pad(4).row();
        switchPagesTable.add(sixthPage).width(buttonSquaredSize.x).height(buttonSquaredSize.y).pad(4).row();

    }

    public Table returnButtons() {
        return switchPagesTable;
    }

    public boolean isExtended() {
        return isExtended;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        if (isExtended) {
            switchPagesTable.draw(batch, parentAlpha);
        }
    }
}
