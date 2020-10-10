import java.util.ArrayList;
import java.util.stream.*;

public class Main {
	static MonsterZoo pz = new MonsterZoo();
	static MonsterZukan zukan = new MonsterZukan();

	public static void main(String[] args) {

		// zukan.MonsterZukan();
		// 初期化する必要あり
		// pz.setMonsterZukan(tempMonster);
		// pz.setMonsterRare(tempMonsterRare);

		//1000ミリ秒（1秒）ずつ止まりながらpz.move()を呼び出し続ける
		//手持ちのボールが無くなったら終了
		while(true){
			try {
				Thread.sleep(1000);
				if(pz.BallCount()>0){
					/// このあたりは確実に変更
					pz.move();
					// System.out.println("手持ちのボールは"+pz.getBalls()+"個，フルーツは"+pz.getFruits()+"個");
					// System.out.println(pz.getDistance()+"km歩いた．");
					pz.MoveMsg();
				}else{
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		pz.BallLostMsg();
	}
}
