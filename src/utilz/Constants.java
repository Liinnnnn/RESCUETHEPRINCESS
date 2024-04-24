package utilz;

import main.Game;

public class Constants {

	public static final float GRAVITY = 0.04f * Game.SCALE;
	public static final int ANI_SPEED = 25;

	public static class Dialogue {
		public static final int QUESTION = 0;
		public static final int EXCLAMATION = 1;

		public static final int DIALOGUE_WIDTH = (int) (14 * Game.SCALE);
		public static final int DIALOGUE_HEIGHT = (int) (12 * Game.SCALE);

		public static int GetSpriteAmount(int type) {
			switch (type) {
			case QUESTION, EXCLAMATION:
				return 5;
			}

			return 0;
		}
	}

	public static class Projectiles {
		public static final int CANNON_BALL_DEFAULT_WIDTH = 15;
		public static final int CANNON_BALL_DEFAULT_HEIGHT = 15;

		public static final int CANNON_BALL_WIDTH = (int) (Game.SCALE * CANNON_BALL_DEFAULT_WIDTH);
		public static final int CANNON_BALL_HEIGHT = (int) (Game.SCALE * CANNON_BALL_DEFAULT_HEIGHT);
		public static final float SPEED = 0.75f * Game.SCALE;
	}

	public static class ObjectConstants {

		public static final int SPIKE = 4;

		public static final int SPIKE_WIDTH_DEFAULT = 32;
		public static final int SPIKE_HEIGHT_DEFAULT = 32;
		public static final int SPIKE_WIDTH = (int) (Game.SCALE * SPIKE_WIDTH_DEFAULT);
		public static final int SPIKE_HEIGHT = (int) (Game.SCALE * SPIKE_HEIGHT_DEFAULT);

	
	}

	public static class EnemyConstants {
		public static final int PIG = 0;
		public static final int KINGPIG = 1;

		public static final int IDLE = 0;
		public static final int RUNNING = 1;
		public static final int JUMP = 2;
		public static final int FALL = 3;
		public static final int GROUND = 4;
		public static final int HIT = 5;
		public static final int DEAD = 6;
		public static final int ATTACK = 7;

		public static final int PIG_WIDTH_DEFAULT = 34;
		public static final int PIG_HEIGHT_DEFAULT = 28;
		public static final int PIG_WIDTH = (int) (PIG_WIDTH_DEFAULT * Game.SCALE);
		public static final int PIG_HEIGHT = (int) (PIG_HEIGHT_DEFAULT * Game.SCALE);
		public static final int PIG_DRAWOFFSET_X = (int) (10 * Game.SCALE);
		public static final int PIG_DRAWOFFSET_Y = (int) (10 * Game.SCALE);

		public static final int KINGPIG_WIDTH_DEFAULT = 38;
		public static final int KINGPIG_HEIGHT_DEFAULT = 28;
		public static final int KINGPIG_WIDTH = (int) (KINGPIG_WIDTH_DEFAULT * Game.SCALE * 1.5);
		public static final int KINGPIG_HEIGHT = (int) (KINGPIG_HEIGHT_DEFAULT * Game.SCALE * 1.5);
		public static final int KINGPIG_DRAWOFFSET_X = (int) (10 * Game.SCALE);
		public static final int KINGPIG_DRAWOFFSET_Y = (int) (10 * Game.SCALE);

		public static int GetSpriteAmount(int enemy_type, int enemy_state) {
			switch (enemy_state) {

			case IDLE: {
				if (enemy_type == PIG)
					return 11;
				else if(enemy_type == KINGPIG)
					return 12;
			}
			case RUNNING:
				return 6;
			case ATTACK:
				return 5;
			case HIT:
				return 2;
			case DEAD:
				return 4;
			}

			return 0;

		}

		public static int GetMaxHealth(int enemy_type) {
			switch (enemy_type) {
			case PIG:
				return 100;
			case KINGPIG:
				return 200;
			default:
				return 1;
			}
		}

		public static int GetEnemyDmg(int enemy_type) {
			switch (enemy_type) {
			case PIG:
				return 10;
			case KINGPIG:
				return 30;
			default:
				return 0;
			}
		}
	}

	public static class UI {
		public static class Buttons {
			public static final int B_WIDTH_DEFAULT = 190;
			public static final int B_HEIGHT_DEFAULT = 56;
			public static final int B_WIDTH = (int) (B_WIDTH_DEFAULT * Game.SCALE);
			public static final int B_HEIGHT = (int) (B_HEIGHT_DEFAULT * Game.SCALE);
		}

		public static class PauseButtons {
			public static final int SOUND_SIZE_DEFAULT = 42;
			public static final int SOUND_SIZE = (int) (SOUND_SIZE_DEFAULT * Game.SCALE);
		}

		public static class URMButtons {
			public static final int URM_DEFAULT_SIZE = 56;
			public static final int URM_SIZE = (int) (URM_DEFAULT_SIZE * Game.SCALE);

		}

		public static class VolumeButtons {
			public static final int VOLUME_DEFAULT_WIDTH = 28;
			public static final int VOLUME_DEFAULT_HEIGHT = 44;
			public static final int SLIDER_DEFAULT_WIDTH = 215;

			public static final int VOLUME_WIDTH = (int) (VOLUME_DEFAULT_WIDTH * Game.SCALE);
			public static final int VOLUME_HEIGHT = (int) (VOLUME_DEFAULT_HEIGHT * Game.SCALE);
			public static final int SLIDER_WIDTH = (int) (SLIDER_DEFAULT_WIDTH * Game.SCALE);
		}
	}

	public static class Directions {
		public static final int LEFT = 0;
		public static final int UP = 1;
		public static final int RIGHT = 2;
		public static final int DOWN = 3;
	}

	public static class PlayerConstants {
		public static final int IDLE = 0;
		public static final int RUNNING = 1;
		public static final int JUMP = 2;
		public static final int FALLING = 3;
		public static final int GROUND = 4;
		public static final int ATTACK = 6;
		public static final int HIT = 5;
		public static final int DEAD = 7;

		public static int GetSpriteAmount(int player_action) {
			switch (player_action) {
			case RUNNING:
				return 8;
			case IDLE:
				return 11;
			case HIT:
				return 2;
			case ATTACK:
				return 3;
			case DEAD:
				return 4;
			case FALLING:
			case JUMP:
			case GROUND:
			default:
				return 1;
			}
		}
	}

}