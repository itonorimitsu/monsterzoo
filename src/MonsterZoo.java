/// 出力の部分はメソッド化でいいのでは？
import java.util.ArrayList;
import java.util.stream.*;


public class MonsterZoo {
	// double distance=0.0;//歩いた距離
	// int balls=10;//モンスターを捕まえられるボールの数
	// int fruits=0;//ぶつけるとモンスターが捕まえやすくなるフルーツ

	//卵は最大9個まで持てる．卵を取得するとeggにtrueが代入され，
	//移動するたびに,eggDistanceに1.0kmずつ加算される．
	//3km移動するとランダムでモンスターが孵る
	// double eggDistance[] = new double[9];
	// ArrayList<Double> eggDistance = new ArrayList<Double>();

	// boolean egg[] = new boolean[9];
	// ArrayList<Boolean> egg = new ArrayList<Boolean>();

	//　ユーザがGetしたモンスター一覧
	// String userMonster[] = new String[100];
	// Monsterへ移動
	// ArrayList<String> userMonster = new ArrayList<String>();

	//モンスター図鑑．モンスターの名前とレア度(0.0~9.0)がそれぞれの配列に保存されている
	//レア度が高いほうが捕まえにくい
	// String monsterZukan[] = new String[22];
	// ArrayList<String> monsterZukan = new ArrayList<String>();

	//double monsterRare[] = new double[22];
	// ArrayList<Double> monsterRare = new ArrayList<Double>();

	// static ZooStation Zs = new ZooStation();
	// static BallFruitsEgg StationBFE = new BallFruitsEgg();
	static Move move = new Move();
	
	public int flg1;

	//呼び出すと1km distanceが増える
	void Main(){
		// this.distance++;
		move.MoveMain();
		this.MakeFlag();
		this.BranchFlag();

		// if(flg1<=1){
		// 	// zs.BallFruits bf = new zs.BallFruits();
		// 	// this.StationBFE = Zs.Main();

		// 	mons.ZooStationStart();

		// }else if(flg1>=7){
		// 	mons.CaptureMain();
		// 	//  ここもメソッド毎に分割する
		// 	// int m = (int)(this.monsterZukan.size()*Math.random());//monsterZukanからランダムにモンスターを出す
		// 	// System.out.println(this.monsterZukan.get(m)+"が現れた！");
		// 	// // for(int i=0;i<3&&this.balls>0;i++){//捕まえる or 3回ボールを投げるまで繰り返す
		// 	// IntStream.range(0, 3).filter(i -> this.balls>0).forEach(i -> {
		// 	// 	int r = (int)(6*Math.random());//0~5までの数字をランダムに返す
		// 	// 		if(this.fruits>0){
		// 	// 			System.out.println("フルーツを投げた！捕まえやすさが倍になる！");
		// 	// 			this.fruits--;
		// 	// 			r = r * 2;
		// 	// 		}
		// 	// 	System.out.println(this.monsterZukan.get(m) + "にボールを投げた");
		// 	// 	this.balls--;
		// 	// 	// if(this.monsterRare[m]<=r){//monsterRare[m]の値がr以下の場合
		// 	// 	if (this.monsterRare.get(m)<=r){
		// 	// 		System.out.println(this.monsterZukan.get(m)+"を捕まえた！");
		// 	// 		IntStream.range(0, userMonster.size()).filter(j -> this.userMonster.get(m) == null).findFirst().ifPresent(j -> {
		// 	// 			this.userMonster.set(m, this.monsterZukan.get(m));
		// 	// 		});
		// 	// 		break;//ボール投げ終了
		// 	// 	}else{
		// 	// 		System.out.println(this.monsterZukan.get(m)+"に逃げられた！");
		// 	// 	}
		// 	// });
		// }
		// // IntStream.range(0, this.egg.size()).forEach(i -> {
		// // 	if(this.egg.get(i)==true&&this.eggDistance.get(i)>=3){
		// // 		System.out.println("卵が孵った！");
		// // 		int m = (int)(this.monsterZukan.size()*Math.random());
		// // 		System.out.println(this.monsterZukan.get(i)+"が産まれた！");

		// // 		IntStream.range(0, userMonster.size()).filter(j -> this.userMonster.get(j) == null).findFirst().ifPresent(j -> {
		// // 			this.userMonster.set(j, this.monsterZukan.get(m));
		// // 		});

		// // 		this.egg.set(i, false);
		// // 		this.eggDistance.set(i, 0.0);
		// // 	}		
		// // });
	}

	private void MakeFlag() {
		//0,1の場合はズーstation，7~9の場合はモンスター
		this.flg1 = (int)(Math.random()*10);
	}

	private void BranchFlag() {
		if (this.flg1 <= 1) {
			move.ZooStationStart();
		} else if (this.flg1 >= 7) {
			move.CaptureMain();
		}
		move.EggStream();
	}

	public void MoveMsg() {
		move.MoveMsg();
	}

	public void BallLostMsg() {
		move.BallLostMsg();
	}

	public int BallCount() {
		return move.BallCount();
	}


// この辺りにgetterとsetterを使っているので変換
	// public double getDistance() {
	// 	return distance;
	// }

	// public int getBalls() {
	// 	return balls;
	// }

	// public int getFruits() {
	// 	return fruits;
	// }

	// public ArrayList<String> getUserMonster() {
	// 	return userMonster;
	// }

	// // monsterZukanから初期値をもらっている？
	// public void setMonsterZukan(ArrayList<String> monsterZukan) {
	// 	this.monsterZukan = monsterZukan;
	// }


	// public void setMonsterRare(ArrayList<Double> monsterRare) {
	// 	this.monsterRare = monsterRare;
	// }
}