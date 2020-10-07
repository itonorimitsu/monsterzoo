import java.util.ArrayList;
import java.util.stream.*;

public class Main {
	static MonsterZoo pz = new MonsterZoo();

	public static void main(String[] args) {

		setMonsterZukan();

		//1000ミリ秒（1秒）ずつ止まりながらpz.move()を呼び出し続ける
		//手持ちのボールが無くなったら終了
		while(true){
			try {
				Thread.sleep(1000);
				if(pz.getBalls()>0){
					/// このあたりは確実に変更
					pz.move();
					System.out.println("手持ちのボールは"+pz.getBalls()+"個，フルーツは"+pz.getFruits()+"個");
					System.out.println(pz.getDistance()+"km歩いた．");
				}else{
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("ボールがなくなった！");
		IntStream.range(0, pz.getUserMonster().size()).filter(i -> pz.getUserMonster().get(i)!=null).findFirst().ifPresent(i -> {
			System.out.println(pz.getUserMonster().get(i)+"を捕まえた．");
		});
	}

	//テスト用のモンスターデータを登録するメソッド
	public static void setMonsterZukan(){
		ArrayList<String> tempMonster = new ArrayList<String>();
		ArrayList<Double> tempMonsterRare = new ArrayList<Double>();

		tempMonster.set(0, "イガキン");	tempMonsterRare.set(0, 9.0);
		tempMonster.set(1, "ナマチュウ");	tempMonsterRare.set(1, 3.0);
		tempMonster.set(2, "イノウエン");	tempMonsterRare.set(2, 1.0);
		tempMonster.set(3, "リョージィ");	tempMonsterRare.set(3, 2.0);
		tempMonster.set(4, "アキモトン");	tempMonsterRare.set(4, 5.0);
		tempMonster.set(5, "ゴージマ");	tempMonsterRare.set(5, 4.0);
		tempMonster.set(6, "チュウデン");	tempMonsterRare.set(6, 6.0);
		tempMonster.set(7, "ヅカホン");	tempMonsterRare.set(7, 8.0);
		tempMonster.set(8, "ニシムラー");	tempMonsterRare.set(8, 7.0);
		tempMonster.set(9, "サコーデン");	tempMonsterRare.set(9, 2.0);
		tempMonster.set(10, "ウッチー");	tempMonsterRare.set(10, 5.0);
		tempMonster.set(11, "ハヤッシー");	tempMonsterRare.set(11, 4.0);
		tempMonster.set(12, "キーチー");	tempMonsterRare.set(12, 3.0);
		tempMonster.set(13, "リョクン");	tempMonsterRare.set(13, 1.0);
		tempMonster.set(14, "デコポン");	tempMonsterRare.set(14, 6.0);
		tempMonster.set(15, "カミサン");	tempMonsterRare.set(15, 5.0);
		tempMonster.set(16, "シスイ");	tempMonsterRare.set(16, 1.0);
		tempMonster.set(17, "ジョナ");	tempMonsterRare.set(17, 7.0);
		tempMonster.set(18, "ギダギダ");	tempMonsterRare.set(18, 2.0);
		tempMonster.set(19, "ミッツー");	tempMonsterRare.set(19, 8.0);
		tempMonster.set(20, "ゾエサン");	tempMonsterRare.set(20, 5.0);
		tempMonster.set(21, "キタバー");	tempMonsterRare.set(21, 3.0);

		pz.setMonsterZukan(tempMonster);
		pz.setMonsterRare(tempMonsterRare);
	}

}
