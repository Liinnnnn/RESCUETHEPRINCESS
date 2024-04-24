package entities;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import gamestates.Playing;
import levels.Level;
import utilz.LoadSave;
import static utilz.Constants.EnemyConstants.*;

public class EnemyManager {

	private Playing playing;
	private BufferedImage[][] pigArr;
	private BufferedImage[][] kingPigArr;
	private Level currentLevel;

	public EnemyManager(Playing playing) {
		this.playing = playing;
		loadEnemyImgs();
	}

	public void loadEnemies(Level level) {
		this.currentLevel = level;
	}

	public void update(int[][] lvlData) {
		boolean isAnyActive = false;
		for (Pig p : currentLevel.getPigs()){
			if (p.isActive()) {
				p.update(lvlData, playing);
				isAnyActive = true;
			}
		}

		for(KingPig k : currentLevel.getKings()){
			if(k.isActive()){
				k.update(lvlData, playing);
				isAnyActive = true;
			}
		}
		
		if (!isAnyActive)
			playing.setLevelCompleted(true);
	}

	public void draw(Graphics g, int xLvlOffset) {
		drawPigs(g, xLvlOffset);
		drawKingPig(g, xLvlOffset);
	}


	private void drawPigs(Graphics g, int xLvlOffset) {
		for (Pig p : currentLevel.getPigs()){
			if (p.isActive()) {

				g.drawImage(pigArr[p.getState()][p.getAniIndex()], (int) p.getHitbox().x - xLvlOffset - PIG_DRAWOFFSET_X + p.flipX(),
					(int) p.getHitbox().y - PIG_DRAWOFFSET_Y + (int) p.getPushDrawOffset(), PIG_WIDTH * p.flipW(), PIG_HEIGHT, null);

				p.drawHitbox(g, xLvlOffset);
				p.drawAttackBox(g, xLvlOffset);
			}
		}
	}

	private void drawKingPig(Graphics g, int xLvlOffset){
		for(KingPig k : currentLevel.getKings()){
			if(k.isActive()){
				g.drawImage(kingPigArr[k.getState()][k.getAniIndex()], (int) k.getHitbox().x - xLvlOffset - KINGPIG_DRAWOFFSET_X + k.flipX(), 
				(int) k.getHitbox().y - KINGPIG_DRAWOFFSET_Y + (int) k.getPushDrawOffset(), KINGPIG_WIDTH * k.flipW() ,KINGPIG_HEIGHT, null);
				k.drawHitbox(g, xLvlOffset);
				k.drawAttackBox(g, xLvlOffset);
			}
		}
	}

	public void checkEnemyHit(Rectangle2D.Float attackBox) {
		for (Pig p : currentLevel.getPigs()){
			if (p.isActive())
				if (p.getState() != DEAD && p.getState() != HIT)
					if (attackBox.intersects(p.getHitbox())) {
						p.hurt(100);
						return;
					}
		}

		for(KingPig k : currentLevel.getKings()){
			if(k.isActive())
				if(k.getState() != DEAD && k.getState() != HIT)
					if(attackBox.intersects(k.getHitbox())){
						k.hurt(100);
						return;
					}
		}

	}

	private void loadEnemyImgs() {
		pigArr = getImgArr(LoadSave.GetSpriteAtlas(LoadSave.PIG_SPRITE), 11, 8, PIG_WIDTH_DEFAULT, PIG_HEIGHT_DEFAULT);
		kingPigArr = getImgArr(LoadSave.GetSpriteAtlas(LoadSave.KINGPIG_SPRITE), 12, 8, KINGPIG_WIDTH_DEFAULT, KINGPIG_HEIGHT_DEFAULT);
	}

	private BufferedImage[][] getImgArr(BufferedImage atlas, int xSize, int ySize, int spriteW, int spriteH) {
		BufferedImage[][] tempArr = new BufferedImage[ySize][xSize];
		for (int j = 0; j < tempArr.length; j++)
			for (int i = 0; i < tempArr[j].length; i++)
				tempArr[j][i] = atlas.getSubimage(i * spriteW, j * spriteH, spriteW, spriteH);
		return tempArr;
	}

	public void resetAllEnemies() {
		for (Pig p : currentLevel.getPigs())
			p.resetEnemy();
		for(KingPig k : currentLevel.getKings()){
			k.resetEnemy();
		}
	}

}
