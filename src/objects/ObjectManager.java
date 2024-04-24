package objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import entities.Enemy;
import entities.Player;
import gamestates.Playing;
import levels.Level;
import utilz.LoadSave;
import static utilz.Constants.ObjectConstants.*;


public class ObjectManager {

	private Playing playing;
	private BufferedImage spikeImg;
	

	private Level currentLevel;

	public ObjectManager(Playing playing) {
		this.playing = playing;
		currentLevel = playing.getLevelManager().getCurrentLevel();
		loadImgs();
	}

	public void checkSpikesTouched(Player p) {
		for (Spike s : currentLevel.getSpikes())
			if (s.getHitbox().intersects(p.getHitbox()))
				p.kill();
	}

	public void checkSpikesTouched(Enemy e) {
		for (Spike s : currentLevel.getSpikes())
			if (s.getHitbox().intersects(e.getHitbox()))
				e.hurt(200);
	}

	public void loadObjects(Level newLevel) {
		currentLevel = newLevel;
	}

	private void loadImgs() {

		spikeImg = LoadSave.GetSpriteAtlas(LoadSave.TRAP_ATLAS);

	}

	public void draw(Graphics g, int xLvlOffset) {
		drawTraps(g, xLvlOffset);
	}

	private void drawTraps(Graphics g, int xLvlOffset) {
		for (Spike s : currentLevel.getSpikes())
			g.drawImage(spikeImg, (int) (s.getHitbox().x - xLvlOffset), (int) (s.getHitbox().y - s.getyDrawOffset()), SPIKE_WIDTH, SPIKE_HEIGHT, null);

	}

	public void resetAllObjects() {
		loadObjects(playing.getLevelManager().getCurrentLevel());
	}
}
