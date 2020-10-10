import java.util.ArrayList;
import java.util.stream.*;

public class Main {
	static MonsterZoo pz = new MonsterZoo();
	static MonsterZukan zukan = new MonsterZukan();

	public static void main(String[] args) {
		//1000ミリ秒（1秒）ずつ止まりながらpz.move()を呼び出し続ける
		//手持ちのボールが無くなったら終了
		while(true){
			try {
				Thread.sleep(100);
				if(pz.BallCount()>0){
					pz.Main();
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
