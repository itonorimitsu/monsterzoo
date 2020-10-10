import java.util.ArrayList;
import java.util.stream.*;

//卵は最大9個まで持てる．卵を取得するとeggにtrueが代入され，
//移動するたびに,eggDistanceに1.0kmずつ加算される．
//3km移動するとランダムでモンスターが孵る

public class Egg {
    ArrayList<Double> eggDistance = new ArrayList<Double>();
    ArrayList<Boolean> egg = new ArrayList<Boolean>();

    public Egg() {
        System.out.println("初期化");
        this.EggInit();
        this.EggDistanceInit();
    }

// egg内の初期化
    public void EggInit() {
        System.out.println("初期化");
        IntStream.range(0, 9).forEach(i -> {
            egg.add(false);
        });
    }

// eggDistanceの初期化
    public void EggDistanceInit() {
        IntStream.range(0, 9).forEach(i -> {
            eggDistance.add(0.0);
        });
    }
}