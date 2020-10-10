import java.util.ArrayList;
import java.util.stream.*;

public class Move {
    // Monster図鑑
    static MonsterZukan mz = new MonsterZukan();

    static Egg e = new Egg();

    // ユーザの持っているモンスター一覧
    ArrayList<String> userMonster = new ArrayList<String>();


    static BallFruitsDistance BFD = new BallFruitsDistance();
    static BallFruitsDistance stationBFD = new BallFruitsDistance();

    private int MonsterID;

    private int r;

    private Boolean flag = false;


    // Moveでの最初の処理
    public void MoveMain() {
        DistanceAdd();
        EggDistanceAdd();
    }

    private void EggDistanceAdd() {
        IntStream.range(0, e.egg.size()).forEach(i -> {
            e.eggDistance.set(i, e.eggDistance.get(i)+1);
        });
    }

// flag>=7のときのモンスターとの遭遇時の処理
    public void CaptureMain() {
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
        this.flag = false;
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
            GetMonster();
            return true;
        } else {
            EscapeMsg();
            return false;
        }
    }

// ここもっと綺麗にできる。
    private void GetMonster() {
        CaptureMsg();
        this.userMonster.add(mz.tempMonster.get(this.MonsterID));
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
            System.out.println(i);
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
        this.userMonster.add(mz.tempMonster.get(this.MonsterID));
    }

    // 卵が孵った時の処理(flag外の部分)
    private void EggHatchOut(int i) {
        e.egg.set(i, false);
        e.eggDistance.set(i, 0.0);
    }

// flag<=1の時の処理
    public void ZooStationStart() {
        FindMsg();
        RandomValuesInit();
        ItemGet();
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
        System.out.println("ボールを"+stationBFD.Ball+"個，"+"フルーツを"+stationBFD.Fruits+"個"+"卵を"+stationBFD.Egg+"個Getした！");
    }

    private int BallRandom() {
        return (int)(Math.random()*3);
    }

    private int FruitsAndEggRandom() {
        return (int)(Math.random()*2);
    }

    private void RandomValuesInit() {
        stationBFD.Ball = BallRandom();
        stationBFD.Fruits = FruitsAndEggRandom();
        stationBFD.Egg = FruitsAndEggRandom();
    }

    private void ItemGet() {
        BFD.Ball += stationBFD.Ball;
        BFD.Fruits += stationBFD.Fruits;
        BFD.Egg += stationBFD.Egg;
    }

    private void EggResult() {
        if (stationBFD.Egg>=1) {
            IntStream.range(0, stationBFD.Egg).filter(i -> e.egg.size()<10).filter(i -> e.egg.get(i) == false).findFirst().ifPresent(i -> {
                GetEggSetup(i);
            });
        }
    }

    private void GetEggSetup(int i) {
		e.egg.set(i, true);
		e.eggDistance.set(i, 0.0);
    }

    public void MoveMsg() {
        System.out.println("手持ちのボールは"+BFD.Ball+"個，フルーツは"+BFD.Fruits+"個");
        System.out.println(BFD.Distance+"km歩いた．");
    }

    public void BallLostMsg() {
		IntStream.range(0, this.userMonster.size()).filter(i -> this.userMonster.get(i)!=null).forEach(i -> {
			System.out.println(this.userMonster.get(i)+"を捕まえた．");
		});
    }

    public int BallCount() {
        return BFD.Ball;
    }
}
