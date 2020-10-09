import java.util.ArrayList;
import java.util.stream.*;

public class Move {
    // Monster図鑑
    static MonsterZukan mz = new MonsterZukan();

    static Egg e = new Egg();

    // ユーザの持っているモンスター一覧
    ArrayList<String> userMonster = new ArrayList<String>();


    static BallFruitsDistance BFD = new BallFruitsDistance();

    private int MonsterID;

    private int r;

    private Boolean flag = false;


    // Moveでの最初の処理
    public void MoveMain() {
        DistanceAdd();
    }

// flag>=7のときのモンスターとの遭遇時の処理
    public void CaptureMain() {
        // this.BFE = BFE;
        EncountMsg();
        //ここで集約する
        BattleMons();
    }

    private void EncountMsg(){
        this.MonsterID = RandomMonster();
        System.out.println(mz.tempMonster.get(this.MonsterID)+"が現れた！");
    }

    private int RandomMonster() {
        //monsterZukanからランダムにモンスターを出す
        return (int)(mz.tempMonster.size()*Math.random());
    }

    private void BattleMons() {
        // このflagがbreakの代わりのつもり(絶対よくないけど)
        IntStream.range(0, 3).filter(i -> BFD.Ball>0).filter(i -> this.flag == false).forEach(i -> {
            this.r = RandomNum();
            FruitsUse();
            BallThrows();
            this.flag = MonsterCapture();
        });
    }

    //0~5までの数字をランダムに返す
    private int RandomNum() {
        return (int)(6*Math.random());
    }

    private void FruitsUse() {
        if(BFD.Fruits > 0) {
            System.out.println("フルーツを投げた！捕まえやすさが倍になる！");
            BFD.Fruits--;
            this.r = this.r * 2;
        }
    }

    private void BallThrows(){
        System.out.println(mz.tempMonster.get(this.MonsterID) + "にボールを投げた");
        BFD.Ball--;
    }

    // true/falseを返すようにする、判定メソッド
    private Boolean MonsterCapture() {
        if (mz.tempMonsterRare.get(this.MonsterID) <= this.r) {
            // break;
            GetMonster();
            return true;
        } else {
            EscapeMsg();
            return false;
        }
    }

    private void GetMonster() {
        CaptureMsg();
        // ここわからん.foreachいる？
        IntStream.range(0, userMonster.size()).filter(j -> this.userMonster.get(j) == null).findFirst().ifPresent(j -> {
            this.userMonster.set(j, mz.tempMonster.get(this.MonsterID));
        });
    }

    private void CaptureMsg() {
        System.out.println(mz.tempMonster.get(this.MonsterID)+"を捕まえた！");
    }

    private void EscapeMsg() {
        System.out.println(mz.tempMonster.get(this.MonsterID)+"に逃げられた！");
    }

// 卵判定の部分
    public void EggStream() {
        IntStream.range(0, e.egg.size()).filter(i -> e.egg.get(i) == true).filter(i -> e.eggDistance.get(i)>=3).forEach(i -> {
            EggMsgs();
            RegiMons();
            EggHatchOut(i);
        });
    }

// 卵のメッセージ
    private void EggMsgs() {
        System.out.println("卵が孵った！");
        this.MonsterID = RandomMonster();
        System.out.println(mz.tempMonster.get(this.MonsterID)+"が産まれた！");
    }

    // 卵から孵ったモンスターを登録する
    private void RegiMons() {
        IntStream.range(0, this.userMonster.size()).filter(j -> this.userMonster.get(j) == null).findFirst().ifPresent(j -> {
            this.userMonster.set(j, mz.tempMonster.get(this.MonsterID));
        });
    }

    // 卵が孵った時の処理(flag外の部分)
    private void EggHatchOut(int i) {
        e.egg.remove(i+1);
        e.eggDistance.remove(i+1);
    }



// flag<=1の時の処理
    public void ZooStationStart() {
        FindMsg();
        RandomValuesInit();
        ResultMsg();
        EggResult();
    }

    //見つけたメッセージを出力
    private static void FindMsg() {
        System.out.println("ズーstationを見つけた！");
    }

    private static void DistanceAdd() {
        BFD.Distance++;
    }

    private void ResultMsg() {
        System.out.println("ボールを"+BFD.Ball+"個，"+"フルーツを"+BFD.Fruits+"個"+"卵を"+BFD.Egg+"個Getした！");
    }

    private int BallRandom() {
        return (int)(Math.random()*3);
    }

    private int FruitsAndEggRandom() {
        return (int)(Math.random()*2);
    }

    private void RandomValuesInit() {
        BFD.Ball = BallRandom();
        BFD.Fruits = FruitsAndEggRandom();
        BFD.Egg = FruitsAndEggRandom();
    }

    private void EggResult() {
        if (BFD.Egg>=1) {
            IntStream.range(0, BFD.Egg).filter(i -> e.egg.size()<10).findFirst().ifPresent(i -> {
                GetEggSetup();
            });
        }
    }

    private void GetEggSetup() {
		e.egg.add(true);
		e.eggDistance.add(0.0);
    }


}


    //Station時のメインメソッド 
    // public BallFruitsEgg Main() {
    //     ZooStationStart();
    //     return getItems();
    // }

    // public BallFruitsEgg getItems() {
    //     // BallFruits bf = new BallFruits();
    //     BFE.Ball = this.ball;
    //     BFE.Fruits = this.fruits;
    //     BFE.Egg = this.egg;
    //     return BFE;
    // }




    // private void BallThrows() {
    //     IntStream.range(0, 3).filter(i -> this.balls>0).forEach(i -> {
	// 			// int r = (int)(6*Math.random());//0~5までの数字をランダムに返す
	// 				// if(this.fruits>0){
	// 				// 	System.out.println("フルーツを投げた！捕まえやすさが倍になる！");
	// 				// 	this.fruits--;
	// 				// 	r = r * 2;
	// 				// }
	// 			// System.out.println(this.monsterZukan.get(m) + "にボールを投げた");
	// 			// this.balls--;

	// 			// if(this.monsterRare[m]<=r){//monsterRare[m]の値がr以下の場合
	// 			if (this.monsterRare.get(m)<=r){
	// 				System.out.println(this.monsterZukan.get(m)+"を捕まえた！");
	// 				break;//ボール投げ終了
	// 			}else{
	// 				System.out.println(this.monsterZukan.get(m)+"に逃げられた！");
	// 			}
	// 		});
    // }			