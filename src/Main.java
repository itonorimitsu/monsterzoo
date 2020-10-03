

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

		for(int i=0;i<pz.getUserMonster().length;i++){
			if(pz.getUserMonster()[i]!=null){
				System.out.println(pz.getUserMonster()[i]+"を捕まえた．");
			}
		}
	}

	//テスト用のモンスターデータを登録するメソッド
	public static void setMonsterZukan(){
		// ここを全てListに置き換える
		// String tempMonster[] = new String[22];
		ArrayList<String> tempMonster = new tempMonster<String>();
		// double tempMonsterRare[] = new double[22];
		ArrayList<Double> tempMonsterRare = new tempMonsterRare<Double>();
		// tempMonster[0]="イガキン";	tempMonsterRare[0]=9;
		// tempMonster[1]="ナマチュウ";	tempMonsterRare[1]=3;
		// tempMonster[2]="イノウエン";	tempMonsterRare[2]=1;
		// tempMonster[3]="リョージィ";	tempMonsterRare[3]=2;
		// tempMonster[4]="アキモトン";	tempMonsterRare[4]=5;
		// tempMonster[5]="ゴージマ";	tempMonsterRare[5]=4;
		// tempMonster[6]="チュウデン";	tempMonsterRare[6]=6;
		// tempMonster[7]="ヅカホン";	tempMonsterRare[7]=8;
		// tempMonster[8]="ニシムラー";	tempMonsterRare[8]=7;
		// tempMonster[9]="サコーデン";	tempMonsterRare[9]=2;
		// tempMonster[10]="ウッチー";	tempMonsterRare[10]=5;
		// tempMonster[11]="ハヤッシー";	tempMonsterRare[11]=4;
		// tempMonster[12]="キーチー";	tempMonsterRare[12]=3;
		// tempMonster[13]="リョクン";	tempMonsterRare[13]=1;
		// tempMonster[14]="デコポン";	tempMonsterRare[14]=6;
		// tempMonster[15]="カミサン";	tempMonsterRare[15]=5;
		// tempMonster[16]="シスイ";	tempMonsterRare[16]=1;
		// tempMonster[17]="ジョナ";	tempMonsterRare[17]=7;
		// tempMonster[18]="ギダギダ";	tempMonsterRare[18]=2;
		// tempMonster[19]="ミッツー";	tempMonsterRare[19]=8;
		// tempMonster[20]="ゾエサン";	tempMonsterRare[20]=5;
		// tempMonster[21]="キタバー";	tempMonsterRare[21]=3;

		tempMonster.set(0, "イガキン");	tempMonsterRare.set(0, 9);
		tempMonster.set(1, "ナマチュウ");	tempMonsterRare.set(1, 3);
		tempMonster.set(2, "イノウエン");	tempMonsterRare.set(2, 1);
		tempMonster.set(3, "リョージィ");	tempMonsterRare.set(3, 2);
		tempMonster.set(4, "アキモトン");	tempMonsterRare.set(4, 5);
		tempMonster.set(5, "ゴージマ");	tempMonsterRare.set(5, 4);
		tempMonster.set(6, "チュウデン");	tempMonsterRare.set(6, 6);
		tempMonster.set(7, "ヅカホン");	tempMonsterRare.set(7, 8)
		tempMonster.set(8, "ニシムラー");	tempMonsterRare.set(8, 7);
		tempMonster.set(9, "サコーデン");	tempMonsterRare.set(9, 2);
		tempMonster.set(10, "ウッチー");	tempMonsterRare.set(10, 5);
		tempMonster.set(11, "ハヤッシー");	tempMonsterRare.set(11, 4);
		tempMonster.set(12, "キーチー");	tempMonsterRare.set(12, 3);
		tempMonster.set(13, "リョクン");	tempMonsterRare.set(13, 1);
		tempMonster.set(14, "デコポン");	tempMonsterRare.set(14, 6);
		tempMonster.set(15, "カミサン");	tempMonsterRare.set(15, 5);
		tempMonster.set(16, "シスイ");	tempMonsterRare.set(16, 1);
		tempMonster.set(17, "ジョナ");	tempMonsterRare.set(17, 7);
		tempMonster.set(18, "ギダギダ");	tempMonsterRare.set(18, 2);
		tempMonster.set(19, "ミッツー");	tempMonsterRare.set(19, 8);
		tempMonster.set(20, "ゾエサン");	tempMonsterRare.set(20, 5);
		tempMonster.set(21, "キタバー");	tempMonsterRare.set(21, 3);

		pz.setMonsterZukan(tempMonster);
		pz.setMonsterRare(tempMonsterRare);
	}

}
