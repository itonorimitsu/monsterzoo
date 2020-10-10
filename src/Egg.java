import java.util.ArrayList;

//卵は最大9個まで持てる．卵を取得するとeggにtrueが代入され，
//移動するたびに,eggDistanceに1.0kmずつ加算される．
//3km移動するとランダムでモンスターが孵る

public class Egg {
    ArrayList<Double> eggDistance = new ArrayList<Double>();
    ArrayList<Boolean> egg = new ArrayList<Boolean>();
}